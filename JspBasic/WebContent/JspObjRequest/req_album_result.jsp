<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String title = request.getParameter("title");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% if(title.equals("butter")) { %>
		
		<div align="center">
			<h2>선택하신 앨범 정보</h2>
			<hr>
			<p>
				당신이 선택하신 앨범은 방탄소년단의 <strong>'Butter'</strong> 입니다.
			</p>
			<hr>
			<h3>타이틀 곡 뮤직 비디오</h3>
			<iframe width="800" height="600" src="https://www.youtube.com/embed/WMweEpGlu_U?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			
		</div>
		
	<% } else if(title.equals("dance")) { %>
	
		<div align="center">
			<h2>선택하신 앨범 정보</h2>
			<hr>
			<p>
				당신이 선택하신 앨범은 오마이걸의 <strong>'Dun Dun Dance'</strong> 입니다.
			</p>
			<hr>
			<h3>타이틀 곡 뮤직 비디오</h3>
			<iframe width="800" height="600" src="https://www.youtube.com/embed/HzOjwL7IP_o?autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			
		</div>
		
	<% } %>

</body>
</html>














