package com.demo.helloticket.controller;

public class ProfileResponse {
  
  private String id;
  
  public ProfileResponse(){
    
  }

  public ProfileResponse(String string) {
    this.id = string;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
