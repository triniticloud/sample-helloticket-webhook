
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "ParentId",
    "Code",
    "Type",
    "Name"
})
public class Place implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("Id")
    private int id;
    @JsonProperty("ParentId")
    private int parentId;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Id")
    public int getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("ParentId")
    public int getParentId() {
        return parentId;
    }

    @JsonProperty("ParentId")
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("parentId", parentId).append("code", code).append("type", type).append("name", name).toString();
    }

}
