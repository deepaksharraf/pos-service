package com.girmiti.pos.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.girmiti.pos.exception.PosException;
import com.girmiti.pos.model.Request;
import com.girmiti.pos.model.Response;

public interface POSService {

  Response saveRequest(Request request) throws PosException;
  
  String getAllSavedReq() throws PosException, JsonGenerationException, JsonMappingException, IOException;

}
