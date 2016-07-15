package com.example;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

public class SummaryTest {

  private RoomEnvironmentSummary s;
  private LinePost lp;

  @Before
  public void setup() {
    s = new RoomEnvironmentSummary();
    lp = new LinePost();
  }

  @Test
  public void createTest() throws IOException {
    System.out.println(s.createSummary().getSummary());
  }

  @Test
  public void postTest() throws MalformedURLException, IOException {
    lp.Post(s.createSummary());
  }
//  @Test
//  public void textTest() throws IOException {
//    lp.createText(s.createSummary());
//  }
}
