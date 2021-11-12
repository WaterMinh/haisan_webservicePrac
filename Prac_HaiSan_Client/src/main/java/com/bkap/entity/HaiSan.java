package com.bkap.entity;

public class HaiSan {

	private int id;

	private String ten;

	private String ncc;

	private String dvt;

	private int soluong;

	private float giatien;

	private boolean tinhtrang;

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

	