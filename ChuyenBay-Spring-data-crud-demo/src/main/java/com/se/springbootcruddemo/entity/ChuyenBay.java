package com.se.springbootcruddemo.entity;
import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
@Table(name = "chuyenbay")
public class ChuyenBay implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaCB")
	private String maCB;
	
	@Column(name = "Ga_Di")
	private String gaDi;
	
	@Column(name = "Ga_Den")
	private String gaDen;
	
	@Column(name = "Do_Dai")
	private int doDai;
	
	@Column(name = "Gio_Di")
	private Date gioDi;
	
	@Column(name = "Gio_Den")
	private Date gioDen;
	
	@Column(name = "Chi_Phi")
	private int chiPhi;

	@Override
	public String toString() {
		return "ChuyenBay [MaCB=" + maCB + ", GaDi=" + gaDi + ", GaDen=" + gaDen + ", DoDai=" + doDai + ", GioDi="
				+ gioDi + ", GioDen=" + gioDen + ", ChiPhi=" + chiPhi + "]";
	}
	
	
	
}
