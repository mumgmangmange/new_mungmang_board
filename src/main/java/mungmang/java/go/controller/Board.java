package mungmang.java.go.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mungmang.java.go.command.BoardCommand;
import mungmang.java.go.dto.BoardDatas;
import mungmang.java.go.dto.Passwd_chk;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Board {
	
	private static final Logger logger = LoggerFactory.getLogger(Board.class);
	
	@Autowired
	BoardCommand boardcommand;

	//메인 리스트
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, 
			@ModelAttribute("BoardDatas") BoardDatas boardDatas, 
			@RequestParam(defaultValue="title") String searchOption,
            @RequestParam(defaultValue="") String keyword) {
		
		logger.info("list page", locale);
		
		List<BoardDatas> list = boardcommand.list("", "");
		
		ModelAndView modelAndView = new ModelAndView();
		
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list", list); // list
	    map.put("searchOption", searchOption); // 검색옵션
	    map.put("keyword", keyword); // 검색키워드
	    modelAndView.addObject("mungmang", map); // 맵에 저장된 데이터를 mav에 저장
	    modelAndView.setViewName("list"); // 뷰를 list.jsp로 설정

		return modelAndView;
	}

	//읽기 뷰
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Locale locale, Model model, @RequestParam(defaultValue="id") int id) {
		logger.info("read page", locale);

		BoardDatas boarddatas = boardcommand.read(id);
	    model.addAttribute("mungmang",boarddatas);
		
	    //조회수 증가처리
		boardcommand.countUp(boarddatas.getViewcount(), id);

		return "read";
	}
	
	//비밀번호창
	@RequestMapping(value = "/passwd_chk", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> passwd_chk(Locale locale, Passwd_chk passwd_chk) {
		logger.info("password_form page", locale);
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean chk = boardcommand.passwd_chk(passwd_chk);
		map.put("chk",chk);
		map.put("updel",passwd_chk.getUpdel());
		return map;
	}
	
	//수정 뷰
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView edit(Locale locale, @ModelAttribute("BoardDatas") BoardDatas boardDatas
			, @RequestParam(defaultValue="idx") int idx) {
		
		logger.info("edit page", locale);
		
		System.out.println("edit idx>>" + idx);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("write");
		modelAndView.addObject("title", "게시판 - 수정");
		modelAndView.addObject("btn_one_id", "modify_ok");
		modelAndView.addObject("btn_one_text", "수정");

		BoardDatas boarddatas = boardcommand.read(idx);
		
		modelAndView.addObject("username", boarddatas.getUsername());
		modelAndView.addObject("subject", boarddatas.getSubject());
		modelAndView.addObject("contents", boarddatas.getContents());
	    
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardDatas", boardDatas); // boardDatas
	    modelAndView.addAllObjects(map);
	    
		return modelAndView;
	}
	
	//글쓰기 뷰
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView write(Locale locale, @ModelAttribute("BoardDatas") BoardDatas boardDatas) {
		logger.info("write page", locale);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("write");
		modelAndView.addObject("title", "게시판 - 쓰기");
		modelAndView.addObject("btn_one_id", "write_ok");
		modelAndView.addObject("btn_one_text", "쓰기");
		modelAndView.addObject("next_page", "write_ok");
		
		modelAndView.addObject("username", "");
		modelAndView.addObject("subject", "");
		modelAndView.addObject("contents", "");

	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardDatas", boardDatas); // boardDatas
	    modelAndView.addAllObjects(map);
	    
		return modelAndView;
	}
	
	//글쓰기 처리 
	@RequestMapping(value = "/write_ok", method = RequestMethod.POST)
	public String write_ok(Locale locale, @ModelAttribute("BoardDatas") BoardDatas boardDatas, BindingResult bindingResult, Model model, Errors errors) {
		
		logger.info("write ok", locale);
		
		if(errors.hasErrors()) {
			return "go/write";
		}
		
        if(bindingResult.hasErrors()) {
        	
            System.out.println("등록 중 에러발생");
            return "redirect:/write";
            
        } else {
        	boardcommand.write(boardDatas);
        	return "redirect:/";
        }
	}

	//삭제 처리
	@RequestMapping(value = "/delete_ok", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete_ok(Locale locale, @RequestParam(defaultValue="idx") int idx) {
		
		logger.info("delete ok", locale);

		Map<String, Object> map = new HashMap<String, Object>();
		int result = boardcommand.delete(idx);
		map.put("result",result);
		return map;
	}
}
