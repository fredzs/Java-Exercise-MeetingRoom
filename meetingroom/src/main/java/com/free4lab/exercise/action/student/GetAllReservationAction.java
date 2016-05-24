package com.free4lab.freemonitor.action.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import com.free4lab.freemonitor.manager.ReserveManager;
import com.free4lab.freemonitor.model.dao.Reserve;
import com.opensymphony.xwork2.ActionSupport;

public class GetAllReservationAction extends ActionSupport{
	
	/**
	 * 获取reserve表中全部预订信息
	 */
	private static final long serialVersionUID = 1597845248940902378L;
	private int MeetingRoom;
	
	private Calendar ca = Calendar.getInstance();
	private int year = ca.get(Calendar.YEAR);
	private int month = ca.get(Calendar.MONTH)+1;
	private int day = ca.get(Calendar.DATE);
	private int minute = ca.get(Calendar.MINUTE) ;
	private int hour = ca.get(Calendar.HOUR);
	private int DayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
	private int StartOfWeek;
	private int EndOfWeek;
	private int DaysOfMonth;
	private int StartMonth;
	private int EndMonth;
	private int StartYear;
	private int EndYear;
	
	private List<Reserve> Monday = new ArrayList<Reserve>();
	private List<Reserve> Tuesday = new ArrayList<Reserve>();
	private List<Reserve> Wednesday = new ArrayList<Reserve>();
	private List<Reserve> Thursday = new ArrayList<Reserve>();
	private List<Reserve> Friday = new ArrayList<Reserve>();
	private List<Reserve> Saturday = new ArrayList<Reserve>();
	private List<Reserve> Sunday = new ArrayList<Reserve>();
	private List<Reserve> Today = new ArrayList<Reserve>();

	public String execute(){
		
		getAllCalendarValue();
		setToday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+month+"-"+day));
		setMonday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+StartOfWeek));
		setTuesday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+(StartOfWeek+1)));
		setWednesday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+(StartOfWeek+2)));
		setThursday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+(StartOfWeek+3)));
		setFriday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+(StartOfWeek+4)));
		setSaturday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+(StartOfWeek+5)));
		setSunday(ReserveManager.getReserve(MeetingRoom,StartYear+"-"+StartMonth+"-"+(StartOfWeek+6)));
		return SUCCESS;
	}	
	
	public void getAllCalendarValue()
	{
		DaysOfMonth = DaysOfMonth(year+"/"+month);
		System.out.println("weekViewAction");
		if(DayOfWeek!=1)
			DayOfWeek = DayOfWeek-1;
		else
			DayOfWeek = 7;
		if((day >= DayOfWeek)&&(DaysOfMonth-day>=7-DayOfWeek)) 
		{
			System.out.println("周日时候咋不行呢");
			System.out.println(day);
			System.out.println(DayOfWeek);
			setStartOfWeek(day+1-DayOfWeek);
			setEndOfWeek(day+7-DayOfWeek);	
			System.out.println(this.getStartOfWeek());
			this.setStartMonth(month);
			this.setEndMonth(month);
			this.setStartYear(year);
			this.setEndYear(year);
		}
		if(day < DayOfWeek) //月初不符合
		{
			setEndOfWeek(day+7-DayOfWeek);	
			setStartOfWeek(day+DaysOfMonth-DayOfWeek);
			if(month == 1)
			{
				setStartMonth(12);
				setEndMonth(month);
				this.setStartYear(year);
				this.setEndYear(year);
			}
			else
			{
				this.setStartMonth(month-1) ;
				this.setEndMonth(month);
				this.setStartYear(year);
				this.setEndYear(year);
			}
		}
		if(DaysOfMonth-day < 7-DayOfWeek) //月末不符合
		{
			System.out.println("月末不符合");
			setStartOfWeek(day+1-DayOfWeek);
			setEndOfWeek(7-DayOfWeek-DaysOfMonth+day);
			if(month == 12)
			{
				setEndMonth(1);
				this.setStartMonth(month);
				this.setStartYear(year);
				this.setEndYear(year);
			}
			else
			{
				System.out.println("不是12月");
					this.setEndMonth(month+1);
					System.out.println(EndMonth);
					this.setStartMonth(month);
					this.setStartYear(year);
					this.setEndYear(year);
			}
		}
	}
	
	public int DaysOfMonth(String str)
	{
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM"); //如果写成年月日的形式的话，要写小d，如："yyyy/MM/dd"
		try {
			rightNow.setTime(simpleDate.parse(str));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		} //要计算你想要的月份，改变这里即可
		int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("days : "+ days);
		return days;
		
	}

	public int getStartMonth() {
		return StartMonth;
	}

	public void setStartMonth(int startMonth) {
		StartMonth = startMonth;
	}

	public int getEndMonth() {
		return EndMonth;
	}

	public void setEndMonth(int endMonth) {
		this.EndMonth = endMonth;
	}

	public int getStartYear() {
		return StartYear;
	}

	public void setStartYear(int startYear) {
		StartYear = startYear;
	}

	public int getEndYear() {
		return EndYear;
	}

	public void setEndYear(int endYear) {
		EndYear = endYear;
	}

	public int getDaysOfMonth() {
		return DaysOfMonth;
	}

	public void setDaysOfMonth(int daysOfMonth) {
		DaysOfMonth = daysOfMonth;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getDayOfWeek() {
		return DayOfWeek;
	}

	public void DayOfWeek(int DayOfWeek) {
		this.DayOfWeek = DayOfWeek;
	}

	public Calendar getCa() {
		return ca;
	}

	public void setCa(Calendar ca) {
		this.ca = ca;
	}
	public int getStartOfWeek() {
		return StartOfWeek;
	}

	public void setStartOfWeek(int startOfWeek) {
		StartOfWeek = startOfWeek;
	}

	public int getEndOfWeek() {
		return EndOfWeek;
	}

	public void setEndOfWeek(int endOfWeek) {
		EndOfWeek = endOfWeek;
	}

	public int getMeetingRoom() {
		return MeetingRoom;
	}

	public void setMeetingRoom(int meetingRoom) {
		MeetingRoom = meetingRoom;
	}


	public List<Reserve> getToday() {
		return Today;
	}


	public void setToday(List<Reserve> today) {
		Today = today;
	}

	public List<Reserve> getMonday() {
		return Monday;
	}
	public void setMonday(List<Reserve> monday) {
		Monday = monday;
	}
	public List<Reserve> getTuesday() {
		return Tuesday;
	}
	public void setTuesday(List<Reserve> tuesday) {
		Tuesday = tuesday;
	}
	public List<Reserve> getWednesday() {
		return Wednesday;
	}
	public void setWednesday(List<Reserve> wednesday) {
		Wednesday = wednesday;
	}
	public List<Reserve> getThursday() {
		return Thursday;
	}
	public void setThursday(List<Reserve> thursday) {
		Thursday = thursday;
	}
	public List<Reserve> getFriday() {
		return Friday;
	}
	public void setFriday(List<Reserve> friday) {
		Friday = friday;
	}
	public List<Reserve> getSaturday() {
		return Saturday;
	}
	public void setSaturday(List<Reserve> saturday) {
		Saturday = saturday;
	}
	public List<Reserve> getSunday() {
		return Sunday;
	}
	public void setSunday(List<Reserve> sunday) {
		Sunday = sunday;
	}
}
