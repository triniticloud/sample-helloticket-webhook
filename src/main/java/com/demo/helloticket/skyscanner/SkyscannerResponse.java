
package com.demo.helloticket.skyscanner;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"SessionKey", "Query", "Status", "Itineraries", "Legs", "Segments", "Carriers", "Places", "Currencies", "Agents"})
public class SkyscannerResponse implements Serializable {

  private static final long serialVersionUID = 7249197290341273805L;
  @JsonProperty("SessionKey")
  private String sessionKey;
  @JsonProperty("Query")
  private Query query;
  @JsonProperty("Status")
  private String status;
  @JsonProperty("Itineraries")
  private List<Itinerary> itineraries = null;
  @JsonProperty("Legs")
  private List<Leg> legs = null;
  @JsonProperty("Segments")
  private List<Segment> segments = null;
  @JsonProperty("Carriers")
  private List<Carrier> carriers = null;
  @JsonProperty("Places")
  private List<Place> places = null;
  @JsonProperty("Currencies")
  private List<Currency> currencies = null;
  @JsonProperty("Agents")
  private List<Agent> agents = null;

  public <T> T get(String id, Class<T> clazz) {
    Object object = null;
    if (clazz == Place.class) {
      int i = Integer.parseInt(id);
      object = places.parallelStream().filter(p -> p.getId() == i).findFirst().orElse(null);
    } else if (clazz == Agent.class) {
      int i = Integer.parseInt(id);
      object = agents.parallelStream().filter(p -> p.getId() == i).findFirst().orElse(null);
    } else if (clazz == Currency.class) {
      object = currencies.parallelStream().filter(p -> p.getCode().equals(id)).findFirst().orElse(null);
    } else if (clazz == Carrier.class) {
      int i = Integer.parseInt(id);
      object = carriers.parallelStream().filter(p -> p.getId() == i).findFirst().orElse(null);
    } else if (clazz == Segment.class) {
      int i = Integer.parseInt(id);
      object = segments.parallelStream().filter(p -> p.getId() == i).findFirst().orElse(null);
    } else if (clazz == Leg.class) {
      object = legs.parallelStream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    return (T) object;
  }

  @JsonProperty("SessionKey")
  public String getSessionKey() {
    return sessionKey;
  }

  @JsonProperty("SessionKey")
  public void setSessionKey(String sessionKey) {
    this.sessionKey = sessionKey;
  }

  @JsonProperty("Query")
  public Query getQuery() {
    return query;
  }

  @JsonProperty("Query")
  public void setQuery(Query query) {
    this.query = query;
  }

  @JsonProperty("Status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("Status")
  public void setStatus(String status) {
    this.status = status;
  }

  @JsonProperty("Itineraries")
  public List<Itinerary> getItineraries() {
    return itineraries;
  }

  @JsonProperty("Itineraries")
  public void setItineraries(List<Itinerary> itineraries) {
    this.itineraries = itineraries;
  }

  @JsonProperty("Legs")
  public List<Leg> getLegs() {
    return legs;
  }

  @JsonProperty("Legs")
  public void setLegs(List<Leg> legs) {
    this.legs = legs;
  }

  @JsonProperty("Segments")
  public List<Segment> getSegments() {
    return segments;
  }

  @JsonProperty("Segments")
  public void setSegments(List<Segment> segments) {
    this.segments = segments;
  }

  @JsonProperty("Carriers")
  public List<Carrier> getCarriers() {
    return carriers;
  }

  @JsonProperty("Carriers")
  public void setCarriers(List<Carrier> carriers) {
    this.carriers = carriers;
  }

  @JsonProperty("Places")
  public List<Place> getPlaces() {
    return places;
  }

  @JsonProperty("Places")
  public void setPlaces(List<Place> places) {
    this.places = places;
  }

  @JsonProperty("Currencies")
  public List<Currency> getCurrencies() {
    return currencies;
  }

  @JsonProperty("Currencies")
  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("sessionKey", sessionKey).append("query", query).append("status", status)
        .append("itineraries", itineraries).append("legs", legs).append("segments", segments).append("carriers", carriers)
        .append("places", places).append("currencies", currencies).append("agents", agents).toString();
  }

  @JsonProperty("Agents")
  public List<Agent> getAgents() {
    return agents;
  }

  @JsonProperty("Agents")
  public void setAgents(List<Agent> agents) {
    this.agents = agents;
  }

}
