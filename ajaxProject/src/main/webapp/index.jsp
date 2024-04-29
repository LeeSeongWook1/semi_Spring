<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>나는 웹컴파일</h1>

	<h1>AJAX 요청 보내고 응답받기</h1>

	<h3>1. 요청 시 전달, 응답결과 받아보기~~</h3>

	메뉴 : <input type="text" id="menu"><br>
	가격 : <input type="number" id="price"><br><br>
	
	<div id="result1">
	
		<label id = "menu-name"></label> | <label id="menu-id"></label>
	</div>
	
	
	<button onclick="test1();">전송</button>

	<script>
		function test1(){
			
			$.ajax({
				url : 'ajax1.do', //필수점의 속성(매핑값)
				type : 'get',// 요청 시 전달방식
				data : {//요청 시 전달값 (key-value)
					menu : $('#menu').val(), //value속성값에 접근했을 경우!! == string
					price : $('#price').val()
				},
				success : function(result){ //해당 비동기 통신에 성공했을 떄 수행되는 핸들러
					console.log(result);
				},
				error : function(){
					
				}
				
			});
			
		}	
	</script>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<h3>2. 조회를 했다는 가정하에 객체를 응답받아서 요소에 출력해보기</h3>

조회할 음식번호 : <input type="number" id="menuNo"/>

<button id="btn2">조회</button><br>
<div id="result2">
</div>

<script>
	$(function(){
		$('#btn2').click(function(){
			$.ajax({
				url : 'ajax2.do',
				data : {num : $('#menuNo').val()},
				success : function(result){
					console.log(result);
					
					const menu='<ul>오늘의 메뉴'
								+'<li>' +result.material +'로 만든' +result.menuName+'</li>'
								+'<li>' +result.price+'원</li>'
								+'</ul>';
					$('#result').html(menu);
					
				}
			});
		});
	})
</script>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<h3>3. 조회 후 리스트를 응답받아서 출력</h3>

<button onclick="test3();">메뉴 조회</button>
<br><br>

<table border= "1" id="result3">
	<thead>
		<tr>
			<th>메뉴명</th>
			<th>가격</th>
			<th>재료</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

<script>
	function test3(){
		$.ajax({
			url:'ajax3.do',
			success:function(result){
				//console.log(result);
				let menus ='';
				for(let i in result){
					menus+= '<tr>'
							+'<td>' +result[i].menuName + '</td>'
							+'<td>' +result[i].price + '</td>'
							+'<td>' +result[i].material + '</td>'
							+'</tr>';
				}
				$('tbody').html(menus);
				
			}
		});
		
	}

</script>
</body>
</html>