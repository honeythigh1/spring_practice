package kr.co.project.board.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import kr.co.project.board.dto.BoardDto;
import kr.co.project.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	@RequestMapping(value = "/")
	public ModelAndView hello(){	
		ModelAndView mv = new ModelAndView();
		List<BoardDto> list = service.getList();
		mv.addObject("list", list);
		mv.setViewName("boardPage/board");
		return mv;
	}
	
}

