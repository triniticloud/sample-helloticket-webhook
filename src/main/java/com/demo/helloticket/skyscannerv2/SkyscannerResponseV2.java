
package com.demo.helloticket.skyscannerv2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Quotes", "Places", "Carriers", "Currencies"})
public class SkyscannerResponseV2 implements Serializable {

    @JsonProperty("Quotes")
    private List<Quote> quotes = null;
    @JsonProperty("Places")
    private List<Place> places = null;
    @JsonProperty("Carriers")
    private List<Carrier> carriers = null;
    @JsonProperty("Currencies")
    private List<Currency> currencies = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3526053541132326521L;

    @JsonIgnore
    public <T> T get(String id, Class<T> clazz) {
        Object object = null;
        if (clazz == Place.class) {
            int i = Integer.parseInt(id);
            object = places.parallelStream().filter(p -> p.getPlaceId() == i).findFirst().orElse(null);
        } else if (clazz == Currency.class) {
            object = currencies.parallelStream().filter(p -> p.getCode().equals(id)).findFirst().orElse(null);
        } else if (clazz == Carrier.class) {
            int i = Integer.parseInt(id);
            object = carriers.parallelStream().filter(p -> p.getCarrierId() == i).findFirst().orElse(null);
        }
        return (T) object;
    }

    @JsonProperty("Quotes")
    public List<Quote> getQuotes() {
        return quotes;
    }

    @JsonProperty("Quotes")
    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @JsonProperty("Places")
    public List<Place> getPlaces() {
        return places;
    }

    @JsonProperty("Places")
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @JsonProperty("Carriers")
    public List<Carrier> getCarriers() {
        return carriers;
    }

    @JsonProperty("Carriers")
    public void setCarriers(List<Carrier> carriers) {
        this.carriers = carriers;
    }

    @JsonProperty("Currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    @JsonProperty("Currencies")
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
