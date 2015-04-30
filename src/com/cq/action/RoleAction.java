package com.cq.action;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.cq.service.UserService;
import com.cq.util.WarrantException;
import com.cq.util.tools;

public class RoleAction {
	static Logger log = Logger.getLogger(RoleAction.class);
	private String errorMsg;
	
	@Resource UserService userService;
	
	private String groupName;

	/**
	 * 添加部门
	 * @throws Exception 
	 * */
	public String addGroup() throws Exception {
		if (groupName == null || groupName.trim().equals("")) {
			errorMsg = "添加用户组部门时组名非法" + groupName;
			log.error(errorMsg);
			throw new WarrantException(errorMsg);
		}
		
		try {
			userService.addGroup(groupName);
		} catch (Exception e) {
			errorMsg = "添加用户组部门信息时失败";
			tools.throwException(e, log, errorMsg);
		}
		return "success";
	}
	/**
	 * 删除组
	 * @throws Exception 
	 * */
	public String deleteGroup() throws Exception {
		String gName = URLDecoder.decode(groupName, "UTF-8");
		String s = userService.deleteGroup(gName);
		if (s.equals("success")) {
			errorMsg = "删除成功";
		} else {
			errorMsg = "删除失败";
		}
		return errorMsg;
	}
	/**
	 * 查询所有组
	 * @throws Exception 
	 * */
	public void getGroupList() throws Exception {
		try {
			List<String> groupList = userService.groupNameList();
			
			if((groupList == null) || (groupList.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				log.warn("获取用户组信息失败" + groupList);
				return;
			}
			tools.outputInfo(JSONArray.fromObject(groupList));
		} catch (Exception e) {
			errorMsg = "输出用户组信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	/**
	 * 根据user查询所有组
	 * @throws Exception 
	 * */
	public void getGroupListUser() throws Exception {
		try {
			List<String> groupList = userService.groupList(tools.getLoginUser());
			
			if((groupList == null) || (groupList.size() <= 0)) {
				tools.outputInfo(JSONObject.fromObject(null));
				log.warn("获取用户组信息失败" + groupList);
				return;
			}
			tools.outputInfo(JSONArray.fromObject(groupList));
		} catch (Exception e) {
			errorMsg = "输出用户组信息时系统出现异常";
			tools.throwException(e, log, errorMsg);
		}
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
