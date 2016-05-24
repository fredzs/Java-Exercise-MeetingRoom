package com.free4lab.freemonitor.action.student;

import java.util.ArrayList;
import java.util.List;

import com.free4lab.freemonitor.manager.MeetingRoomInfoManager;

import com.free4lab.freemonitor.model.dao.MeetingRoomInfo;

import com.opensymphony.xwork2.ActionSupport;

public class GetAllMeetingRoomInfoAction extends ActionSupport{
	
	/**
	 * 获取MeetingRoom全部会议室信息
	 */
	
	private static final long serialVersionUID = 1597845248940902378L;
	private List<MeetingRoomInfo> meetingRoomInfoList = new ArrayList<MeetingRoomInfo>();
	public String execute(){
		setMeetingRoomInfoList(MeetingRoomInfoManager.getAllMeetingRoomInfo());
		new MeetingRoomInfoManager().insert();
		return SUCCESS;
	}
	
	public void setMeetingRoomInfoList(List<MeetingRoomInfo> meetingRoomInfoList) {
		this.meetingRoomInfoList = meetingRoomInfoList;
	}
	
	public List<MeetingRoomInfo> getMeetingRoomInfoList() {
		return meetingRoomInfoList;
	}
}
