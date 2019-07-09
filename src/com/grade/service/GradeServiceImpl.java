package com.grade.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grade.dao.GradeMapper;
import com.grade.dao.GroupMapper;
import com.grade.po.Grade;
import com.grade.po.Group;
import com.grade.po.User;



@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	GradeMapper gradeMapper;
	@Autowired
	GroupMapper groupMapper;
	@Override
	public void saveGrade(Integer groupId, Integer userId, Float grade) {
		// TODO Auto-generated method stub
		if(grade==null) {
			return;
		}
		gradeMapper.insertGrade(groupId,userId,grade);
	}
	@Override
	public Integer getGradeId(Integer groupId, Integer userId) {
		// TODO Auto-generated method stub
		return gradeMapper.selectGradeId(groupId,userId);
	}
	@Override
	public void updateGrade(Integer groupId, Integer userId, Float grade) {
		// TODO Auto-generated method stub
		if(grade==null) {
			return;
		}
		gradeMapper.updateGrade(groupId, userId, grade);
	}
	@Override
	public Integer getSumUser(Integer groupId) {
		// TODO Auto-generated method stub
		return gradeMapper.selectSumUser(groupId);
	}
	@Override
	public List<Integer> getAvgGrade(Integer groupId, int min, int max) {
		// TODO Auto-generated method stub
		return gradeMapper.selectAvgGrade(groupId,min,max);
	}
	@Override
	public List<Grade> getGradesByGroupId(Integer groupId) {
		// TODO Auto-generated method stub
		return gradeMapper.selectGradesByGroupId(groupId);
	}
	@Override
	public List<Map<String, String>> selectUserExcel() {
		// TODO Auto-generated method stub
		List<User> list = groupMapper.selectUserWithAvg();
        List<Map<String, String>> mapList=new ArrayList<Map<String,String>>();
        for (User user : list) {
            Map<String, String> map=new HashMap<String, String>();
           map.put("学号", user.getUserNumber());
           map.put("姓名", user.getUserName().trim());
           map.put("分组",user.getGroup().getGroupNumber());
           map.put("评分", user.getGroup().getAvg());
           mapList.add(map);   
       }
       return mapList;
	}
	@Override
	public void deleteGradeList() {
		// TODO Auto-generated method stub
		gradeMapper.delateGradeList();
	}

	
	
}
