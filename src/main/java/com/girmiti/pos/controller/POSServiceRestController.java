package com.girmiti.pos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.girmiti.pos.model.Request;
import com.girmiti.pos.model.Response;
import com.girmiti.pos.service.POSService;

@RestController
public class POSServiceRestController {
  @Autowired
  private POSService posService;

  private static Logger logger = LoggerFactory.getLogger(POSServiceRestController.class);
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String ping() {
    return "Hello !";
  }
  
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Response saveRequest(@RequestBody Request request,
      BindingResult bindingResult) {
    logger.info("Entering:: POSServiceRestController:: saveRequest method");
    try {
      return posService.saveRequest(request);
    } catch (Exception e) {
      logger.error("EXCEPTION",e);
    }
    return null;
  }
  
  @RequestMapping(value = "/fetch", method = RequestMethod.GET)
  public String fetchSavedData() {
    logger.info("Entering:: POSServiceRestController:: fetchSavedData method");
    try {
      return posService.getAllSavedReq();
    } catch (Exception e) {
      logger.error("EXCEPTION",e);
    }
    return null;
  }
}
