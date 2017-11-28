package persistencia.dao.exchanges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import persistencia.dao.iface.ValorDolarDao;

public class ValorDolarOpenExchangesDao implements ValorDolarDao{

	private String key = "795fc0499b224b838e7ae6c52093fc57";
	
	@Override
	public double getValorDolar() {
		String https_url = "https://openexchangerates.org/api/latest.json?app_id=" + key;
		System.out.println("request");
		JsonObject jsonObj = getJson(https_url);
		
		JsonObject rates = jsonObj.getAsJsonObject("rates");
		double toRet = rates.getAsJsonPrimitive("ARS").getAsDouble();
		
		return toRet;
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
