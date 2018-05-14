package com.girmiti.pos.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "demo_table")
public class DemoClass implements Serializable {
  
  /**
   * 
   */
  private static final long serialVersionUID = -1840023577939172431L;

  @Id
  @SequenceGenerator(name = "seq_demo_table", sequenceName = "seq_demo_table")
  @GeneratedValue(generator = "seq_demo_table")
  @Column(name = "id")
  private Long id;
  
  @Column(name="request")
  private String request;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

}
