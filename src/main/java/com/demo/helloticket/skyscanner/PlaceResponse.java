
package com.demo.helloticket.skyscanner;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Places"})
public class PlaceResponse {

  @JsonProperty("Places")
  private List<PlaceDetails> places = null;

  @JsonProperty("Places")
  public List<PlaceDetails> getPlaces() {
    return places;
  }

  @JsonProperty("Places")
  public void setPlaces(List<PlaceDetails> places) {
    this.places = places;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("places", places).toString();
  }

}
