package com.free4lab.freemonitor.model.dao;


import java.sql.Timestamp;
import java.util.logging.Level;
import com.free4lab.utils.sql.*;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;


/**
 * The persistent class for the student database table.
 * 
 */

public class MeetingRoomInfoDAO  extends AbstractDAO<MeetingRoomInfo> {
	private static final long serialVersionUID = 1L;

	@Override
	public Class getEntityClass() {
		// TODO Auto-generated method stub
		return MeetingRoomInfo.class;
	}
	
	public String getClassName() {
		return getEntityClass().getName();
	}
	
	@Override
	public IEntityManagerHelper getEntityManagerHelper() {
		// TODO Auto-generated method stub
		return new NoCacheEntityManagerHelper();
	}
	
	public static final String PU_NAME = "MEETINGROOMPU";
	
	@Override
	public String getPUName() {
		// TODO Auto-generated method stub
		return PU_NAME;
	}
	
//	    在数据库中插入一个会议室
	public MeetingRoomInfo create(String name,String location,Integer capacity,String open_time,String close_time,int projector,int available){
		log("finding " + getClassName() + " instance: create a MeetingRoom",
    			Level.INFO, null);
		MeetingRoomInfo meetingRoomInfo = new MeetingRoomInfo();
		meetingRoomInfo.setName(name);
		meetingRoomInfo.setLocation(location);
		meetingRoomInfo.setCapacity(capacity);		
		meetingRoomInfo.setOpen_time(open_time);		
		meetingRoomInfo.setClose_time(close_time);
		meetingRoomInfo.setProjector(projector);
		meetingRoomInfo.setAvailable(available);
		save(meetingRoomInfo);
		return meetingRoomInfo; 
	}
		

}