package com.girmiti.pos.model;

import java.io.Serializable;

public class Response implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8879822967838561410L;
  
  private String result;

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

}
