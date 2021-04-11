package com.automation.utility;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader 
{
	public static String getJson() throws IOException, ParseException
	{
		JSONParser jsonparser = new JSONParser();
		FileReader reader  = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\utility\\testdata.json");
		Object obj=jsonparser.parse(reader);
		JSONObject mobiletestdata = (JSONObject)obj;
		JSONArray testdataArray =(JSONArray)mobiletestdata.get("testdata");
		
		String testdata="";
		for(int i=0;i<testdataArray.size();i++)
		{
			JSONObject data =(JSONObject)testdataArray.get(i);
			String user=(String)data.get("phoneNumber");
			String pwd= (String)data.get("password");
			String loc1 = (String)data.get("location1");
			String loc2 = (String)data.get("location2");
		   	String note = (String)data.get("notes");
			String expMessage = (String)data.get("expectedMessage");
			testdata = user+","+pwd+","+loc1+","+loc2+","+note+","+expMessage;
			
		}
		
	  return testdata;
	}

}
