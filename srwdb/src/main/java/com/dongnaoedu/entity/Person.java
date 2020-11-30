package com.dongnaoedu.entity;

import java.util.List;

public class Person {

  private Long id;
  private List<String> interest;

  @Override
  public String toString() {
    return "Person{" + "id=" + id + ", interest=" + interest + '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<String> getInterest() {
    return interest;
  }

  public void setInterest(List<String> interest) {
    this.interest = interest;
  }
}
