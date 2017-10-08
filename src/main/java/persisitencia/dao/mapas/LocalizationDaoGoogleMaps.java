package persisitencia.dao.mapas;

import persistencia.dao.iface.LocalizationDao;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class LocalizationDaoGoogleMaps implements LocalizationDao{

	private String key = "AIzaSyCQzeyyVflANVpzD511q3C_3iLjnHJ8aFk" ;
	
	@Override
	public MapPoint getLocationOf(String location) {

		System.out.println(location);
		String encodedLocation = "";
		try {
			encodedLocation = URLEncoder.encode(location, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String https_url = "https://maps.googleapis.com/maps/api/geocode/json?address="
				+ encodedLocation + ""
				+ "&key=" + key;
		
		getJson(https_url);
		return new MapPoint(-34.521423, -58.700954);
		
	}

	private void getJson(String https_url_encoded) {
	   URL url;
	   try {
	     url = new URL(https_url_encoded);
	     
	     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

	     //dumpl all cert info
	     print_https_cert(con);
	
	     //dump all the content
	     print_content(con);
	
	  } catch (MalformedURLException e) {
	     e.printStackTrace();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
		
	}

		   private void print_https_cert(HttpsURLConnection con){

		    if(con!=null){

		      try {

			System.out.println("Response Code : " + con.getResponseCode());
			System.out.println("Cipher Suite : " + con.getCipherSuite());
			System.out.println("\n");

			Certificate[] certs = con.getServerCertificates();
			for(Certificate cert : certs){
			   System.out.println("Cert Type : " + cert.getType());
			   System.out.println("Cert Hash Code : " + cert.hashCode());
			   System.out.println("Cert Public Key Algorithm : "
		                                    + cert.getPublicKey().getAlgorithm());
			   System.out.println("Cert Public Key Format : "
		                                    + cert.getPublicKey().getFormat());
			   System.out.println("\n");
			}

			} catch (SSLPeerUnverifiedException e) {
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}

		     }

		   }

		   private void print_content(HttpsURLConnection con){
			if(con!=null){

			try {

			   System.out.println("****** Content of the URL ********");
			   BufferedReader br =
				new BufferedReader(
					new InputStreamReader(con.getInputStream()));

			   String input;

			   while ((input = br.readLine()) != null){
			      System.out.println(input);
			   }
			   br.close();

			} catch (IOException e) {
			   e.printStackTrace();
			}

		       }

		   }
		   
		   
	
}
