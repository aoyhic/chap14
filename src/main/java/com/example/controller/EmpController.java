package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.EmpDao;
import com.example.domain.Emp;

//서블릿과 같은 역할 . 스프링의 역할 /controller로 서블릿을 대체함 
@Controller
public class EmpController {
	
	static Log log = LogFactory.getLog(EmpController.class);
	
	@Autowired
	EmpDao dao;
		
	//웹브라우져에 /emp/listall을 치면 public String listall이 뜨는 것임. 
	@RequestMapping("/emp/listall")
	public String listAll(HttpServletRequest request){
		log.info("------------");
		log.info("listAll()");
		log.info("------------");
		List<Emp> list = dao.getallEmps();
		
		//리퀘스트에서 list를 emps라고  저장함. emps로 list를 찾아쓰면 됨. 
		request.setAttribute("emps", list);
		
		
		//listall? 뷰의 이름. jsp파일 이름이 listall이라는 것. listall은 어디있나? listall은 meta-inf/resources/WEB-INF/listall.jsp로 만들어둔다. 이때 listall을 뷰파일이라고 한다. 
		return "listall";
	}

}
