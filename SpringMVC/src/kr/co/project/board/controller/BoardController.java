package kr.co.project.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.project.board.dto.BoardDto;
import kr.co.project.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/")
	public String hello() {
		return "redirect:/boardList";
	}

	@RequestMapping(value = "/boardList")
	public ModelAndView boardList(HttpServletRequest request){	
		ModelAndView mv = new ModelAndView();
	
		String page = "";
		if(page.equals("")) {
			page = request.getParameter("currentPage");
		}
		int	currentPage = Integer.parseInt(page);
		
		System.out.println("현재 페이지 번호 : "+ currentPage);
		int totalCount = service.totalCount(); //게시물 총 개수
		int countList = 10; //한 페이지에 보여줄 게시물 수
		int totalPage = totalCount / countList; // 페이지 개수
		if(totalCount % countList > 0)
			totalPage++;
		
		//현재 페이지 number가 페이지 개수보다 크다면
		if(totalPage < currentPage) {
			currentPage = totalPage;
		}
		
		int startPage = (((currentPage - 1) / countList) * countList) + 1;
		int endPage = startPage + countList - 1;
		
		if(endPage > totalPage)
			endPage = totalPage;
		
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		List<BoardDto> list = service.selectAll(currentPage);
		mv.addObject("list", list);
		mv.addObject("totalPage", totalPage);
		mv.addObject("totalCount", totalCount);
		mv.addObject("totalPage", totalPage);
		mv.addObject("currentPage", currentPage);
		mv.addObject("startPage", startPage);
		mv.addObject("endPage", endPage);
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

