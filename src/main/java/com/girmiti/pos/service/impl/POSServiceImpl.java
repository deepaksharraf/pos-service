package com.girmiti.pos.service.impl;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.girmiti.pos.dao.model.DemoClass;
import com.girmiti.pos.dao.repository.DemoClassRepository;
import com.girmiti.pos.exception.PosException;
import com.girmiti.pos.model.Request;
import com.girmiti.pos.model.Response;
import com.girmiti.pos.service.POSService;

@Service("paymentService")
public class POSServiceImpl implements POSService {

  Logger logger = LoggerFactory.getLogger(POSServiceImpl.class);
  
  @Autowired
  private DemoClassRepository demoRepository;
  
  private ObjectMapper mapper = new ObjectMapper();
  
  @Override
  public Response saveRequest(Request request) throws PosException {
    logger.info("Entering :: POSServiceImpl :: saveRequest method");
    Response response = new Response();
    DemoClass demoClass = new DemoClass();
    demoClass.setRequest(request.getValue());
    demoRepository.save(demoClass);
    response.setResult("Saved!");
    logger.info("Exiting :: POSServiceImpl :: saveRequest method");
    return response;
  }

  @Override
  public String getAllSavedReq() throws PosException, JsonGenerationException, JsonMappingException, IOException {
    logger.info("Entering :: POSServiceImpl :: getAllSavedReq method");
    List<DemoClass> allSavedData = demoRepository.findAll();
    logger.info("Exiting :: POSServiceImpl :: getAllSavedReq method");
    return mapper.writeValueAsString(allSavedData);
  }
}
