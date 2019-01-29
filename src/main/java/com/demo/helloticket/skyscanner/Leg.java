
package com.demo.helloticket.skyscanner;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "SegmentIds",
    "OriginStation",
    "DestinationStation",
    "Departure",
    "Arrival",
    "Duration",
    "JourneyMode",
    "Stops",
    "Carriers",
    "OperatingCarriers",
    "Directionality",
    "FlightNumbers"
})
public class Leg implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Id")
    private String id;
    @JsonProperty("SegmentIds")
    private List<Integer> segmentIds = null;
    @JsonProperty("OriginStation")
    private int originStation;
    @JsonProperty("DestinationStation")
    private int destinationStation;
    @JsonProperty("Departure")
    private String departure;
    @JsonProperty("Arrival")
    private String arrival;
    @JsonProperty("Duration")
    private int duration;
    @JsonProperty("JourneyMode")
    private String journeyMode;
    @JsonProperty("Stops")
    private List<Object> stops = null;
    @JsonProperty("Carriers")
    private List<Integer> carriers = null;
    @JsonProperty("OperatingCarriers")
    private List<Integer> operatingCarriers = null;
    @JsonProperty("Directionality")
    private String directionality;
    @JsonProperty("FlightNumbers")
    private List<FlightNumber> flightNumbers = null;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("SegmentIds")
    public List<Integer> getSegmentIds() {
        return segmentIds;
    }

    @JsonProperty("SegmentIds")
    public void setSegmentIds(List<Integer> segmentIds) {
        this.segmentIds = segmentIds;
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

    @JsonProperty("Departure")
    public String getDeparture() {
        return departure;
    }

    @JsonProperty("Departure")
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @JsonProperty("Arrival")
    public String getArrival() {
        return arrival;
    }

    @JsonProperty("Arrival")
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("Duration")
    public int getDuration() {
        return duration;
    }

    @JsonProperty("Duration")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonProperty("JourneyMode")
    public String getJourneyMode() {
        return journeyMode;
    }

    @JsonProperty("JourneyMode")
    public void setJourneyMode(String journeyMode) {
        this.journeyMode = journeyMode;
    }

    @JsonProperty("Stops")
    public List<Object> getStops() {
        return stops;
    }

    @JsonProperty("Stops")
    public void setStops(List<Object> stops) {
        this.stops = stops;
    }

    @JsonProperty("Carriers")
    public List<Integer> getCarriers() {
        return carriers;
    }

    @JsonProperty("Carriers")
    public void setCarriers(List<Integer> carriers) {
        this.carriers = carriers;
    }

    @JsonProperty("OperatingCarriers")
    public List<Integer> getOperatingCarriers() {
        return operatingCarriers;
    }

    @JsonProperty("OperatingCarriers")
    public void setOperatingCarriers(List<Integer> operatingCarriers) {
        this.operatingCarriers = operatingCarriers;
    }

    @JsonProperty("Directionality")
    public String getDirectionality() {
        return directionality;
    }

    @JsonProperty("Directionality")
    public void setDirectionality(String directionality) {
        this.directionality = directionality;
    }

    @JsonProperty("FlightNumbers")
    public List<FlightNumber> getFlightNumbers() {
        return flightNumbers;
    }

    @JsonProperty("FlightNumbers")
    public void setFlightNumbers(List<FlightNumber> flightNumbers) {
        this.flightNumbers = flightNumbers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("segmentIds", segmentIds).append("originStation", originStation).append("destinationStation", destinationStation).append("departure", departure).append("arrival", arrival).append("duration", duration).append("journeyMode", journeyMode).append("stops", stops).append("carriers", carriers).append("operatingCarriers", operatingCarriers).append("directionality", directionality).append("flightNumbers", flightNumbers).toString();
    }

}
