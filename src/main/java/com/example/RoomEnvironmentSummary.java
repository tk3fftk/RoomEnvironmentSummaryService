package com.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RoomEnvironmentSummary {

  private final String url =
      "http://192.168.3.102:8080/axis2/services/SensorBoxService/getAllValues";

  public RoomEnvironmentSummary() {

  }

  public Summary createSummary() throws IOException {
    Summary result = new Summary();

    // 現在時刻を取得
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    result.setDate(dtf.format(now));

    // センサボックスから環境情報を取得
    Document doc = Jsoup.connect(url).get();
    String tmp = "";
    for (Element e : doc.select("return")) {
      tmp += e.select("id").text() + ": " + e.select("value").text() + ",";
    }
    result.setSummary(tmp);
    return result;
  }
}
