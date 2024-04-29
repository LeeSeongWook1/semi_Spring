<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <!-- jQuery 라이브러리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- 부트스트랩에서 제공하고 있는 스타일 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- 부트스트랩에서 제공하고 있는 스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


	<h1>지역별 대기오염 상태</h1>

	시도 :
	<select id="sidoName">
		<option>전국</option>
		<option>서울</option>
		<option>부산</option>
		<option>대구</option>
		<option>인천</option>
		<option>광주</option>
		<option>대전</option>
		<option>울산</option>
		<option>경기</option>
		<option>경기</option>
		<option>강원</option>
		<option>충북</option>
		<option>충남</option>
		<option>전북</option>
		<option>전남</option>
		<option>경북</option>
		<option>경남</option>
		<option>제주</option>
		<option>세종</option>
	</select>
	
	<br>
	<button class="btn btn-info" id="btn1">해당지역대기정보</button>
	<br><br>


	<script>
		$(function(){
			$('#btn1').click(function(){
			/*	
				$.ajax({
					url : 'air',
					data : {sidoName : $('#sidoName').val()},
					type : 'get',
					success : function(result){
						//console.log(result.response.body.items);
						
						const items = result.response.body.items;
						
						let str = '';
						for(let i in items){
							const item = items[i];
							
							str+= '<tr>'
								+ '<td>' +item.stationName+'</td>'
								+ '<td>' +item.dataTime + '</td>'
								+ '<td>' +item.o3Value+'</td>'
								+ '<td>' +item.pm10Value+'</td>'
								+ '<td>' +item.khaiValue+'</td>'
								+ '</tr>';
						}
						
						$('tbody').html();
					}
				});
				*/
				
				/*
					익명함수를 화살표 표기법을 이용해서 작성(가시성이 좋음)
				
					"function(){}"를 		"()=>{}"" 이렇게 작성할 수 있음
					
					"function(a){}"를		"a =>{}" 이렇게 작성할 수 있음
					
					"function(a,b){}"를 		"(a,b)=>{}"이렇게 작성할 수 있음
					
					"function(){return 'a'}"를  ()=>'a'"이렇게 작성할 수 있음
					
				*/
				
				$.ajax({
					url : 'xml',
					data : {sidoName : $('#sidoName').val()},
					type : 'get',
					success : data => {
						
						//console.log(data);
						
						//jQuery => find() : 기준이 되는 요소의 하위요소들 중 특정 요소를 찾을 떄 사용(HTML요소) -> XML 요소에도 사용가능
						
						//console.log($(data).find('item'));
						
						//XML형식의 응답데이터를 받았을떄
						//1. 응답 데이터에서 실제 데이터가 담겨있는 요소 선택
						const items = $(data).find('item');
						
						//2.반복문을 통해 실제 데이터가 담긴 요소들에 접근해서 동적으로 요소 만들기!
						let value='';
						items.each((i,item)=>{ //1번 i에는 index, 2번 item에는 element
							//console.log(item);
							//console.log($(item).find('stationName').text());
							
							value+= '<tr>'
									+'<td>' +$(item).find('stationName').text() +'</td>'
									+'<td>' +$(item).find('dataTime').text() +'</td>'
									+'<td>' +$(item).find('o3Value').text() +'</td>'
									+'<td>' +$(item).find('pm10Value').text() +'</td>'
									+'<td>' +$(item).find('khaiValue').text() +'</td>'
									+'</tr>'; 
							
							
						});
						
						$('tbody').html(value);
						
						
					},
					error : () => {
						console.log('실패');
					}
				})
				
			});
			
		})
	
	</script>


	<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th>측정소명</th>
				<th>측정일시</th>
				<th>오존농도</th>
				<th>미세먼지농도</th>
				<th>통합 대기환경수치</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="5">지역을 선택하시고 조회버튼을 눌러주세요 </th>
			</tr>
		</tbody>
	</table>
	
</body>
</html>