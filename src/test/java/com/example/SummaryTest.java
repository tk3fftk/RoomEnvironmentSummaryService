package com.example;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SummaryTest {

  private RoomEnvironmentSummary s;

  @Before
  public void setup() {
    s = new RoomEnvironmentSummary();
  }
  
  @Test
  public void createTest() throws IOException{
    System.out.println(s.createSummary().getSummary());
  }
}
