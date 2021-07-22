package kr.co.jsp.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//글 번호 받아오셔서 DAO의 contentBoard() 호출
		//가져온 데이터를 request에 담아서 board_content.jsp로 포워딩
		//content.jsp에서 데이터를 화면에 뿌려 보세요.
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		/*
		 # 쿠키로 조회수를 컨트롤 해 보자.
		 1. 사용자가 글 제목을 눌러서 상세보기 요청을 보낼 때 
		 글 번호로 된 쿠키를 하나 만들어 줄 겁니다. (String)
		 
		 2. 요청을 보낼 때 같이 넘어온 쿠키 중에, 
		  현재 글 번호와 일치하는 쿠키가 존재한다면 조회수를 올려주지 않을 겁니다.
		  현재 글 번호와 일치하는 쿠키가 없다면 조회수를 올려주도록 하겠습니다.
		  쿠키의 수명은 15초로 설정하겠습니다.
		 */
		
		String bNum = request.getParameter("bId");
		
		Cookie hitCoo = new Cookie(bNum, bNum);
		hitCoo.setMaxAge(15);
		response.addCookie(hitCoo);
		
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(bNum)) {
					flag = true;
					break;
				}
			}
		}
		
		if(!flag) {
			BoardDAO.getInstance().upHit(bId);
			
		}
		
		
		
		BoardVO vo = BoardDAO.getInstance().contentBoard(bId);
		
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		request.setAttribute("article", vo);
	}

}











