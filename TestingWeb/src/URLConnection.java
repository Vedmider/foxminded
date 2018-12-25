

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;

import javax.net.ssl.HttpsURLConnection;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;

public class URLConnection {
	final static private String url = "requestType=sale&userName=test_api_user&password=U06hJC2AUc53aSA7M3R22hA30Be1F1lF";
	
	private String getResponse(String urlParameters) throws Exception {

		String url = "https://sandbox-secure.unitedthinkers.com/gates/xurl";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setUseCaches(false);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
			
		System.out.println(response.toString());

		return response.toString(); 
	}
	
	public String getWithAccountData(String key, int value) {
		String tempUrl = url;
		String response = "";
		
		KeyValue container = new KeyValue();
		Xcelite xcelite = new Xcelite(new File("KeysAndValues.xlsx")); 
		XceliteSheet sheet = xcelite.getSheet("Sheet1");
		SheetReader<KeyValue> reader = sheet.getBeanReader(KeyValue.class);
		Collection<KeyValue> data = reader.read();
		
		for(KeyValue s : data) {
			container = s;
		}
		
		tempUrl += "&" + container.getAccountId();

		if(key.equals("amount")) {
			tempUrl += "&amount=" + value;
		} else {
			tempUrl += "&" + container.getAmount();
		}
		
		tempUrl += "&" + container.getAccountType()+ 
				   "&" + container.getTransactionIndustryType()+
				   "&" + container.getHolderType()+
				   "&" + container.getHolderName()+
				   "&" + container.getAccountNumber()+
				   "&" + container.getAccountAccessory()+
				   "&" + container.getStreet()+
				   "&" + container.getCity()+
				   "&" + container.getState();
		
		if(key.equals("zipCode")) {
			tempUrl += "&zipCode=" + value;
		} else {
			tempUrl += "&" + container.getZipCode();
		}
		
		if(key.equals("csc")) {
			tempUrl += "&csc=" + value;
		}
		
		tempUrl += "&" + container.getCustomerAccountCode() + "&" + container.getTransactionCode();
		
		try {
			response = getResponse(tempUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;		
	}
	
	public String getWithTrackData(String key, int value) {
		String tempUrl = url;
		String response = "";
		
		KeyValue container = new KeyValue();
		Xcelite xcelite = new Xcelite(new File("KeysAndValues.xlsx")); 
		XceliteSheet sheet = xcelite.getSheet("Sheet1");
		SheetReader<KeyValue> reader = sheet.getBeanReader(KeyValue.class);
		Collection<KeyValue> data = reader.read();
		
		for(KeyValue s : data) {
			container= s;
		}
		
		if(key.equals("amount")) {
			tempUrl += "&amount=" + value;
		} else {
			tempUrl += "&" + container.getAmount();
		}
		
		tempUrl += "&" + container.getAccountType()+
				   "&" + container.getAccountId()+
				   "&" + container.getCustomerAccountCode()+
				   "&" + container.getTransactionCode()+
				   "&" + container.getTransactionIndustryType();
		
		if(key.equals("zipCode")) {
			tempUrl += "&zipCode=" + value;
		}
		
		if(key.equals("csc")) {
			tempUrl += "&csc=" + value;
		}
		
		tempUrl += "&" + container.getTrackData();
		
		try {
			response = getResponse(tempUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
}
