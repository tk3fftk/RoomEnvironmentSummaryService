package com.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
public class Summary {
  private String date;
  private String summary;

  public Summary() {}

  public Summary(String date, String summary) {
    this.date = date;
    this.summary = summary;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
