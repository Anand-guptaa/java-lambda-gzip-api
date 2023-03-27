package com.awslambdapoc.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import com.awslambdapoc.dto.JsonTestData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResponseUtil {

	
	   public static ByteArrayOutputStream compress(List<JsonTestData> jsonData) throws Exception {
	        System.out.println("Original String Length : " );
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String str = gson.toJson(jsonData);
	        ByteArrayOutputStream obj=new ByteArrayOutputStream();
	        GZIPOutputStream gzip = new GZIPOutputStream(obj);
	        gzip.write(str.getBytes("UTF-8"));
	        gzip.close();
	        return obj;
	    }
	   
	   public static List<JsonTestData> getData() {
			 List<JsonTestData> listJson = new ArrayList<>();
			 JsonTestData data= null;
			 for (int i = 0; i < 10000; i++) {
				 data= new JsonTestData("john"+i, "A", "doe", "25");
				 listJson.add(data);
			}
			 return listJson;
		 }
}
