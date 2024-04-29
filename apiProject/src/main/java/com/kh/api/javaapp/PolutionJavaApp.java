package com.kh.api.javaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.api.model.vo.AirVO;

public class PolutionJavaApp {

	public static final String SERVICE_KEY = "pvNZGxOL5T9nxoTzxKaRol4Oz%2FRdVI1aW1B0Bu7BSmwrwzr%2BzLgVLT4j%2Bo%2BSFFAsdAue%2Bt%2FpcHsr8pDpR8X%2FoQ%3D%3D";

	public static void main(String[] args) throws IOException {

		// System.out.println("하이하이ㄱ");

		// 내가 Java언어로 만든 Client Program으로 API서버로 요청 보내고 응답 받기!

		// String 자료형으로 url 선언하기

		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8");
		url += "&returnType=json";
		
		// System.out.println(url);

		// 자바 코드로 요청을 보내야함!!
		// Connection => **HttpURLConnection 객체를 활용해서 API서버로 요청
		
		//1. java.net.URL 객체생성 => 생성자 호출 시 url 값을전달
		URL requestUrl = new URL(url);
		//2. 1번 과정으로 생성된 URL 객체를 가지고 HttpUrlConnection 객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
		//3. 요청에 필요한 Header 설정
		urlConnection.setRequestMethod("GET");
		//4. API서버와 스트림을 연결
		
		//해야하는 작업
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		/*
		System.out.println(br.readLine());
		*/
		/*
		String responseXml = "";
		
		while((responseXml = br.readLine())!=null) {
			System.out.println(responseXml);
		}
		*/
		
		String responseJson = br.readLine();
//		System.out.println(responseJson);
		
		/*
		 * 
		 * 
		 */
		
		//라이브러리
		//JsonObject , JsonArray=> JSON라이브러리제공
		//JsonObject , JsonArray, JsonObject=> GSON에서 제공
		
		JsonObject jsonObj = JsonParser.parseString(responseJson).getAsJsonObject();
//		System.out.println(jsonObj);
		
		/*
		Map<String,String> map =new HashMap();
		
		map.put("response","{body}");
		
		System.out.println(map.get("response"));
		*/
		JsonObject responseObj = jsonObj.getAsJsonObject("response");
//		System.out.println(responseObj);
		JsonObject bodyObj = responseObj.getAsJsonObject("body");
//		System.out.println(bodyObj);
		
		int totalCount = bodyObj.get("totalCount").getAsInt(); //=>totalCount key 접근 : int
//		System.out.println(totalCount);
		JsonArray items = bodyObj.getAsJsonArray("items");
//		System.out.println(items);
		
		List<AirVO> list = new ArrayList();
		
		for(int i=0; items.size() >i;i++) {
		
			JsonObject firstItem = items.get(i).getAsJsonObject();
			
	//		System.out.println(firstItem);
			
			AirVO air = new AirVO();
			air.setStatitonName(firstItem.get("stationName").getAsString());
			air.setDataTime(firstItem.get("dataTime").getAsString());
			air.setSo2Value(firstItem.get("so2Value").getAsString());
			air.setPm10Value(firstItem.get("pm10Value").getAsString());
			air.setO3Value(firstItem.get("o3Value").getAsString());
			air.setCoGrade(firstItem.get("coGrade").getAsString());
			air.setKhaiValue(firstItem.get("khaiValue").getAsString());
			
			list.add(air);
		}
		
//		System.out.println(air);
		
		
		for(AirVO air : list) {
			System.out.println(air);
		}
		
		//객체 반납
		br.close();
		urlConnection.disconnect();
		
		
	}
}

