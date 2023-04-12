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
	
	// �˻� ���� ��� ����
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}

	// �� ���
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

	// �� ����
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
//		System.out.println("�� ���� ó��");
//		System.out.println("�ۼ��� �̸� : " + vo.getWriter());
		System.out.println("��ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ۼ��� : " + vo.getWriter());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : " + vo.getCnt());
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
		
	}
	
	// �� ����
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
		
	}
	
	// �� �� ��ȸ
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {	// �޼ҵ帶�� ����Ÿ���� �ٸ��� �ϴ� �ͺ��ٴ� String���� �����ϴ� ���� �� �����ϱ⿡ String ���� �����Ѵ�.
		System.out.println("�� ���� ��ȸ ó��");

		BoardVO board = boardDAO.getBoard(vo);
		
		model.addAttribute("board", board);	// Model ���� ����
		return "getBoard.jsp";	// View �̸� ����
		
//		mav.addObject("board", board);	// Model ���� ����
//		mav.setViewName("getBoard.jsp");	// View ���� ����
//		return mav;
		
	}

	// �� ��� �˻�
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(
			//@RequestParam : Annotation which indicates that a method parameter should be bound to a webrequest parameter. 
			// Spring MVC������ HTTP ��û �Ķ���� ������ �����ϱ� ���� @RequestParam�� ������.
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("�� ��� �˻� ó��");
		System.out.println("�˻� ���� : " + condition);
		System.out.println("�˻� �ܾ� : " + keyword);

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		// Model ���� ����
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";	// View �̸� ����
		
//		mav.addObject("boardList",boardList);	// Model ���� ����
//		mav.setViewName("getBoardList.jsp");	// View ���� ����
//		return mav;
	}
}
