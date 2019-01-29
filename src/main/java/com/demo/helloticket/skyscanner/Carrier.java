
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "Code",
    "Name",
    "ImageUrl",
    "DisplayCode",
    "Status",
    "OptimisedForMobile",
    "Type"
})
public class Carrier implements Serializable {

    private static final long serialVersionUID = -1517849897171903882L;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("DisplayCode")
    private String displayCode;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("OptimisedForMobile")
    private boolean optimisedForMobile;
    @JsonProperty("Type")
    private String type;

    @JsonProperty("Id")
    public int getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("DisplayCode")
    public String getDisplayCode() {
        return displayCode;
    }

    @JsonProperty("DisplayCode")
    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("OptimisedForMobile")
    public boolean isOptimisedForMobile() {
        return optimisedForMobile;
    }

    @JsonProperty("OptimisedForMobile")
    public void setOptimisedForMobile(boolean optimisedForMobile) {
        this.optimisedForMobile = optimisedForMobile;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("code", code).append("name", name).append("imageUrl", imageUrl).append("displayCode", displayCode).append("status", status).append("optimisedForMobile", optimisedForMobile).append("type", type).toString();
    }

}
