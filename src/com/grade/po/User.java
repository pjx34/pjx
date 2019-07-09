package com.grade.po;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
    private Integer userId;

    @NotEmpty(message="学号不能为空")  
    private String userNumber;

    @NotEmpty(message="姓名不能为空") 
    private String userName;

    private String groupId;
    
    private Group group;

    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }






	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNumber=" + userNumber + ", userName=" + userName + ", groupId="
				+ groupId + ", group=" + group + "]";
	}
	
}