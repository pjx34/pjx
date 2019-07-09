package com.grade.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grade.po.Group;
import com.grade.po.User;
import com.grade.service.GroupService;
import com.grade.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	GroupService groupService;
	//登录
	@RequestMapping(value="login")
	public ModelAndView login(HttpServletRequest request,@Valid User user,BindingResult br,Model model)
	{
		model.addAttribute("uName", user.getUserName());
		model.addAttribute("uNumber", user.getUserNumber());
		if(br.getAllErrors().size()>0) {
			for(FieldError error:br.getFieldErrors()) {
				model.addAttribute(error.getField(), error.getDefaultMessage());
			}
			return new ModelAndView("forward:/login.jsp");
		}
		User u = userService.getUserByNameNumber(user);
		if(u==null) {
			model.addAttribute("error", "学号或姓名错误");
			model.addAttribute("uName", user.getUserName());
			model.addAttribute("uNumber", user.getUserNumber());
			return new ModelAndView("forward:/login.jsp");
		}
		HttpSession session = request.getSession();
		session.setAttribute("u", u);
		List<Group> groupList = groupService.getGroupOrder(u.getUserId());
		return new ModelAndView("list","groupList",groupList);	
	}
	//退出登录
	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	//根据姓名查询学号
	@RequestMapping("getUserNumber")
	public String getUserNumber(@Param("userName") String userName,Model model) 
	{
		if(userName.equals("")) {
			model.addAttribute("nameError", "姓名不能为空");
			return "forward:/queryUserNumber.jsp";
		} else if(userName!=null||userName!="") 
		{
			if(userName.equals("admin")) {
				return "forward:/queryUserNumber.jsp";
			}
			User ur = userService.getUserByName(userName);
			model.addAttribute("uName", userName);
			if(ur==null) {
				model.addAttribute("Error", "用户不存在");
				return "forward:/queryUserNumber.jsp";
			}else {
				model.addAttribute("ur", ur);
			}	
				
		}
		return "forward:/queryUserNumber.jsp";
	}
		
}
