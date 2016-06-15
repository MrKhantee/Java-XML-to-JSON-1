import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class test {
	public static String API_URL = "http://www.wikalenda.com/feed/main/en/1/0/2/";
	
	public static String getXMLString() throws Exception {
		URL website = new URL(API_URL);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()));
		
		StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);

        in.close();
        return response.toString();
	}
	
	public static void main(String[] args){
		String xml = new String();
		try {
			xml = getXMLString();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try{
			JSONObject xmlJSONObj = XML.toJSONObject(xml);
			String jsonPrettyPrintString = xmlJSONObj.toString(4);
			System.out.println(jsonPrettyPrintString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
