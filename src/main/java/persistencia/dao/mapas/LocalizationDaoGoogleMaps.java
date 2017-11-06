package persistencia.dao.mapas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import persistencia.dao.iface.LocalizationDao;

public class LocalizationDaoGoogleMaps implements LocalizationDao{

	private String key = "AIzaSyCQzeyyVflANVpzD511q3C_3iLjnHJ8aFk" ;
	
	@Override
	public MapPoint getLocationOf(String location) {

		String encodedLocation = "";
		try {
			encodedLocation = URLEncoder.encode(location, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String https_url = "https://maps.googleapis.com/maps/api/geocode/json?address="
				+ encodedLocation + ""
				+ "&key=" + key;
		
		JsonObject jsonObj = getJson(https_url);
		
		String status = jsonObj.getAsJsonPrimitive("status").getAsString();
		
		if(!status.equals("OK"))
			return null;
		
		JsonObject jsonLocation = jsonObj.getAsJsonArray("results").get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
		
		double lat = jsonLocation.getAsJsonPrimitive("lat").getAsDouble();
		double lon = jsonLocation.getAsJsonPrimitive("lng").getAsDouble();
		
		return new MapPoint(lat, lon);
	
		
	}

	private JsonObject getJson(String https_url_encoded) {
	   URL url;
	   try {
	    url = new URL(https_url_encoded);
	     
	    HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
	    
		BufferedReader br =
				new BufferedReader(
						new InputStreamReader(con.getInputStream()));
		
		String json = "";
		
		while (true){
			String input = br.readLine();
			if(input == null)
				break;
			json += input;
		}
		
		br.close();
				   
		
		JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();
		
		return jsonObj;
	
	  } catch (MalformedURLException e) {
	     e.printStackTrace();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return null;
		
	}


		   
		   
	
}
