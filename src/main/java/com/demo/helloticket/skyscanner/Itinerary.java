
package com.demo.helloticket.skyscanner;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "OutboundLegId",
    "PricingOptions",
    "BookingDetailsLink"
})
public class Itinerary implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("OutboundLegId")
    private String outboundLegId;
    @JsonProperty("PricingOptions")
    private List<PricingOption> pricingOptions = null;
    @JsonProperty("BookingDetailsLink")
    private BookingDetailsLink bookingDetailsLink;

    @JsonProperty("OutboundLegId")
    public String getOutboundLegId() {
        return outboundLegId;
    }

    @JsonProperty("OutboundLegId")
    public void setOutboundLegId(String outboundLegId) {
        this.outboundLegId = outboundLegId;
    }

    @JsonProperty("PricingOptions")
    public List<PricingOption> getPricingOptions() {
        return pricingOptions;
    }

    @JsonProperty("PricingOptions")
    public void setPricingOptions(List<PricingOption> pricingOptions) {
        this.pricingOptions = pricingOptions;
    }

    @JsonProperty("BookingDetailsLink")
    public BookingDetailsLink getBookingDetailsLink() {
        return bookingDetailsLink;
    }

    @JsonProperty("BookingDetailsLink")
    public void setBookingDetailsLink(BookingDetailsLink bookingDetailsLink) {
        this.bookingDetailsLink = bookingDetailsLink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("outboundLegId", outboundLegId).append("pricingOptions", pricingOptions).append("bookingDetailsLink", bookingDetailsLink).toString();
    }

}
