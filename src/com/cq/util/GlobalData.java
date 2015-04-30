package com.cq.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cq.bean.CompanyProperty;
import com.cq.bean.CompanyType;
import com.cq.bean.EventType;

public class GlobalData {
	public static List<CompanyType> companyTypes = new ArrayList<CompanyType>();
	public static List<CompanyProperty> companyPropertys = new ArrayList<CompanyProperty>();
	public static List<EventType> eventTypes = new ArrayList<EventType>();
	public static Map<String, String> taskNames = new HashMap<String, String>();
	
	public static Map<String, String> antiWarrantTypes = new HashMap<String, String>();
	public static Map<String, String> warrantModes = new HashMap<String, String>();
	public static Map<String, String> serviceTypes = new HashMap<String, String>();
	public static Map<String, String> loanModes = new HashMap<String, String>();
	public static Map<String, String> changeTypes = new HashMap<String, String>();
	public static Map<String, String> investModes = new HashMap<String, String>();
	public static Map<String, String> capitalModes = new HashMap<String, String>();
	public static Map<String, String> gender = new HashMap<String, String>();
	public static Map<String, String> relationships = new HashMap<String, String>();
	public static Map<String, String> dutys = new HashMap<String, String>();
	public static Map<String, String> maritalStatus = new HashMap<String, String>();
	public static Map<String, String> education = new HashMap<String, String>();
	
	public static int passwordReminderDays = 7;
	public static int passwordExpireDays = 90;
	public static int taskReminderDays = 7;
	public static int taskExpireDays = 30;
	
	public static boolean reviewChargeToRecieve = true;
	public static int maxLogResults = 15;
	
	public static int advancedReminderDays = 7;
	public static int projectTrackPeriod = 30;
	
	public static String reviewGroupName = "评审委员会";
	public static List<String> antiWarrantGroups = new ArrayList<String>();
}
