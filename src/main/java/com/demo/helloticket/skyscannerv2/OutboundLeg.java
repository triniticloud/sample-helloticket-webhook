
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
@JsonPropertyOrder({
    "CarrierIds",
    "OriginId",
    "DestinationId",
    "DepartureDate"
})
public class OutboundLeg implements Serializable
{

    @JsonProperty("CarrierIds")
    private List<Integer> carrierIds = null;
    @JsonProperty("OriginId")
    private int originId;
    @JsonProperty("DestinationId")
    private int destinationId;
    @JsonProperty("DepartureDate")
    private String departureDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2500075137442095563L;

    @JsonProperty("CarrierIds")
    public List<Integer> getCarrierIds() {
        return carrierIds;
    }

    @JsonProperty("CarrierIds")
    public void setCarrierIds(List<Integer> carrierIds) {
        this.carrierIds = carrierIds;
    }

    @JsonProperty("OriginId")
    public int getOriginId() {
        return originId;
    }

    @JsonProperty("OriginId")
    public void setOriginId(int originId) {
        this.originId = originId;
    }

    @JsonProperty("DestinationId")
    public int getDestinationId() {
        return destinationId;
    }

    @JsonProperty("DestinationId")
    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @JsonProperty("DepartureDate")
    public String getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("DepartureDate")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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
