package com.bkap.dao;

import java.util.List;

import org.hibernate.Session;

import com.bkap.entity.HaiSan;
import com.bkap.utils.HibernateUtils;

public class ImplHaiSanDAO implements HaiSanDAO{

	@Override
	public List<HaiSan> selectAll() {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		
		List<HaiSan> lst = ss.createQuery("from HaiSan").list();
		ss.getTransaction().commit();
		ss.close();
		return lst;
	}
	
	
	@Override
	public HaiSan selectById(int id) {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		
		HaiSan hs = ss.get(HaiSan.class, id);
		ss.getTransaction().commit();
		ss.close();
		return hs;
	}

	@Override
	public List<HaiSan> search(String search) {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		
		List<HaiSan> lst = ss.createQuery("from HaiSan where ten like:search OR ncc like:search").setParameter("search", "%" + search +"%").list();
		ss.getTransaction().commit();
		ss.close();
		return lst;
		
	}
	@Override
	public HaiSan loadDetail(int id) {
		Session ss = HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();

		HaiSan hs = ss.get(HaiSan.class, id);

		ss.close();
		return hs;
		
	}

	@Override
	public boolean insert(HaiSan hs) {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		try {
			ss.save(hs);
			ss.getTransaction().commit();
			ss.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("Reason:" + e.toString());
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(HaiSan hs) {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		try {
			ss.update(hs);
			ss.getTransaction().commit();
			ss.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("Reason:" + e.toString());
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		try {
			HaiSan hs = ss.get(HaiSan.class, id);
			ss.delete(hs);
			ss.getTransaction().commit();
			ss.close();
			return true;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			System.out.println("Reason:" + e.toString());
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public int getNumTotal() {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		
		List<HaiSan> lst = ss.createQuery("from HaiSan").list();
		ss.getTransaction().commit();
		ss.close();
		return lst.size();
	}


	@Override
	public List<HaiSan> selectByPag(int offset, int limit) {
		Session ss =HibernateUtils.iniSessionFactory().openSession();
		ss.beginTransaction();
		
		List<HaiSan> lst = ss.createQuery("from HaiSan").setFirstResult(offset).setMaxResults(limit).list();
		ss.getTransaction().commit();
		ss.close();
		return lst;
	}



	

	

}
