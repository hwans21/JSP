package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String keyword = "%" + request.getParameter("search") + "%";
		String category = request.getParameter("category");
		List<BoardVO> list = BoardDAO.getInstance().searchBoard(keyword, category);
		
		if(list.size() == 0) {
			request.setAttribute("searchFail", true);
		} else {
			request.setAttribute("boardList", list);			
		}
		
	}

}


















