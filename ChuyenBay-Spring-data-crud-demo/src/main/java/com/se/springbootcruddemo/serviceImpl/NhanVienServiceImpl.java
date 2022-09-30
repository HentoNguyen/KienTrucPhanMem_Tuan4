package com.se.springbootcruddemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.springbootcruddemo.entity.NhanVien;
import com.se.springbootcruddemo.respository.NhanVienRespository;
import com.se.springbootcruddemo.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {
	
	@Autowired
	private NhanVienRespository nhanVienRespository;

	@Override
	public List<NhanVien> findByLuongNhoHon10000() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findByLuongNhoHon10000();
	}

	@Override
	public int sumLuong() {
		// TODO Auto-generated method stub
		return nhanVienRespository.sumLuong();
	}

	@Override
	public List<NhanVien> findBymaMB747() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findBymaMB747();
	}

	@Override
	public List<String> findMaByNVLaiBoeingVaAirbus() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findMaByNVLaiBoeingVaAirbus();
	}

	@Override
	public List<String> findTenByNVLaiBoeing() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findTenByNVLaiBoeing();
	}

	@Override
	public List<String> findMaNVChiLaiDuoc3LoaiMayBay() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findMaNVChiLaiDuoc3LoaiMayBay();
	}

	@Override
	public List<Object[]> findMaNVLaiDuocHon3LoaiMayBayVaMaxTamBay() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findMaNVLaiDuocHon3LoaiMayBayVaMaxTamBay();
	}

	@Override
	public List<Object[]> findMaNVAndCountLoaiMayBayCoTheLai() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findMaNVAndCountLoaiMayBayCoTheLai();
	}

	@Override
	public List<NhanVien> findNVKhongPhaiPhiCong() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findNVKhongPhaiPhiCong();
	}

	@Override
	public List<String> findNVMaxLuong() {
		// TODO Auto-generated method stub
		return nhanVienRespository.findNVMaxLuong();
	}

	@Override
	public int tongSoLuongPhaiTra() {
		// TODO Auto-generated method stub
		return nhanVienRespository.tongSoLuongPhaiTra();
	}

}
