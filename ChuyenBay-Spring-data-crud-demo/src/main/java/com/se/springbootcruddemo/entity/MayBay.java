package com.se.springbootcruddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "maybay")
public class MayBay implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "mayBay")
	private List<ChungNhan> chungNhans;
	
	@Id
	@Column(name = "MaMB")
	private int maMB;
	@Column(name = "Loai")
	private String loai;
	@Column(name = "Tam_Bay")
	private int tamBay;
	


	@Override
	public String toString() {
		return "MayBay [MaMB=" + maMB + ", Loai=" + loai + ", TamBay=" + tamBay + "]";
	}


	
}
