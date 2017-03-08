/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import sun.misc.IOUtils;
/**
 *
 * @author samarthmadduru
 */
public class getTheirMessage {
    
    private static String strImp = "";
    
    
    private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static String returnJSON(){
      try {
			String webPage = "https://api.twilio.com//2010-04-01/Accounts/ACbd6bbceb4130efb0c898d4db3040b7ce/SMS/Messages";
			String username = "ACbd6bbceb4130efb0c898d4db3040b7ce";
			String password = "db13a34093a347237d703471a7837115";

			String authString = username + ":" + password;
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();
                        strImp=result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
                        return strImp;
  }
  
  public static String returnParsed(){
      return returnJSON().substring(returnJSON().indexOf("</From><Body>")+13, returnJSON().indexOf("</Body><Status>")+1);
  }
  
  public static String getAddress(){
      String newStr = "http://maps.googleapis.com/maps/api/geocode/json?latlng=" + returnParsed() + "&sensor=true";
      
      
      newStr = newStr.replace(" ", "%20");
      newStr = newStr.replace("<", "%20");
      
      
      return newStr;
  }
  
  private static String readAll1(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
  
  public static String formatted() throws IOException{
      JSONObject json = readJsonFromUrl(getAddress());
      return json.toString().substring(34, json.toString().indexOf("\",\"types\""));
  }

  public static void main(String[] args) throws IOException, JSONException {
    System.out.println(returnJSON());
  }
  



  }
    