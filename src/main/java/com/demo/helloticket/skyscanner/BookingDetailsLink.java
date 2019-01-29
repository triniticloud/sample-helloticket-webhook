
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Uri",
    "Body",
    "Method"
})
public class BookingDetailsLink implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @JsonProperty("Uri")
    private String uri;
    @JsonProperty("Body")
    private String body;
    @JsonProperty("Method")
    private String method;

    @JsonProperty("Uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("Uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("Body")
    public String getBody() {
        return body;
    }

    @JsonProperty("Body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("Method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("Method")
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("uri", uri).append("body", body).append("method", method).toString();
    }

}
