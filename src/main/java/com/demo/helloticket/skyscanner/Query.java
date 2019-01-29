
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Country",
    "Currency",
    "Locale",
    "Adults",
    "Children",
    "Infants",
    "OriginPlace",
    "DestinationPlace",
    "OutboundDate",
    "LocationSchema",
    "CabinClass",
    "GroupPricing"
})
public class Query implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Locale")
    private String locale;
    @JsonProperty("Adults")
    private int adults;
    @JsonProperty("Children")
    private int children;
    @JsonProperty("Infants")
    private int infants;
    @JsonProperty("OriginPlace")
    private String originPlace;
    @JsonProperty("DestinationPlace")
    private String destinationPlace;
    @JsonProperty("OutboundDate")
    private String outboundDate;
    @JsonProperty("LocationSchema")
    private String locationSchema;
    @JsonProperty("CabinClass")
    private String cabinClass;
    @JsonProperty("GroupPricing")
    private boolean groupPricing;

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("Locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("Locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("Adults")
    public int getAdults() {
        return adults;
    }

    @JsonProperty("Adults")
    public void setAdults(int adults) {
        this.adults = adults;
    }

    @JsonProperty("Children")
    public int getChildren() {
        return children;
    }

    @JsonProperty("Children")
    public void setChildren(int children) {
        this.children = children;
    }

    @JsonProperty("Infants")
    public int getInfants() {
        return infants;
    }

    @JsonProperty("Infants")
    public void setInfants(int infants) {
        this.infants = infants;
    }

    @JsonProperty("OriginPlace")
    public String getOriginPlace() {
        return originPlace;
    }

    @JsonProperty("OriginPlace")
    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    @JsonProperty("DestinationPlace")
    public String getDestinationPlace() {
        return destinationPlace;
    }

    @JsonProperty("DestinationPlace")
    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    @JsonProperty("OutboundDate")
    public String getOutboundDate() {
        return outboundDate;
    }

    @JsonProperty("OutboundDate")
    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    @JsonProperty("LocationSchema")
    public String getLocationSchema() {
        return locationSchema;
    }

    @JsonProperty("LocationSchema")
    public void setLocationSchema(String locationSchema) {
        this.locationSchema = locationSchema;
    }

    @JsonProperty("CabinClass")
    public String getCabinClass() {
        return cabinClass;
    }

    @JsonProperty("CabinClass")
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    @JsonProperty("GroupPricing")
    public boolean isGroupPricing() {
        return groupPricing;
    }

    @JsonProperty("GroupPricing")
    public void setGroupPricing(boolean groupPricing) {
        this.groupPricing = groupPricing;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("country", country).append("currency", currency).append("locale", locale).append("adults", adults).append("children", children).append("infants", infants).append("originPlace", originPlace).append("destinationPlace", destinationPlace).append("outboundDate", outboundDate).append("locationSchema", locationSchema).append("cabinClass", cabinClass).append("groupPricing", groupPricing).toString();
    }

}
