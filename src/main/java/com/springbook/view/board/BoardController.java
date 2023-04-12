package com.springbook.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 긍록 처리");
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
//		System.out.println("글 수정 처리");
//		System.out.println("작성자 이름 : " + vo.getWriter());
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
		
	}
	
	// 글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
		
	}
	
	// 글 상세 조회
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {	// 메소드마다 리턴타입을 다르게 하는 것보다는 String으로 통일하는 것이 더 간결하기에 String 으로 통일한다.
		System.out.println("글 상제 조회 처리");

		BoardVO board = boardDAO.getBoard(vo);
		
		model.addAttribute("board", board);	// Model 정보 저장
		return "getBoard.jsp";	// View 이름 리턴
		
//		mav.addObject("board", board);	// Model 정보 저장
//		mav.setViewName("getBoard.jsp");	// View 정보 저장
//		return mav;
		
	}

	// 글 목록 검색
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(
			//@RequestParam : Annotation which indicates that a method parameter should be bound to a webrequest parameter. 
			// Spring MVC에서는 HTTP 요청 파라미터 정보를 추출하기 위한 @RequestParam을 제공함.
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("글 목록 검색 처리");
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		// Model 정보 저장
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";	// View 이름 리턴
		
//		mav.addObject("boardList",boardList);	// Model 정보 저장
//		mav.setViewName("getBoardList.jsp");	// View 정보 저장
//		return mav;
	}
}
