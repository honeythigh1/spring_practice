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
	public ModelAndView boardList(){	
		ModelAndView mv = new ModelAndView();
		
		int totalCount = service.totalCount(); //게시물 총 개수
		int countList = 10; //한 페이지에 보여줄 게시물 수
		int totalPage = totalCount / countList;
		System.out.println(totalPage);
		if(totalCount > countList * totalPage)
			totalPage++;
		
		List<BoardDto> list = service.selectAll();
		mv.addObject("list", list);
		mv.setViewName("boardPage/board");
		
		return mv;
	}
	
	@RequestMapping(value="/writerPage")
	public ModelAndView insert() {
		return new ModelAndView("boardPage/writer");
	}
	
	@RequestMapping(value="/writer")
	public String insertBoard(@ModelAttribute("dto") BoardDto dto){
		service.insertBoard(dto);
		return "redirect:/";
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
		return "redirect:/";
	}
	
}

