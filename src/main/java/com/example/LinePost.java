package com.example;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * herokuにあるLineBotを叩くAPIを叩くためのクラス
 * 
 * @author tk3fftk
 *
 */
public class LinePost {

  private final String lineEndpoint = "https://linehousebot.herokuapp.com/linebot/post";

  public boolean Post(Summary summary) {
    String text = createText(summary);
    String json = "{\"text\":" + "\"" + text + "\"}";

    // POST処理
    try {
      URL url = new URL(lineEndpoint);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setDoOutput(true);
      con.setRequestProperty("Content-Type", "application/json");

      OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
      out.write(json);
      out.flush();
      out.close();

      con.getResponseCode();

      con.disconnect();

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * Lineに送る文章を作成する
   * 
   * @param summary
   * @return
   */
  private String createText(Summary summary) {
    return summary.getDate() + "の部屋の状態だよ。," + summary.getSummary();
  }
}
