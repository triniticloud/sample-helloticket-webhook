
package com.demo.helloticket.skyscannerv2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "QuoteId",
    "MinPrice",
    "Direct",
    "OutboundLeg",
    "InboundLeg",
    "QuoteDateTime"
})
public class Quote implements Serializable
{

    @JsonProperty("QuoteId")
    private int quoteId;
    @JsonProperty("MinPrice")
    private int minPrice;
    @JsonProperty("Direct")
    private boolean direct;
    @JsonProperty("OutboundLeg")
    private OutboundLeg outboundLeg;
    @JsonProperty("InboundLeg")
    private InboundLeg inboundLeg;
    @JsonProperty("QuoteDateTime")
    private String quoteDateTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2594892799603210955L;

    @JsonProperty("QuoteId")
    public int getQuoteId() {
        return quoteId;
    }

    @JsonProperty("QuoteId")
    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    @JsonProperty("MinPrice")
    public int getMinPrice() {
        return minPrice;
    }

    @JsonProperty("MinPrice")
    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    @JsonProperty("Direct")
    public boolean isDirect() {
        return direct;
    }

    @JsonProperty("Direct")
    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    @JsonProperty("OutboundLeg")
    public OutboundLeg getOutboundLeg() {
        return outboundLeg;
    }

    @JsonProperty("OutboundLeg")
    public void setOutboundLeg(OutboundLeg outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

    @JsonProperty("InboundLeg")
    public InboundLeg getInboundLeg() {
        return inboundLeg;
    }

    @JsonProperty("InboundLeg")
    public void setInboundLeg(InboundLeg inboundLeg) {
        this.inboundLeg = inboundLeg;
    }

    @JsonProperty("QuoteDateTime")
    public String getQuoteDateTime() {
        return quoteDateTime;
    }

    @JsonProperty("QuoteDateTime")
    public void setQuoteDateTime(String quoteDateTime) {
        this.quoteDateTime = quoteDateTime;
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
