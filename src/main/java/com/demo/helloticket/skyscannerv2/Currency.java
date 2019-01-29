
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
    "Code",
    "Symbol",
    "ThousandsSeparator",
    "DecimalSeparator",
    "SymbolOnLeft",
    "SpaceBetweenAmountAndSymbol",
    "RoundingCoefficient",
    "DecimalDigits"
})
public class Currency implements Serializable
{

    @JsonProperty("Code")
    private String code;
    @JsonProperty("Symbol")
    private String symbol;
    @JsonProperty("ThousandsSeparator")
    private String thousandsSeparator;
    @JsonProperty("DecimalSeparator")
    private String decimalSeparator;
    @JsonProperty("SymbolOnLeft")
    private boolean symbolOnLeft;
    @JsonProperty("SpaceBetweenAmountAndSymbol")
    private boolean spaceBetweenAmountAndSymbol;
    @JsonProperty("RoundingCoefficient")
    private int roundingCoefficient;
    @JsonProperty("DecimalDigits")
    private int decimalDigits;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1168168850743416355L;

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("Symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("Symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("ThousandsSeparator")
    public String getThousandsSeparator() {
        return thousandsSeparator;
    }

    @JsonProperty("ThousandsSeparator")
    public void setThousandsSeparator(String thousandsSeparator) {
        this.thousandsSeparator = thousandsSeparator;
    }

    @JsonProperty("DecimalSeparator")
    public String getDecimalSeparator() {
        return decimalSeparator;
    }

    @JsonProperty("DecimalSeparator")
    public void setDecimalSeparator(String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    @JsonProperty("SymbolOnLeft")
    public boolean isSymbolOnLeft() {
        return symbolOnLeft;
    }

    @JsonProperty("SymbolOnLeft")
    public void setSymbolOnLeft(boolean symbolOnLeft) {
        this.symbolOnLeft = symbolOnLeft;
    }

    @JsonProperty("SpaceBetweenAmountAndSymbol")
    public boolean isSpaceBetweenAmountAndSymbol() {
        return spaceBetweenAmountAndSymbol;
    }

    @JsonProperty("SpaceBetweenAmountAndSymbol")
    public void setSpaceBetweenAmountAndSymbol(boolean spaceBetweenAmountAndSymbol) {
        this.spaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    }

    @JsonProperty("RoundingCoefficient")
    public int getRoundingCoefficient() {
        return roundingCoefficient;
    }

    @JsonProperty("RoundingCoefficient")
    public void setRoundingCoefficient(int roundingCoefficient) {
        this.roundingCoefficient = roundingCoefficient;
    }

    @JsonProperty("DecimalDigits")
    public int getDecimalDigits() {
        return decimalDigits;
    }

    @JsonProperty("DecimalDigits")
    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
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
