<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//예매가 확정된 좌석 정보를 저장할 리스트
    	List<String> list = new ArrayList<>();
    	if(application.getAttribute("complete_list") != null) {
    		list = (List<String>) application.getAttribute("complete_list");
    	}
    	
    	/*
    	- 사용자가 예매를 희망하는 좌석과, 이미 예약이 완료된 리스트(확정 리스트) 를 비교하여
		 좌석이 존재할 때마다 일치하는 숫자를 세 주세요.
		 
		- 일치하는 좌석이 하나라도 존재한다면 list에 추가하시면 안됩니다.
		하나도 일치하지 않았을 경우 확정 list에 좌석을 추가해 주세요.
		배열에 있는 좌석이 확정 리스트에 있는지를 비교하여 없을 때마다 temp에 추가해 주세요.
		seat의 갯수와 숫자를 센 변수가 일치하면 겹치지 않은 것이므로 확정 리스트에 그대로
		추가해 주시면 됩니다. (addAll()-> 리스트 내부에 리스트 객체들을 전부 추가하는 메서드.)
		
		- 확정 리스트에 추가 후 application 객체에 setAttribute 해 주세요.
		데이터 이름: "complete_list"
    	*/
    	
    	//사용자가 예매를 희망하는 좌석 정보가 들어있는 배열
    	String[] seat = request.getParameterValues("seat");
		
		//예약 확정 전에 임시로 좌석 정보를 저장할 리스트
		List<String> temp = new ArrayList<>();
		
		//몇 자리를 예매할 수 있는지의 여부를 체크할 변수
		int count = 0;
		for(String s : seat) {
			if(list.contains(s)) break;
			else {
				temp.add(s);
				count++;
			}
		}
		
		//예매 희망 좌석이 확정 좌석과 하나도 겹치지 않은 경우
		if(count == seat.length) {
			list.addAll(temp);
		}
    

    	application.setAttribute("complete_list", list);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		- 선택한 좌석이 뭐였는지 브라우저에 출력해 주세요.
		ex) 선택한 좌석: [A-1, A-2, A-3 ....]
		
		- 예매 신청 결과를 출력해 주세요 (성공 / 실패)
		- 추가 예매를 할 수 있도록 예약창으로 돌아가는 링크를 제공해 주세요.
		  (concert_reserve.jsp)
	 --%>
	 
	 <div align="center">
	 	<h2>좌석 예매 결과</h2>
	 	<p>
	 		선택한 좌석 <br>
	 		<% for(String s : seat) { 
	 			out.print("<strong>[" + s + "]</strong>");
	 		}
	 		%>
	 		<br>(이)가 예매 신청되었습니다.
	 	</p>
	 	<p>
	 		예매 신청 결과: <%= (count == seat.length) ? "성공" : "실패" %>
	 		<br>
	 		<% if(count != seat.length) { %>
	 			예매하고자 하는 좌석이 이미 선점되었습니다.
	 		<% } %>
	 		<br>
	 		<a href="concert_reserve.jsp">추가 예매하기</a>
	 	</p>
	 </div>
	 
	 

</body>
</html>















