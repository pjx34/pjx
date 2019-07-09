package com.grade.service;

import java.util.List;
import java.util.Map;

import com.grade.po.Grade;
import com.grade.po.Group;

public interface GradeService {

	void saveGrade(Integer groupId, Integer userId, Float grade);

	Integer getGradeId(Integer groupId, Integer userId);

	void updateGrade(Integer groupId, Integer userId, Float grade);

	Integer getSumUser(Integer groupId);

	List<Integer> getAvgGrade(Integer groupId, int min, int max);

	List<Grade> getGradesByGroupId(Integer groupId);


	List<Map<String, String>> selectUserExcel();

	void deleteGradeList();

}
