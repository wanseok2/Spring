package com.wan.app.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wan.app.domain.BoardVO;
import com.wan.app.persistence.BoardDAO;
import com.wan.app.service.BoardService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	
	
	@RequestMapping("/board/register")
	public void registerGET(){
		
	}
	
	//����Ʈ�϶� ����
	@RequestMapping(value="/board/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
		logger.info("registerPOST: " + board.toString());
		rttr.addFlashAttribute("msg","SUCCESS");
		service.register(board);
		return "redirect:/board/listAll";
	}
	
	//�Խ��� ��Ϻ���
	@RequestMapping("/board/listAll")
	public void listAll(Model model) throws Exception{		
		model.addAttribute("list",service.listAll());
	}
	
	//�Խ��� �ۺ���
	@RequestMapping("/board/read")
	public void read(int bno, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	//�Խ��� ���������� �̵�
	@RequestMapping("/board/modify")
	public void boardModiGET(){
		
	}
	
	//�Խ��� ����
	@RequestMapping(value="/board/modify",method=RequestMethod.POST)
	public String boardModiPOST(int bno, BoardVO board) throws Exception{
		service.modify(board);
		return "redirect:/board/read?bno="+bno;
	}
	
	//�Խ��� ����
	@RequestMapping("/board/remove")
	public String remove(int bno) throws Exception{
		service.remove(bno);
		return "redirect:/board/listAll";
	}
}
