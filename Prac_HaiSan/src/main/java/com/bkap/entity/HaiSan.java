package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblHaiSan")
public class HaiSan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "ncc")
	private String ncc;
	@Column(name = "dvt")
	private String dvt;
	@Column(name = "soluong")
	private int soluong;
	@Column(name = "giatien")
	private float giatien;
	@Column(name = "tinhtrang")
	private boolean tinhtrang;
	@Column(name = "anh")
	private String anh;

	public HaiSan() {
		super();
	}

	public HaiSan(int id, String ten, String ncc, String dvt, int soluong, float giatien, boolean tinhtrang,
			String anh) {
		super();
		this.id = id;
		this.ten = ten;
		this.ncc = ncc;
		this.dvt = dvt;
		this.soluong = soluong;
		this.giatien = giatien;
		this.tinhtrang = tinhtrang;
		this.anh = anh;
	}

	public HaiSan(String ten, String ncc, String dvt, int soluong, float giatien, boolean tinhtrang, String anh) {
		super();
		this.ten = ten;
		this.ncc = ncc;
		this.dvt = dvt;
		this.soluong = soluong;
		this.giatien = giatien;
		this.tinhtrang = tinhtrang;
		this.anh = anh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) {
		this.ncc = ncc;
	}

	public String getDvt() {
		return dvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public float getGiatien() {
		return giatien;
	}

	public void setGiatien(float giatien) {
		this.giatien = giatien;
	}

	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}
	

	
}
