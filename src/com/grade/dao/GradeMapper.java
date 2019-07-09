package com.grade.dao;

import com.grade.po.Grade;
import com.grade.po.GradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
    long countByExample(GradeExample example);

    int deleteByExample(GradeExample example);

    int deleteByPrimaryKey(Integer gradeId);

    int insert(Grade record);

    int insertSelective(Grade record);

    List<Grade> selectByExample(GradeExample example);

    Grade selectByPrimaryKey(Integer gradeId);

    int updateByExampleSelective(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByExample(@Param("record") Grade record, @Param("example") GradeExample example);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);

	void updateGrade(@Param("groupId")Integer groupId, 
			@Param("userId")Integer userId, 
			@Param("grade")Float grade);

	void insertGrade(@Param("groupId")Integer groupId, 
			@Param("userId")Integer userId, 
			@Param("grade")Float grade);

	Integer selectGradeId(@Param("groupId")Integer groupId, @Param("userId")Integer userId);

	Integer selectSumUser(Integer groupId);

	List<Integer> selectAvgGrade(@Param("groupId")Integer groupId,
			@Param("min")int min, @Param("max")int max);

	List<Grade> selectGradesByGroupId(Integer groupId);

	void delateGradeList();
}