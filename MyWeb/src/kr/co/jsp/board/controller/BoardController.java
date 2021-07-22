package kr.co.jsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));
		
		System.out.println(uri);
		
		switch(uri) {
		case "write":
			System.out.println("글쓰기 페이지로 이동 요청!");
			response.sendRedirect("board/board_write.jsp");
			break;
			
		case "regist":
			System.out.println("글 등록 요청이 들어옴!");
			
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
			
			//왜 board_list.jsp로 리다이렉트를 하면 안될까?
			//board_list.jsp에는 데이터베이스로부터 전체 글 목록을 가져오는
			//로직이 없으니까요. (단순히 보여주는 역할만 할 뿐이다.)
			//컨트롤러로 글 목록 요청이 다시 들어올 수 있게끔 
			//sendRedirect()를 사용해서 자동 목록 재요청이 들어오게 하는 겁니다.
			response.sendRedirect("/MyWeb/list.board");
			break;
			
		case "list":
			System.out.println("글 목록 요청이 들어옴!");
			List<BoardVO> list = BoardDAO.getInstance().listBoard();
			
			break;
		}
		
		
	}

}














