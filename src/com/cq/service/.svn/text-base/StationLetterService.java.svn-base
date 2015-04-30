package com.cq.service;

import java.util.Date;
import java.util.List;

import com.cq.table.TblStationLetter;

public interface StationLetterService {
	public String addLetter(String sendID,String recID,String caption,String message,Date sendDate,int flag) throws Exception;
	public void delete(int kid) throws Exception;
	public void deleteRcvLetter(int kid) throws Exception;
	public void deleteSndLetter(int kid) throws Exception;
	public void updateReadStatus(int kid) throws Exception;
	public List<TblStationLetter> listLetter() throws Exception;
	public List<TblStationLetter> listLetterReceiver() throws Exception;
	public List<TblStationLetter> listLetterSend() throws Exception;
	public List<TblStationLetter> listLetterCallback() throws Exception;
	public int getStationLetterNumber(String user) throws Exception;
}
