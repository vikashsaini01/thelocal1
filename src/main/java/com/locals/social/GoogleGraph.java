package com.locals.social;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class GoogleGraph {

	public String getGoogleGraph(String access_token)throws Exception{
		URL url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token="+ access_token);
		URLConnection urlConn = url.openConnection();
		String outputString = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
		        outputString += line;
		}
		System.out.println(outputString);
		return outputString;
	}
	
	public Map<String, String> getGraphData(String googleGraph) {
		Map<String, String> googleProfile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(googleGraph);
			googleProfile.put("id", json.getString("id"));
			googleProfile.put("userName", json.getString("name"));
			googleProfile.put("loginType", "google");
			if (json.has("email"))
				googleProfile.put("emailId", json.getString("email"));
			if (json.has("gender"))
				googleProfile.put("gender", json.getString("gender"));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return googleProfile;
	}

}
