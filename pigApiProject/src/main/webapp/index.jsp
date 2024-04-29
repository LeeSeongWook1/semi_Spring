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

	
	<h1>비 만 율</h1>
		구분 :
	<select id="SERIESNAME">
		<option>전체</option>
		<option>남성</option>
		<option>여성</option>
	</select>
	<br>
	<button class="btn btn-info" id="btn1">해당구분돼지정보</button>
	<br><br>
	
	
	<script>
		$(function(){
			$('#btn1').click(function(){
				$.ajax({
					url : 'xml',
					data : {SERIESNAME : $('#SERIESNAME').val()},
					type : 'get',
					success : data => {
						console.log(data);
						/*
						const items = $(data).find('item');
						let value='';
						items.each((i,item)=>{
							
							value+= '<tr>'
									+'<td>' +$(item).find('TOTAL').text() +'</td>'
									+'<td>' +$(item).find('APC_VALUE').text() +'</td>'
									+'<td>' +$(item).find('APC_CI').text() +'</td>'
									+'<td>' +$(item).find('YEAR').text() +'</td>'
									+'<td>' +$(item).find('CI').text() +'</td>'
									+'<td>' +$(item).find('VALUE').text() +'</td>'
									+'<td>' +$(item).find('APC_YEAR').text() +'</td>'
									+'</tr>'; 
							
							
						});
						*/
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
		<thead class="thead-light">
			<tr>
				<th>토탈<th>
				<th>연간 변화율</th>
				<th>신뢰 구간</th>
				<th>연도</th>
				<th>비만율 범위</th>
				<th>해당 연도의 비만율 값</th>
				<th>데이터의 연도 범위</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="7">남여구분을 선택하시고 조회버튼을 눌러주세요 </th>
			</tr>
		</tbody>
	</table>
	
	
	
</body>
</html>