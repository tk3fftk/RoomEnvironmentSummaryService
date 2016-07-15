package com.example;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Main {


  @GET
  @Produces({MediaType.TEXT_PLAIN})
  @Path("/tasu")
  public String plus(@QueryParam("a") int a, @QueryParam("b") int b) {
    return String.valueOf(a + b);
  }

  public int minus(int a, int b) {
    return a - b;
  }

  @GET
  @Produces({MediaType.TEXT_PLAIN})
  @Path("/hello")
  public String hello() {
    return "(´・ω・`)hi" + new Date();
  }

  @GET
  @Produces("application/json")
  @Path("/summary")
  public Summary summary() throws IOException {
    RoomEnvironmentSummary res = new RoomEnvironmentSummary();
    return res.createSummary();
  }

  @GET
  @Produces("application/json")
  @Path("/summary/line_post")
  public Summary summaryLinePost() throws IOException {
    RoomEnvironmentSummary res = new RoomEnvironmentSummary();
    Summary summary = res.createSummary();
    LinePost lp = new LinePost();
    lp.Post(summary);
    return summary;
  }
}
