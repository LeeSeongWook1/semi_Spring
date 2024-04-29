package com.kh.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PigController {
	public static final String SERVICE_KEY = "pvNZGxOL5T9nxoTzxKaRol4Oz%2FRdVI1aW1B0Bu7BSmwrwzr%2BzLgVLT4j%2Bo%2BSFFAsdAue%2Bt%2FpcHsr8pDpR8X%2FoQ%3D%3D";
	

	/***
	 * 
	 * @param SERIESNAME
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="xml", produces="text/html; charset=UTF-8")
	public String ajaxXml(String SERIESNAME) throws IOException{
		String  url = "https://apis.data.go.kr/B551172/getPreventFat/TotalAdultFatTrend";
				url+="?serviceKey="+SERVICE_KEY;
				url+="&SERIESNAME=" + URLEncoder.encode(SERIESNAME,"UTF-8");
				url += "&returnType=xml";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//		String responseJson = br.readLine();
		
		
		String responseXml="";
		String line;
		
		while((line=br.readLine())!=null) {
			responseXml +=line;
		}
		
		br.close();
		urlConnection.disconnect();
		return responseXml;
				
	}
	
	
}
