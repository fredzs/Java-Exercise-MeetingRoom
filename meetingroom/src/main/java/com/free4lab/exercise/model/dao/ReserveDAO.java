package com.free4lab.freemonitor.model.dao;

import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.IEntityManagerHelper;
import com.free4lab.utils.sql.entitymanager.NoCacheEntityManagerHelper;

public class ReserveDAO extends AbstractDAO<Reserve>{
	public String getClassName() {
	    return getEntityClass().getName();
	}
	
	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		return Reserve.class;
	}

	public static final String PU_NAME = "MEETINGROOMPU";
	public String getPUName() {
		return PU_NAME;
	}

	public IEntityManagerHelper getEntityManagerHelper() {
		return new NoCacheEntityManagerHelper();
	}
	/*add other methods behind*/
	public Reserve createReserve(int user_id, String user_name, String user_phone, String teacher_name, String teacher_phone, 
			int meeting_room ,String date, int start_time, int end_time, String topic,String participant)
	{
    	Date date_toget = new Date();
    	Timestamp create_time = new Timestamp(date_toget.getTime());
    	Reserve reserve = new Reserve(user_id, user_name, user_phone, teacher_name, teacher_phone, meeting_room, date, 
    			start_time ,end_time, topic,participant, create_time);
    	save(reserve);
    	return reserve;
    }

	public void editReserve(int id, int user_id, String user_name, String user_phone, String teacher_name, String teacher_phone, 
			int meeting_room ,String date, int start_time, int end_time, String topic,String participant){
		Date date_toget = new Date();
    	Timestamp create_time = new Timestamp(date_toget.getTime());
		Reserve reserve = new Reserve(id,user_id, user_name, user_phone, teacher_name, teacher_phone, meeting_room, date, 
    			start_time ,end_time, topic,participant, create_time);
		update(reserve);	
	}
	
	@SuppressWarnings("unchecked")
	public List<Reserve> findOld(int id) {
		String queryString = "select model from " + getClassName()
				+ " model where model.id=:id";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("id", id);
		List<Reserve> i = query.getResultList();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public int check(Integer meeting_room,String date,Integer start_time,Integer end_time){
		String queryString_start_time = "select model from " + getClassName()
				+ " model where model.meeting_room=:meeting_room and model.date=:date and model.end_time=:end_time";
		Query query_start_time = getEntityManager().createQuery(queryString_start_time);
		//System.out.println("check里面11！！会议室："+meeting_room+"日期："+date+"开始："+start_time+"结束："+end_time);
		query_start_time.setParameter("meeting_room", meeting_room);
		query_start_time.setParameter("date", date);
		query_start_time.setParameter("end_time", end_time);
		List<Reserve> i = query_start_time.getResultList();

		String queryString_end_time = "select model from " + getClassName()
				+ " model where model.meeting_room=:meeting_room and model.date=:date and model.start_time=:start_time";
		Query query_end_time = getEntityManager().createQuery(queryString_end_time);
		query_end_time.setParameter("meeting_room", meeting_room);
		query_end_time.setParameter("date", date);
		query_end_time.setParameter("start_time", start_time);
		List<Reserve> j = query_end_time.getResultList();

		if(i.isEmpty()&&j.isEmpty())
			return 0;
		else
			return 1;
	}
	
    public int deleteReserve(Integer id){

        EntityManager em = getEntityManager();
		if (em.getTransaction().isActive()){
			em.getTransaction().rollback();
		}
		em.getTransaction().begin();
		try {
			
			final String queryString = "delete from " + getClassName() + " model where model.id = :id ";
			Query query = em.createQuery(queryString);
			query.setParameter("id",id);
		    int ans = query.executeUpdate();
			em.getTransaction().commit();
			return ans;
		} catch (RuntimeException re) {
			em.getTransaction().rollback();
			throw re;
		}
	}
    
	
	@SuppressWarnings("unchecked")
	public List<Reserve> findRes(int meeting_room,String date) {
		String queryString = "select model from " + getClassName()+ " model"
				+" where model.meeting_room=:meeting_room and model.date=:date order by model.start_time";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("meeting_room", meeting_room);
		query.setParameter("date", date);
		List<Reserve> i = query.getResultList();
		return i;
	}
	
	public List<Reserve> findAll(){
    	return super.findAll();
    }
}