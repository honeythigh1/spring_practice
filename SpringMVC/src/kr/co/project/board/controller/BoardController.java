package kr.co.project.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/writerPage")
	public ModelAndView insert() {
		return new ModelAndView("boardPage/writer");
	}
	
	@RequestMapping(value="/writer", method=RequestMethod.GET)
	public String insertBoard(@ModelAttribute("dto") BoardDto dto){
		service.insertBoard(dto);
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView detailPage(@ModelAttribute("dto") BoardDto dto){
		ModelAndView mv = new ModelAndView();
		BoardDto data = service.read(dto);
		mv.addObject("data", data);
		mv.setViewName("boardPage/detail");
		return mv;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView updatePage(@ModelAttribute("dto") BoardDto dto, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		BoardDto data = service.read(dto);
		System.out.println(request.getParameter("bno"));
		mv.addObject("data", data);
		mv.setViewName("boardPage/update");
		return mv;
	}
	
	@RequestMapping(value="/updateComplete")
	public String updateOk(@ModelAttribute("dto") BoardDto dto) throws Exception {
		service.updateBoard(dto);
		return "redirect:/boardList";
	}
	
}

