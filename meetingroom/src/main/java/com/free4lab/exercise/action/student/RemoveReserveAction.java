package com.free4lab.freemonitor.action.student;

import com.free4lab.freemonitor.account.BaseAction;
import com.free4lab.freemonitor.model.dao.ReserveDAO;

public class RemoveReserveAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private int id;

	public String execute() {
		new ReserveDAO().deleteReserve(id);
		
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
