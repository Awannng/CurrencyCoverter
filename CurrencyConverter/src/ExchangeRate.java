import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;

public class ExchangeRate {

	private HashMap<String, Double> exchangeRate = new HashMap<String, Double>();
	private String fromname;
	private String toname;
	private Double rate;
	
	public ExchangeRate(String fromname) throws IOException{
		this.fromname = fromname;
		
		switch(fromname) {
		case "USD":
			this.exchangeRate.put(toname="USD", setRate(toname)); //1.00
			this.exchangeRate.put(toname="EUR", setRate(toname)); // 0.945
			this.exchangeRate.put(toname="GBP", setRate(toname)); //0.821
			this.exchangeRate.put(toname="CHF", setRate(toname)); //8.93
			this.exchangeRate.put(toname="JPY", setRate(toname)); //149.801
			this.exchangeRate.put(toname="CNY", setRate(toname)); //7.312
			break;
		case "EUR":
			this.exchangeRate.put(toname="EUR", setRate(toname)); //1
			this.exchangeRate.put(toname="USD", setRate(toname)); //1.059
			this.exchangeRate.put(toname="GBP", setRate(toname)); //0.871
			this.exchangeRate.put(toname="CHF", setRate(toname)); //.944
			this.exchangeRate.put(toname="JPY", setRate(toname)); //158.538
			this.exchangeRate.put(toname="CNY", setRate(toname)); //7.739
			break;
		case "GBP":
			this.exchangeRate.put(toname="GBP", setRate(toname)); //1
			this.exchangeRate.put(toname="USD", setRate(toname)); //1.215
			this.exchangeRate.put(toname="EUR", setRate(toname)); //1.148
			this.exchangeRate.put(toname="CHF", setRate(toname)); //1.083
			this.exchangeRate.put(toname="JPY", setRate(toname)); // 181.914
			this.exchangeRate.put(toname="CNY", setRate(toname)); //8.882
			break;
		case "CHF":
			this.exchangeRate.put(toname="CHF", setRate(toname)); //1.00
			this.exchangeRate.put(toname="USD", setRate(toname)); //1.121
			this.exchangeRate.put(toname="EUR", setRate(toname)); //1.058
			this.exchangeRate.put(toname="GBP", setRate(toname)); //0.924
			this.exchangeRate.put(toname="JPY", setRate(toname)); //168.089
			this.exchangeRate.put(toname="CNY", setRate(toname)); //8.188
			break;
		case "JPY":
			this.exchangeRate.put(toname="USD", setRate(toname)); //0.007
			this.exchangeRate.put(toname="EUR", setRate(toname)); //0.006
			this.exchangeRate.put(toname="GBP", setRate(toname)); //0.005
			this.exchangeRate.put(toname="JPY", setRate(toname)); //1.00
			this.exchangeRate.put(toname="CHF", setRate(toname)); //0.006
			this.exchangeRate.put(toname="CNY", setRate(toname)); //0.049
			break;
		case "CNY":
			this.exchangeRate.put(toname="CNY", setRate(toname)); //1.00
			this.exchangeRate.put(toname="USD", setRate(toname)); //0.137
			this.exchangeRate.put(toname="EUR", setRate(toname)); //0.129
			this.exchangeRate.put(toname="GBP", setRate(toname)); //0.113
			this.exchangeRate.put(toname="CHF", setRate(toname)); //0.122
			this.exchangeRate.put(toname="JPY", setRate(toname)); //20.462
			break;
		}
	}

	public double getRate(String name) {
		return this.exchangeRate.get(name);
	}
	
	public double change(double amount, double rate) {
		double price;
		price = Math.round((amount*rate)*100d)/100d;
		return price;
	}
	
	public Double setRate(String toname) throws IOException {
		this.toname = toname;
		
		String GET_URL = "https://v6.exchangerate-api.com/v6/e82cbaceb3424211ed61235b/latest/" + fromname;
		URL url = new URL(GET_URL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		int responseCode = httpURLConnection.getResponseCode();
		
		if(responseCode == httpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}in.close();
			
			JSONObject obj = new JSONObject(response.toString());
			
			rate = obj.getJSONObject("conversion_rates").getDouble(toname);
		}
		return rate;
	}
	
}