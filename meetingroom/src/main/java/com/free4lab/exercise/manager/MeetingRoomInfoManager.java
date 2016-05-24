package com.free4lab.freemonitor.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.freemonitor.model.dao.MeetingRoomInfo;
import com.free4lab.freemonitor.model.dao.MeetingRoomInfoDAO;


public class MeetingRoomInfoManager {
	
	private static final Logger logger = Logger.getLogger(MeetingRoomInfoManager.class);
	
	public static List<MeetingRoomInfo> getAllMeetingRoomInfo(){
		List<MeetingRoomInfo> meetingRoomInfo = new ArrayList<MeetingRoomInfo>();
		logger.info("findding all students!");
		meetingRoomInfo = new MeetingRoomInfoDAO().findAll();
		return meetingRoomInfo;
	}
	
	Date date = new Date();
	Timestamp currentTime = new Timestamp(date.getTime());
	
	public void insert()
	{
		//new MeetingRoomInfoDAO().create("wang", "519", 20, currentTime, currentTime,1, 0) ;
	}
}
