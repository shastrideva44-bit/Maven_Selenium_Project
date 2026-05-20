package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws Throwable {
	FileReader filerR = new FileReader("./configAppData/JSONdata.json");
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(filerR);
	JSONObject map = (JSONObject)obj;
	String data = (String) map.get(key);
	return data;
	
}
}
