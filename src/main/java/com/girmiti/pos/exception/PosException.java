package com.girmiti.pos.exception;

@SuppressWarnings("serial")
public class PosException extends Exception {

  private String HTTP_ERROR_CODE;

  private int StatusCode;

  public PosException(String hTTP_ERROR_CODE, int statusCode) {
    super();
    HTTP_ERROR_CODE = hTTP_ERROR_CODE;
    StatusCode = statusCode;
  }

  public String getHTTP_ERROR_CODE() {
    return HTTP_ERROR_CODE;
  }

  public void setHTTP_ERROR_CODE(String hTTP_ERROR_CODE) {
    HTTP_ERROR_CODE = hTTP_ERROR_CODE;
  }

  public int getStatusCode() {
    return StatusCode;
  }

  public void setStatusCode(int statusCode) {
    StatusCode = statusCode;
  }

}
