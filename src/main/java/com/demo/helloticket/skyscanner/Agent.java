/*
 * (C) Copyright 2016 Active Intelligence Pte Ltd (http://active.ai/).
 *
 * This software is the confidential and proprietary information of Active Intelligence.
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with Active
 * Intelligence
 *
 */
package com.demo.helloticket.skyscanner;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Shashank Sh.
 *
 */
public class Agent implements Serializable {

  private static final long serialVersionUID = 1L;
  @JsonProperty("Id")
  private Integer id;
  @JsonProperty("Name")
  private String name;
  @JsonProperty("ImageUrl")
  private String imageUrl;
  @JsonProperty("Status")
  private String status;
  @JsonProperty("OptimisedForMobile")
  private boolean optimisedForMobile;
  @JsonProperty("Type")
  private String type;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public boolean isOptimisedForMobile() {
    return optimisedForMobile;
  }

  public void setOptimisedForMobile(boolean optimisedForMobile) {
    this.optimisedForMobile = optimisedForMobile;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Agent [id=");
    builder.append(id);
    builder.append(", name=");
    builder.append(name);
    builder.append(", imageUrl=");
    builder.append(imageUrl);
    builder.append(", status=");
    builder.append(status);
    builder.append(", optimisedForMobile=");
    builder.append(optimisedForMobile);
    builder.append(", type=");
    builder.append(type);
    builder.append("]");
    return builder.toString();
  }

}
