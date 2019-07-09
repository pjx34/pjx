package com.grade.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grade.po.Grade;
import com.grade.po.Group;
import com.grade.po.User;
import com.grade.service.GradeService;
import com.grade.service.GroupService;
import com.grade.service.UserService;

import util.ViewExcel;

@Controller
@RequestMapping("/grade/")
public class GradeController 
{
	@Autowired
	UserService userService;
	@Autowired
	GradeService gradeService;
	@Autowired
	GroupService groupService;
	//保存成绩
	@RequestMapping(value="saveGrade")
	public String saveGrade(@Valid Grade grade,BindingResult bd,Model model,HttpServletRequest request)
	{
		//未登录不能评分
		HttpSession session = request.getSession();
		if(session.getAttribute("u")==null) {
			return "redirect:/login.jsp";
		}
		//数据校验
		if(bd.getErrorCount()>0) {
			return "redirect:/group/getGroupWithGrade";
		}
		//不能给自己小组评分
		String id = ((User) session.getAttribute("u")).getGroupId();
		if(grade.getGroupId().equals(id)) {
			List<Group> groupWithGrade = groupService.getGroupWithGrade(grade.getUserId());
			model.addAttribute("groupList", groupWithGrade);
			return "list";
		}
		//查询评分的人数
		int count = (int)gradeService.getSumUser(grade.getGroupId());
		//查询当前用户是否对该小组评分,若已经评分则更新,否则新增数据
		Integer gradeId = gradeService.getGradeId(grade.getGroupId(),grade.getUserId());
		float g = (float)Math.round(grade.getGrade()*100)/100;
		if(gradeId!=null) {
			gradeService.updateGrade(grade.getGroupId(),grade.getUserId(),g);
		}else {
			count++;
			gradeService.saveGrade(grade.getGroupId(),grade.getUserId(),g);
		}
		//查询目前平均分并保存
		int min=0,max=count;
		if(count>3) {
			min = (int) Math.round(0.1*count);
			max = (int) Math.round(0.8*count);
		}
		List<Integer> gradeList = gradeService.getAvgGrade(grade.getGroupId(),min,max);
		int sum = 0;
		if(gradeList!=null) {
			for(Integer g1:gradeList) {
				sum = sum+(int)g1;
			}	
		}
		float avg = 0;	
		if(count!=0) {
			if(count<3) {
				avg = (float)Math.round((sum/max)*100)/100;
			}else{
				avg = (float)Math.round((sum/max)*100)/100;
			}
		}else {
			avg = sum;
		}
		groupService.saveAvg(grade.getGroupId(), avg,count);
		List<Group> groupWithGrade = groupService.getGroupWithGrade(grade.getUserId());
		model.addAttribute("groupList", groupWithGrade);
		return "list";
	}
	
	//查询评分总人数
	public Integer sumUser(Integer groupId) {
		return gradeService.getSumUser(groupId);
	}
	
	//所有人对某个小组的评分并分页
	@RequestMapping("getGradesByGroupId/{groupId}/{pn}")
	public  String getGradesByGroupId(@PathVariable(value="pn")Integer pn,@PathVariable("groupId")Integer groupId,Model model){
		PageHelper.startPage(pn,10);
		List<Grade> gradeList = gradeService.getGradesByGroupId(groupId);
		if(gradeList.size()==0) {
			String msg = "暂无数据";
			model.addAttribute("msg", msg);
			return "avgDetail";
		}
		PageInfo<Grade> pageInfo = new PageInfo<Grade>(gradeList,10);//使用PageInfo包装查询结果,导航连续显示3页,然后将PageInfo交给页面
		Integer groupNumber = groupService.getGroupNumber(groupId);
		model.addAttribute("groupId", groupId);
		model.addAttribute("groupNumber", groupNumber);
		model.addAttribute("pageInfo", pageInfo);
		return "avgDetail";
	}
	
	//导出excel
	@RequestMapping("getUserExcel")
    public ModelAndView getUserExcel(ModelMap map) throws Exception{
         List<Map<String,String>> list = gradeService.selectUserExcel();
	        String[] titles={"学号","姓名","分组","评分"};
	        ViewExcel excel=new ViewExcel(titles);
	        map.put("excelList", list);
	        return new ModelAndView(excel,map);
	   }
}
