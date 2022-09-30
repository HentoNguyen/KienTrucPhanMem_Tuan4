package com.se.springbootcruddemo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class ChungNhanPK implements Serializable{
	
	private String nhanVien;
	private int mayBay;
		
}
