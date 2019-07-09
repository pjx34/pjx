package com.grade.po;

import java.util.List;

public class Group {
    private String groupId;

    private String groupNumber;
    
    private String projectName;
    
    private List<User> userList;
    
    private List<Grade> gradeList;
    
    private String avg;
    
    private Grade grade;
    
    private Integer groupScoreNum;
    
	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}


	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}


    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getGroupScoreNum() {
		return groupScoreNum;
	}

	public void setGroupScoreNum(Integer groupScoreNum) {
		this.groupScoreNum = groupScoreNum;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}