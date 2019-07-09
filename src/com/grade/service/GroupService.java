package com.grade.service;

import java.util.List;

import com.grade.po.Group;

public interface GroupService {

	public List<Group> getAllGroupRandom(Integer userId);

	public List<Group> getUsersByGroupId(Integer groupId);
	
	public List<Group> getAllGroup();

	public List<Group> getGroupWithGrade(Integer userId);

	public void saveAvg(Integer groupId, Float avg,Integer count);

	public List<Group> getGroupWithAvg();

	public List<Group> getGroupOrder(Integer userId);

	public Integer getGroupNumber(Integer groupId);

	public void saveSort(List<Integer> groupIdList);

	public List<Integer> getGroupIdList();

	public void dropSort();

	public void saveGroupList(List<Group> groupList);

	public void deleteGroupList();

	public int getGroupNum();

}
