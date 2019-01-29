
package com.demo.helloticket.skyscanner;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Agents",
    "QuoteAgeInMinutes",
    "Price",
    "DeeplinkUrl"
})
public class PricingOption implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Agents")
    private List<Integer> agents = null;
    @JsonProperty("QuoteAgeInMinutes")
    private int quoteAgeInMinutes;
    @JsonProperty("Price")
    private double price;
    @JsonProperty("DeeplinkUrl")
    private String deeplinkUrl;

    @JsonProperty("Agents")
    public List<Integer> getAgents() {
        return agents;
    }

    @JsonProperty("Agents")
    public void setAgents(List<Integer> agents) {
        this.agents = agents;
    }

    @JsonProperty("QuoteAgeInMinutes")
    public int getQuoteAgeInMinutes() {
        return quoteAgeInMinutes;
    }

    @JsonProperty("QuoteAgeInMinutes")
    public void setQuoteAgeInMinutes(int quoteAgeInMinutes) {
        this.quoteAgeInMinutes = quoteAgeInMinutes;
    }

    @JsonProperty("Price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("DeeplinkUrl")
    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    @JsonProperty("DeeplinkUrl")
    public void setDeeplinkUrl(String deeplinkUrl) {
        this.deeplinkUrl = deeplinkUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("agents", agents).append("quoteAgeInMinutes", quoteAgeInMinutes).append("price", price).append("deeplinkUrl", deeplinkUrl).toString();
    }

}
