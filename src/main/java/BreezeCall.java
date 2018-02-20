import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.*;

public class BreezeCall {
    private String apiKey;
    private String baseURL;

    BreezeCall(String apiKey, String baseURL) {
        this.apiKey = apiKey;
        this.baseURL = baseURL;
    }

    public ArrayList<Calendar> getCalIDs() throws java.net.MalformedURLException, java.io.IOException{
        if(apiKey == null || apiKey.isEmpty())
            throw new IllegalArgumentException("API key cannot be undefined");
        if(baseURL == null || baseURL.isEmpty())
            throw new IllegalArgumentException("The API URL cannot be undefined");

        ArrayList<Calendar> calList = new ArrayList<Calendar>();
        URL apiURL = new URL(baseURL);
        URLConnection apiRequest = apiURL.openConnection();
        apiRequest.addRequestProperty("Api-key", apiKey);

        Scanner apiResponse = new Scanner(apiRequest.getInputStream());
        StringBuilder jsonStr = new StringBuilder();

        while(apiResponse.hasNext())
            jsonStr.append(apiResponse.nextLine());

        apiResponse.close();
        JSONArray obj = new JSONArray(jsonStr.toString());
        System.out.println(obj.getJSONObject(0).keys());

        for(int i = 0; i < obj.length(); i++) {
            calList.add(new Calendar(obj.getJSONObject(i).getString("name"), obj.getJSONObject(i).getInt("id")));
        }

        return calList;
    }
}