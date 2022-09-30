package com.se.springbootcruddemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.springbootcruddemo.entity.ChungNhan;
import com.se.springbootcruddemo.respository.ChungNhanRespository;
import com.se.springbootcruddemo.service.ChungNhanService;

@Service
public class ChungNhanServiceImpl implements ChungNhanService {
	
	@Autowired
	ChungNhanRespository chungNhanRespository;

	@Override
	public List<String> findByBoeing() {
		// TODO Auto-generated method stub
		return chungNhanRespository.findByBoeing();
	}

}
