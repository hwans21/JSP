<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table {
		width: 800px;
	}
	
	tr {
		text-align: center;
	}
</style>

</head>
<body>

	<div align="center"> <!-- div(division)는 공간 영역에 대한 설정 태그 -->
	
		<form action="req_album_result.jsp">
			<table border="1">
				<tr>
					<th></th>
					<th>앨범 커버</th>
					<th>가수</th>
					<th>앨범 제목</th>
					<th>발매일</th>
				</tr>
				<tr>
					<td>
						<input type="radio" name="title" value="butter">
					</td>
					<td>
						<img alt="butter" src="butter.png" width="100px" height="100px">
					</td>
					<td>방탄소년단</td>
					<td>butter</td>
					<td>2021.05.21</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="title" value="dance">
					</td>
					<td>
						<img alt="dance" src="dance.jpg" width="100px" height="100px">
					</td>
					<td>오마이걸</td>
					<td>Dun Dun Dance</td>
					<td>2021.05.10</td>
				</tr>
				<tr>
					<td colspan="5">
						<input type="submit" value="확인">
					</td>
				</tr>
			</table>
		</form>
	
	</div>























</body>
</html>





















