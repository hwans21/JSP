package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 1. 파라미터값 가져오세요.
		 2. DAO의 regist()를 통해 DB에 데이터를 삽입.
		 (3번은 저랑 같이해요)
		 3. list.board라는 요청이 다시 컨트롤러로 들어올 수 있도록 해 주세요. 
		 */
		
		String writer = request.getParameter("bWriter");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		BoardDAO.getInstance().regist(writer, title, content);
		
	}

}
