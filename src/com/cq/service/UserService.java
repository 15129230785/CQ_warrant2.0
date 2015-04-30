package com.cq.service;

import java.util.List;

import org.jbpm.api.identity.User;

import com.cq.table.CQMemberShip;
import com.cq.table.CQUser;

public interface UserService {
	public String addUser(String name, String pass, String email) throws Exception;
	public String updatePassword(String passWord, String name) throws Exception;
	public List<CQUser> getUserByWildId(String id) throws Exception;
	public List<User> userList() throws Exception;
	public String updateEmail(String name, String email) throws Exception;
	public String deleteUser(String s) throws Exception;
	public CQUser getUserByName(String name);
	
	public String addGroup(String name) throws Exception;
	public List<String> groupNameList() throws Exception;
	public String deleteGroup(String user) throws Exception;
	public List<String> groupList(String id) throws Exception;
	
	public String addMemberShip(String userId, String groupId) throws Exception;
	public List<CQMemberShip> getMemberShip(String userid, String groupid);
	public String deleteMemberShip(long kid) throws Exception;
	
	public List<String> findReviewUser();
}
