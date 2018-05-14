package com.girmiti.pos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * << Add Comments Here >>
 *
 * @author Girmiti Software
 * @date 06-Jul-2017 4:29:51 PM
 * @version 1.0
 */
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

  private static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    request.getSession(true).setAttribute("ENTRY", System.currentTimeMillis());

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    logger.info("[postHandle][" + request + "]");
    logger.info("<<<<<<Time taken to process the request>>>>"
        + ((System.currentTimeMillis() - (long) request.getSession().getAttribute("ENTRY"))
            / 1000.0));
  }
}
