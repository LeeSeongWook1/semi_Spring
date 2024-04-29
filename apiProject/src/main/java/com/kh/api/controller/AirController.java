package com.kh.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AirController {

	public static final String SERVICE_KEY = "pvNZGxOL5T9nxoTzxKaRol4Oz%2FRdVI1aW1B0Bu7BSmwrwzr%2BzLgVLT4j%2Bo%2BSFFAsdAue%2Bt%2FpcHsr8pDpR8X%2FoQ%3D%3D";
	
	/***
	 * 
	 * @param sidoName
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="air",produces="application/json; charset=UTF-8")
	public String ajaxAir(String sidoName) throws IOException{
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&sidoName=" + URLEncoder.encode(sidoName, "UTF-8");
		url += "&returnType=json";
		url += "&numOfRows=30";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String responseJson = br.readLine();
		
		br.close();
		urlConnection.disconnect();
		
		return responseJson;
	}
	
	@ResponseBody
	@RequestMapping(value="xml", produces="text/html; charset=UTF-8")
	public String ajaxXml(String sidoName) throws IOException {
		String  url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
				url += "?serviceKey=" + SERVICE_KEY;
				url += "&sidoName=" + URLEncoder.encode(sidoName, "UTF-8");
				url += "&returnType=xml";
				//url += "&numOfRows=30";
		
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
