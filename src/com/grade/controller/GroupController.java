package com.grade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grade.po.Group;
import com.grade.po.User;
import com.grade.service.GradeService;
import com.grade.service.GroupService;

@Controller
@RequestMapping("/group/")
public class GroupController {
	
	@Autowired
	GroupService groupService;
	@Autowired
	GradeService gradeService;

	//初始化按照组名排序,所有人可以操作
	@RequestMapping("getGroupOrder")
	public ModelAndView getGroupOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");
		int userId = 0;
		if(u!=null) {
			userId = u.getUserId();
		}
		List<Group> groupWithGrade = groupService.getGroupOrder(userId);
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("groupList", groupWithGrade);
		return mv;
	}
	
	//查询当前用户对各个小组的评分
	@RequestMapping("getGroupWithGrade")
	public ModelAndView getGroupWithGrade(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");
		int userId = 0;
		if(u!=null) {
			userId = u.getUserId();
		}
		List<Group> groupWithGrade = groupService.getGroupWithGrade(userId);
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("groupList", groupWithGrade);
		return mv;
	}
		
		
	//随机查询所有小组
	@RequestMapping("getAllGroupRandom")
	public ModelAndView getAllGroupRandom(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		User u=  (User) session.getAttribute("u");
		//非admin不得抽签
		int userId = 0;
		if(u!=null&&u.getUserName()=="admin")
			userId = u.getUserId();
		//将抽签结果存进sort表
		List<Integer> groupIdList = groupService.getGroupIdList();
		if(groupIdList.size()>0) {
			groupService.dropSort();//清空sort表
			groupService.saveSort(groupIdList);
		}
		List<Group> allGroupRandom = groupService.getAllGroupRandom(userId);
		return new ModelAndView("list").addObject("groupList", allGroupRandom);
	}
	
	//保存平均分进入group表
	public void saveAvg(Integer groupId,Float avg,Integer groupScoreNum) {
		groupService.saveAvg(groupId,avg,groupScoreNum);
	}
	
	//查询所有小组平均分并按平均分排序
	@RequestMapping("getGroupWithAvg")
	public ModelAndView getGroupWithAvg(){
		List<Group> groupList = groupService.getGroupWithAvg();
		return new ModelAndView("avgGrade").addObject(groupList);
	}
	
	//将抽签结果存入sort表
	public void saveSort(List<Integer> groupIdList) {
		groupService.saveSort(groupIdList);
	}
}
