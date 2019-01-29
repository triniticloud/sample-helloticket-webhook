
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FlightNumber",
    "CarrierId"
})
public class FlightNumber implements Serializable {

    private static final long serialVersionUID = -6619814137437168737L;
    
    @JsonProperty("FlightNumber")
    private String flightNumber;
    @JsonProperty("CarrierId")
    private int carrierId;

    @JsonProperty("FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("FlightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("CarrierId")
    public int getCarrierId() {
        return carrierId;
    }

    @JsonProperty("CarrierId")
    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("flightNumber", flightNumber).append("carrierId", carrierId).toString();
    }

}
