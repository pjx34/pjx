package com.grade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grade.dao.GroupMapper;
import com.grade.po.Group;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	GroupMapper groupMapper;

	@Override
	public List<Group> getAllGroupRandom(Integer userId) {
		// TODO Auto-generated method stub
		return groupMapper.selectAllGroupRandom(userId);
	}

	@Override
	public List<Group> getUsersByGroupId(Integer groupId) {
		// TODO Auto-generated method stub
		return groupMapper.selectUsersByGroupId(groupId);
	}

	@Override
	public List<Group> getAllGroup() {
		// TODO Auto-generated method stub
		return groupMapper.selectAllGroup();
	}

	@Override
	public List<Group> getGroupWithGrade(Integer userId) {
		// TODO Auto-generated method stub
		return groupMapper.selectGroupWithGrade(userId);
	}

	@Override
	public void saveAvg(Integer groupId, Float avg,Integer groupScoreNum) {
		// TODO Auto-generated method stub
		groupMapper.updateAvg(groupId,avg,groupScoreNum);
	}

	@Override
	public List<Group> getGroupWithAvg() {
		// TODO Auto-generated method stub
		return groupMapper.selectGroupWithAvg();
	}

	@Override
	public List<Group> getGroupOrder(Integer userId) {
		// TODO Auto-generated method stub
		return groupMapper.selectGroupOrder(userId);
	}

	@Override
	public Integer getGroupNumber(Integer groupId) {
		// TODO Auto-generated method stub
		return groupMapper.selectGroupNumber(groupId);
	}

	@Override
	public void saveSort(List<Integer> groupIdList) {
		// TODO Auto-generated method stub
		groupMapper.insertSort(groupIdList);
	}

	@Override
	public List<Integer> getGroupIdList() {
		// TODO Auto-generated method stub
		return groupMapper.selectGroupIdList();
	}

	@Override
	public void dropSort() {
		// TODO Auto-generated method stub
		groupMapper.deleteSort();
	}

	@Override
	public void saveGroupList(List<Group> groupList) {
		// TODO Auto-generated method stub
		groupMapper.addGroupList(groupList);
	}

	@Override
	public void deleteGroupList() {
		// TODO Auto-generated method stub
		groupMapper.deleteGroupList();
	}

	@Override
	public int getGroupNum() {
		// TODO Auto-generated method stub
		return groupMapper.getGroupNum();
	}


}
