package com.grade.upload.comtroller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.grade.po.Group;
import com.grade.po.User;
import com.grade.service.GradeService;
import com.grade.service.GroupService;
import com.grade.service.UserService;

import util.ReadExcel;

@Controller
@RequestMapping("/excelUpload/")
public class ExeclUpload {
	@Autowired
	GradeService gradeService;
	
	@Autowired
	GroupService groupService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("form")
	public String form(HttpServletRequest request,Model model)throws Exception{
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("u");
		System.out.println("****************************************"+u);
		if(u==null||!u.getUserName().equals("admin")) {
			throw new Exception("非admin不得上传文件");
		}
	     MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;     
	       
	     InputStream in =null;  
	     List<List<Object>> listob = null;  
	     MultipartFile file = multipartRequest.getFile("upfile");  
	    
	     System.out.println(file);
	     if(file.isEmpty()){      	
	         return "forward:/import.jsp";  
	     }  
	     in = file.getInputStream();  
	     listob = new ReadExcel().getBankListByExcel(in,file.getOriginalFilename());
	     in.close();  
	    
	     //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
	     List<User> userList = new  ArrayList<User>();
	     List<Group> groupList =new ArrayList<Group>();
	     for (int i = 0; i < listob.size(); i++) {  
	         List<Object> lo = listob.get(i);  
	         User user = new User();
	         Group group = new Group();
	         //查询已经导入多少个小组(支持分批导入)
	         int groupNum = (int)groupService.getGroupNum();
	         user.setUserNumber(String.valueOf(lo.get(1)));  
	         user.setUserName(String.valueOf(lo.get(2)));  
	         user.setGroupId(String.valueOf(lo.get(3))+groupNum);
	         
	         //存入group表的数据
	         String groupId = String.valueOf(lo.get(3))+groupNum;
	         String groupNumber = String.valueOf(lo.get(4));
	         String projectName = String.valueOf(lo.get(6));
	         if(!groupNumber.equals("")) {
	        	 group.setGroupId(groupId);
	        	 group.setGroupNumber(groupNumber);
	        	 group.setProjectName(projectName);
	        	 groupList.add(group);
	         }
	         userList.add(user);
	         
	         System.out.println("打印信息-->"+user);  
	     }  
	     System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++"+groupList);
	     groupService.saveGroupList(groupList);
	     userService.SaveUserList(userList);

	    return "success";
	}	
	
	//导入前先清空数据
	@RequestMapping("clear")
	public String clear(HttpServletRequest request,Model model) throws Exception {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");
		if(u==null||!u.getUserName().equals("admin")) {
			throw new Exception("非admin不得清空数据");
		}
		gradeService.deleteGradeList();
		groupService.deleteGroupList();
		userService.deleteUserList();
		model.addAttribute("msg","清除成功");
		return "forward:/import.jsp";
		
	}
}
