package com.se.springbootcruddemo.service;

import java.util.List;

import com.se.springbootcruddemo.entity.MayBay;

public interface MayBayService {
	public List<String> findByTamBayLonHon10000();
	public int sumMayBayBoeing();
	public List<String> findMaByNameNguyen();
	public List<String> findLoaiByCBVN280();
	public List<Object[]> findMaLoaiVaTongPhiCong();

}
