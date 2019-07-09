package com.grade.dao;

import com.grade.po.Group;
import com.grade.po.GroupExample;
import com.grade.po.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(Integer groupId);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

	List<Group> selectAllGroupRandom(Integer userId);
	
	List<Group> selectUsersByGroupId(Integer groupId);
	
	List<Group> selectAllGroup();

	List<Group> selectGroupWithGrade(Integer userId);

	void updateAvg(@Param("groupId")Integer groupId,@Param("avg") Float avg,@Param("groupScoreNum") Integer groupScoreNum);

	List<Group> selectGroupWithAvg();

	List<Group> selectGroupOrder(Integer userId);

	Integer selectGroupNumber(Integer groupId);

	List<User> selectUserWithAvg();

	void insertSort(List<Integer> groupIdList);

	List<Integer> selectGroupIdList();

	void deleteSort();

	void addGroupList(List<Group> groupList);

	void deleteGroupList();

	int getGroupNum();

}