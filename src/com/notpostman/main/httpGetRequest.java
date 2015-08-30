package com.notpostman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpGetRequest {
	
	public httpGetRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws IOException{
			httpGet();
	}
	
	public static void httpGet() throws IOException {
		
		String reqUrl = "http://validate.jsontest.com";
		String params = "json={\"key\":\"value\"}";
		System.out.println("URL Being Requested: " + reqUrl);
		System.out.println("Params being passed in request: " + params);
		reqUrl = reqUrl + "/?" + params;
		System.out.println("Full Request Url: " + reqUrl);
		
		//Creates URL Object and opens a http connection at the url
		URL obj = new URL(reqUrl);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

		//optional to include but default is GET
		connection.setRequestMethod("GET");

		//add request header
		connection.setRequestProperty("User-Agent","Mozilla/5.0");

		int responseCode = connection.getResponseCode();
		
		System.out.println("\nSending 'GET' request to URL : " + reqUrl);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//Close Connection To Url
		connection.disconnect();

		//Print Response
		System.out.println("\n---BEGIN RESPONSE---");
		System.out.println(response.toString());
		System.out.println("---END RESPONSE---");
		
	}

}
