package com.locals.social;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;



public class GoogleConnection {

	static final String Client_ID = "173097266225-pqons5a5jbml6fj5kgflnnjfajqb43jm.apps.googleusercontent.com";
	static final String GOOGLE_APP_SECRET = "NrXlixDLHsJDTJIy4_Wbq2Et";
	static final String REDIRECT_URI = "http://localhost:8081/googlehome";

	public static String getGoogleAuthUrl() {
		String loginUrl = null;

		try {
			loginUrl = "https://accounts.google.com/o/oauth2/auth?scope=email&" + "redirect_uri="
					+ REDIRECT_URI + "&response_type=code&client_id=" + Client_ID
					+ "&approval_prompt=force";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return loginUrl;
	}
	
	public static String getGoogleAccessToekn(String code) throws Exception{
		String urlParameters = "code="
                + code
                + "&client_id="+Client_ID
                + "&client_secret="+ GOOGLE_APP_SECRET
                + "&redirect_uri="+REDIRECT_URI
                + "&grant_type=authorization_code";
		URL url = new URL("https://accounts.google.com/o/oauth2/token" );
		
		
		URLConnection urlConn = url.openConnection();
		
		urlConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
		writer.write(urlParameters);
		writer.flush();
		
		BufferedReader in;
		StringBuffer b = null;
		in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		String inputLine;
		b = new StringBuffer();
		while ((inputLine = in.readLine()) != null)
			b.append(inputLine + "\n");
		in.close();
		
		JSONObject json = new JSONObject(b.toString());
		String access_token = json.getString("access_token");
		if (access_token.startsWith("{")) {
			throw new RuntimeException("ERROR: Access Token Invalid: " + b.toString());
		}
		
		return access_token ;
	}

}
