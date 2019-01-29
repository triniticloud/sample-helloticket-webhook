package com.demo.helloticket.skyscanner.service;

import com.demo.helloticket.skyscanner.PlaceDetails;
import com.demo.helloticket.skyscanner.PlaceResponse;
import com.demo.helloticket.skyscanner.SkyscannerResponse;
import com.demo.helloticket.skyscannerv2.SkyscannerResponseV2;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * SkyscannerService
 */
@Service
public class SkyscannerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkyscannerService.class);
    private static final String X_RAPID_API_KEY = "X-RapidAPI-Key";
    private static final String RAPID_API_SECRET = "d8eaa32c3emsh2ce83b6ece18246p1761e1jsna3bbe0f3e7b8";

    @Cacheable(value = "getPlaceId")
    public String getPlaceId(String place) {
        try {
            HttpResponse<PlaceResponse> response = Unirest
                    .get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/SG/SGD/en-SG/?query="
                            + place)
                    .header(X_RAPID_API_KEY, RAPID_API_SECRET).asObject(PlaceResponse.class);
            LOGGER.debug("{} : {}", response.getStatusText(), response.getBody());
            if (response.getStatus() == 200)
                return response.getBody().getPlaces().stream().map(PlaceDetails::getPlaceId).findFirst().orElse(null);
        } catch (UnirestException e) {
            LOGGER.error("Error extracting place id for " + place, e);
        }
        return null;
    }

    @Cacheable(value = "extractLocationForPricing")
    public String extractLocationForPricing(String source, String destination, String seatCategory, String travelDate)
            throws UnirestException {
       // @formatter:off
        HttpResponse<JsonNode> pricingResponse = Unirest.post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
            .header(X_RAPID_API_KEY, RAPID_API_SECRET)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .field("cabinClass", seatCategory)
            .field("children", 0)
            .field("infants", 0)
            .field("groupPricing", "false")
            .field("country", "SG")
            .field("currency", "SGD")
            .field("locale", "en-US")
            .field("originPlace", source)
            .field("destinationPlace", destination)
            .field("outboundDate", travelDate)
            .field("adults", 1)
            .asJson();
         // @formatter:on
        if (!pricingResponse.getHeaders().containsKey("Location")) {
            return "error:" + pricingResponse.getBody();
        }
        String[] locationHeader = pricingResponse.getHeaders().getFirst("Location").split("/");
        return locationHeader[locationHeader.length - 1];
    }

    @Cacheable(value = "getSkyscannerResponse")
    public SkyscannerResponse getSkyscannerResponse(String location) throws UnirestException {
        // @formatter:off
        HttpResponse<SkyscannerResponse> response2 = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/"+ 
            location+"?sortType=price&sortOrder=asc&stops=0&pageIndex=0&pageSize=10")
            .header(X_RAPID_API_KEY, RAPID_API_SECRET)
            .asObject(SkyscannerResponse.class);
            // @formatter:on
        return response2.getBody();
    }

    @Cacheable(value = "getSkyscannerResponseV2")
    public SkyscannerResponseV2 getSkyscannerResponseV2(String source, String destination, String seatCategory, String travelDate)
            throws UnirestException {
        HttpResponse<SkyscannerResponseV2> skyscannerResponseV2 = Unirest
                .get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/SG/SGD/en-SG/" + source
                        + "/" + destination + "/" + travelDate)
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header(X_RAPID_API_KEY, RAPID_API_SECRET).asObject(SkyscannerResponseV2.class);
        return skyscannerResponseV2.getBody();
    }

}
