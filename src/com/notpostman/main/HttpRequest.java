package com.notpostman.main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest {

	public HttpRequest(){
		
	}

	public String sendGet(String passedUrl) {
		try {
			//Set URL + Request Params
			String reqUrl = passedUrl;
			reqUrl = reqUrl;
			System.out.println("Full Request Url: " + reqUrl);

			//Creates URL Object and opens a HTTP Connection at the URL
			URL obj = new URL(reqUrl);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			//Optional to set as GET is default
			connection.setRequestMethod("GET");

			//Add Headers
			connection.setRequestProperty("User-Agent","Mozilla/5.0");

			//Feedback to Console
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + reqUrl);
			System.out.println("Response Code : " + responseCode);

			//Receive Response
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//Close Connection To URL
			connection.disconnect();

			//Print Response
			System.out.println("\n---BEGIN RESPONSE---");
			System.out.println(response.toString());
			System.out.println("---END RESPONSE---");

			return response.toString();
		}

		catch (Exception getException) {
			System.out.println("An exception was thrown during execution");
			getException.printStackTrace();
		}
		return null;
	}


	public String sendPost(String passedUrl, String passedParams) throws Exception {
			try {
				//Set URL + Create Connection
				String reqUrl = passedUrl;
				URL url = new URL(reqUrl);
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

				//Add Headers
				connection.setRequestMethod("POST");
				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

				//Set Params
				String urlParameters = passedParams;

				// Send Request with Params
				connection.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();

				//Feedback to Console
				int responseCode = connection.getResponseCode();
				System.out.println("\nSending 'POST' request to URL : " + reqUrl);
				System.out.println("Post Parameters : " + urlParameters);
				System.out.println("Response Code : " + responseCode);

				BufferedReader in = new BufferedReader(
				        new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				//Print Response
				System.out.println("\n--BEGIN RESPONSE---");
				System.out.println(response.toString());
				System.out.println("---END RESPONSE---");
				return response.toString();
			}
			catch (Exception postException) {
				postException.printStackTrace();
			}
			return null;
		}
}
