package com.bkap.dao;

import java.util.List;

import com.bkap.entity.HaiSan;



public interface HaiSanDAO {
	public List<HaiSan> selectAll();

	public List<HaiSan> search(String search);
	public boolean insert (HaiSan hs);
	public boolean  update(HaiSan hs);
	public boolean  delete(int id);

	public HaiSan loadDetail(int id);

	HaiSan selectById(int id);
	
	public int getNumTotal() ;
	public List<HaiSan> selectByPag(int offset,int limit);
		
	

	
	
	
}
