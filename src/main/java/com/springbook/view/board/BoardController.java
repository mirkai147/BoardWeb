package com.springbook.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	// �� ���
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ��� ó��");
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}

	// �� ����
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�� ���� ó��");
		
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
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ���� ��ȸ ó��");

		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board);	// Model ���� ����
		mav.setViewName("getBoard.jsp");	// View ���� ����
		return mav;
		
	}
	
	// �� ��� �˻�
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó��");

		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		mav.addObject("boardList",boardList);	// Model ���� ����
		mav.setViewName("getBoardList.jsp");	// View ���� ����
		return mav;
	}
}
