package com.se.springbootcruddemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.springbootcruddemo.entity.ChuyenBay;
import com.se.springbootcruddemo.respository.ChuyenBayRespository;
import com.se.springbootcruddemo.service.ChuyenBayService;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
	@Autowired 
	private ChuyenBayRespository chuyenBayRespository;
	
	@Override
	public List<ChuyenBay> findByGaDen(String gaDen) {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findByGaDen(gaDen);
	}

	@Override
	public List<ChuyenBay> findByDoDaiDBNhoHon10000VaLoHon8000() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findByDoDaiDBNhoHon10000VaLoHon8000();
	}

	@Override
	public List<ChuyenBay> findBySGtoBMT() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findBySGtoBMT();
	}

	@Override
	public int sumCBFromSG() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.sumCBFromSG();
	}

	@Override
	public List<ChuyenBay> findCBByMBAirbusA320() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findCBByMBAirbusA320();
	}

	@Override
	public List<ChuyenBay> findDBFromAtoBAndToA() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findDBFromAtoBAndToA();
	}

	@Override
	public List<Object[]> countChuyenBayKhoiHanh() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.countChuyenBayKhoiHanh();
	}

	@Override
	public List<Object[]> tongChiPhiPhaiTra() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.tongChiPhiPhaiTra();
	}

	@Override
	public List<ChuyenBay> findCBKHTruoc12h() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findCBKHTruoc12h();
	}

	@Override
	public List<Object[]> countDiaDiemKhoiHanhTruoc12h() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.countDiaDiemKhoiHanhTruoc12h();
	}

	@Override
	public List<ChuyenBay> findCBDuocLaiBoiBoeing() {
		// TODO Auto-generated method stub
		return chuyenBayRespository.findCBDuocLaiBoiBoeing();
	}



	
}
