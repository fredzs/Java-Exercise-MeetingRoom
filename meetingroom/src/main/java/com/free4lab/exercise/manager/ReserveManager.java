package com.free4lab.freemonitor.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.free4lab.freemonitor.model.dao.Reserve;
import com.free4lab.freemonitor.model.dao.ReserveDAO;

public class ReserveManager {
	
	private static final Logger logger = Logger.getLogger(ReserveManager.class);
	public static List<Reserve> getAllReserve(){
		List<Reserve> reserve = new ArrayList<Reserve>();
		reserve= new ReserveDAO().findAll();
		logger.info("findding all reserves!");
		return reserve;
	}	
	
	public static List<Reserve> getReserve(int meeting_room,String date){
		List<Reserve> reserve = new ArrayList<Reserve>();
		reserve= new ReserveDAO().findRes(meeting_room,date);
		logger.info("根据会议室编号和预定日期，findding 特定的 reserves!");
		return reserve;
	}	
}
