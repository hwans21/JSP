<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		int total = 0;
		for(int i=1; i<=100; i++) {
			total += i;
		}
		out.print("<h4>1부터 100까지의 누적합: " + total + "</h4>");
	--%>
	
	<%--
		<c:set> 태그는 변수의 생성과 동시에, 이미 동일한 이름의 변수가 존재한다면
		 기존의 변수를 지목해서 값을 변경할 때도 사용합니다.
	 --%>
	
	<c:set var="total" value="0" />
	<c:forEach var="i" begin="1" end="100" step="1">
		<c:set var="total" value="${total + i}" />
	</c:forEach>
	
	<h4>1부터 100까지의 누적합: ${total}</h4>
	
	<hr>
	
	<h4>구구단 4단</h4>
	<%-- <% for(int hang=1; hang<=9; hang++) { %>
		4 x <%=hang %> = <%=4*hang %> <br>
	<% } %> --%>
	
	<c:forEach var="hang" begin="1" end="9"> <%-- step을 생략 시 자동으로 1로 처리됨. --%>
		4 x ${hang} = ${4*hang} <br>
	</c:forEach>
	
	<%-- 구구단을 2단부터 9단까지 출력하는데, 짝수단만 출력해 보세요. (jstl) --%>
	<c:forEach var="dan" begin="2" end="9">
		<c:if test="${dan % 2 == 0}">
			<h4>구구단 ${dan}단</h4>
			<c:forEach var="hang" begin="1" end="9">
				${dan} x ${hang} = ${dan*hang} <br>
			</c:forEach>
			<hr>
		</c:if>
	</c:forEach>
	
	<h2>배열이나 컬렉션 내부의 값을 출력</h2>
	
	<c:set var="arr" value="<%=new int[] {1, 3, 5, 7, 9} %>" />
	
	<c:forEach var="n" items="${arr}">
		${n} &nbsp;
	</c:forEach>
	

</body>
</html>


















