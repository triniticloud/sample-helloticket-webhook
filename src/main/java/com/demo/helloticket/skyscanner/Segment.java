
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "OriginStation",
    "DestinationStation",
    "DepartureDateTime",
    "ArrivalDateTime",
    "Carrier",
    "OperatingCarrier",
    "Duration",
    "FlightNumber",
    "JourneyMode",
    "Directionality"
})
public class Segment implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("OriginStation")
    private int originStation;
    @JsonProperty("DestinationStation")
    private int destinationStation;
    @JsonProperty("DepartureDateTime")
    private String departureDateTime;
    @JsonProperty("ArrivalDateTime")
    private String arrivalDateTime;
    @JsonProperty("Carrier")
    private int carrier;
    @JsonProperty("OperatingCarrier")
    private int operatingCarrier;
    @JsonProperty("Duration")
    private int duration;
    @JsonProperty("FlightNumber")
    private String flightNumber;
    @JsonProperty("JourneyMode")
    private String journeyMode;
    @JsonProperty("Directionality")
    private String directionality;

    @JsonProperty("Id")
    public int getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("OriginStation")
    public int getOriginStation() {
        return originStation;
    }

    @JsonProperty("OriginStation")
    public void setOriginStation(int originStation) {
        this.originStation = originStation;
    }

    @JsonProperty("DestinationStation")
    public int getDestinationStation() {
        return destinationStation;
    }

    @JsonProperty("DestinationStation")
    public void setDestinationStation(int destinationStation) {
        this.destinationStation = destinationStation;
    }

    @JsonProperty("DepartureDateTime")
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    @JsonProperty("DepartureDateTime")
    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    @JsonProperty("ArrivalDateTime")
    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    @JsonProperty("ArrivalDateTime")
    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    @JsonProperty("Carrier")
    public int getCarrier() {
        return carrier;
    }

    @JsonProperty("Carrier")
    public void setCarrier(int carrier) {
        this.carrier = carrier;
    }

    @JsonProperty("OperatingCarrier")
    public int getOperatingCarrier() {
        return operatingCarrier;
    }

    @JsonProperty("OperatingCarrier")
    public void setOperatingCarrier(int operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    @JsonProperty("Duration")
    public int getDuration() {
        return duration;
    }

    @JsonProperty("Duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty("FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    @JsonProperty("FlightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @JsonProperty("JourneyMode")
    public String getJourneyMode() {
        return journeyMode;
    }

    @JsonProperty("JourneyMode")
    public void setJourneyMode(String journeyMode) {
        this.journeyMode = journeyMode;
    }

    @JsonProperty("Directionality")
    public String getDirectionality() {
        return directionality;
    }

    @JsonProperty("Directionality")
    public void setDirectionality(String directionality) {
        this.directionality = directionality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("originStation", originStation).append("destinationStation", destinationStation).append("departureDateTime", departureDateTime).append("arrivalDateTime", arrivalDateTime).append("carrier", carrier).append("operatingCarrier", operatingCarrier).append("duration", duration).append("flightNumber", flightNumber).append("journeyMode", journeyMode).append("directionality", directionality).toString();
    }

}
