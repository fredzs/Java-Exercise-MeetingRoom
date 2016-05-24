package com.free4lab.freemonitor.action.student;

import java.util.List;

import com.free4lab.freemonitor.model.dao.Reserve;
import com.free4lab.freemonitor.model.dao.ReserveDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GetOldReservationAction extends ActionSupport{
	
	/**
	 * 获取reserve表中全部预订信息
	 */
	private static final long serialVersionUID = 1597845248940902378L;
	private int id;
	private int meeting_room;
	private List<Reserve> res1;
	private Reserve res;
	public String execute(){
		setRes1(new ReserveDAO().findOld(id));
		setRes(res1.get(0));
		//System.out.println("哈哈哈"+id+res.getId());
		return SUCCESS;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Reserve> getRes1() {
		return res1;
	}

	public void setRes1(List<Reserve> res) {
		this.res1 = res;
	}

	public Reserve getRes() {
		return res;
	}

	public void setRes(Reserve res) {
		this.res = res;
	}

	public int getMeeting_room() {
		return meeting_room;
	}

	public void setMeeting_room(int meeting_room) {
		this.meeting_room = meeting_room;
	}
}
