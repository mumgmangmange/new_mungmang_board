package mungmang.java.go.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mungmang.java.go.command.BoardCommand;
import mungmang.java.go.dto.BoardDatas;

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
	public String read(Locale locale, Model model, @RequestParam(defaultValue="id") String id) {
		
		logger.info("read page", locale);
		
		int get_idx = Integer.parseInt(id);

		BoardDatas boarddatas = boardcommand.read(get_idx);
	    model.addAttribute("mungmang",boarddatas);
		
	    //조회수 증가처리
		boardcommand.countUp(boarddatas.getViewcount(), get_idx);

		return "read";
	}
	
	//글쓰기 뷰
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView write(Locale locale, @ModelAttribute("BoardDatas") BoardDatas boardDatas) {
		
		logger.info("write page", locale);
		
		ModelAndView modelAndView = new ModelAndView();
		
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardDatas", boardDatas); // boardDatas
	    modelAndView.addAllObjects(map);
	    
		return modelAndView;
	}
	
	//글쓰기 처리 
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write_ok(Locale locale, @Valid BoardDatas boardDatas, BindingResult bindingResult, Model model) {
		
		logger.info("write ok", locale);

        if(bindingResult.hasErrors()) {
        	
            return "write";
            
        } else {
        	
        	boardcommand.write(boardDatas);
        	return "redirect:/";
        }
	}
	
	//비밀번호창
	@RequestMapping(value = "/passwd_chk", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> passwd_chk(Locale locale, @RequestParam(defaultValue="idx") String idx, @RequestParam(defaultValue="password") String password) {
		
		logger.info("password_form page", locale);
		
		int get_idx = Integer.parseInt(idx);
		Boolean result = boardcommand.passwd_chk(get_idx, password);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result",result);
		
		return map;
	}
	
	//수정 뷰
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(Locale locale, @ModelAttribute("BoardDatas") BoardDatas boardDatas
			, @RequestParam(defaultValue="id") String id) {
		
		logger.info("edit page", locale);
		
		int get_idx = Integer.parseInt(id);
		
		System.out.println("edit idx>>" + id);
		ModelAndView modelAndView = new ModelAndView();
		
		BoardDatas boarddatas = boardcommand.read(get_idx);
		
		modelAndView.addObject("username", boarddatas.getUsername());
		modelAndView.addObject("subject", boarddatas.getSubject());
		modelAndView.addObject("contents", boarddatas.getContents());
		modelAndView.addObject("idx", boarddatas.getIdx());
	    
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("boardDatas", boardDatas); // boardDatas
	    modelAndView.addAllObjects(map);
	    
		return modelAndView;
	}
	
	//수정 처리
	@RequestMapping(value = "/modify_ok", method = RequestMethod.POST)
	public String modify_ok(Locale locale, @Valid BoardDatas boardDatas, BindingResult bindingResult, Model model) {
		
		logger.info("modify ok", locale);

        if(bindingResult.hasErrors()) {
        	
            return "modify";
            
        } else {
        	
        	boardcommand.modify(boardDatas);
        	return "redirect:/";
        }
	}

	//삭제 처리
	@RequestMapping(value = "/delete_ok", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete_ok(Locale locale, @RequestParam(defaultValue="idx") String idx) {
		
		logger.info("delete ok", locale);

		int get_idx = Integer.parseInt(idx);

		Map<String, Object> map = new HashMap<String, Object>();
		int result = boardcommand.delete(get_idx);
		map.put("result",result);
		return map;
	}
}
