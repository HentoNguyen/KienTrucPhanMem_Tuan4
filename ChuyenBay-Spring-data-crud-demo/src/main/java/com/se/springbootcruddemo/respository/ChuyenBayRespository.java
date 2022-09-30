package com.se.springbootcruddemo.respository;


import java.io.Console;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.springbootcruddemo.entity.ChuyenBay;

public interface ChuyenBayRespository extends JpaRepository<ChuyenBay, String>  {
	
//	1.Cho biết các chuyến bay đi Đà Lạt (DAD)
//	String gaDen="";
//	@Query(value = "select * from chuyenbay where GaDi='"+gaDen+"' ", nativeQuery = true)
	public List<ChuyenBay> findByGaDen(String gaDen);
	
//  4.Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
	@Query(value = "select * from chuyenbay where Do_Dai < 10000 and Do_Dai > 8000", nativeQuery = true)
	public List<ChuyenBay>findByDoDaiDBNhoHon10000VaLoHon8000();
	
	
//  5.Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@Query(value = "select * from chuyenbay where Ga_Di = 'SGN' and Ga_Den = 'BMV'", nativeQuery = true)
	public List<ChuyenBay> findBySGtoBMT();
	
//	6.Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@Query(value = "select count(*) from chuyenbay where Ga_Di = 'SGN'", nativeQuery = true)
	public int sumCBFromSG();
	
//	14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320
	@Query(value = "SELECT * from chuyenbay where Do_Dai < ( select Tam_Bay from [dbo].[maybay] where Loai =N'Airbus A320')", nativeQuery = true)
	public List<ChuyenBay> findCBByMBAirbusA320();
	
//	17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các
//	đường bay nào có thể đáp ứng yêu cầu này.
	@Query(value = "select * from [dbo].[chuyenbay] where [Ga_Di] in"+
			"(select [Ga_Den] from [dbo].[chuyenbay]) and [Ga_Den] in (select [Ga_Di] from [dbo].[chuyenbay])", nativeQuery = true)
	public List<ChuyenBay> findDBFromAtoBAndToA();
	
//	18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga 
//	đó.
	@Query(value = "select [Ga_Di], count(*) as SoChuyenBay from [dbo].[chuyenbay]\r\n"
			+ "group by Ga_Di", nativeQuery = true)
	public List<Object[]> countChuyenBayKhoiHanh();
	
//	19. Với mỗi ga có chuyến bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các 
//	chuyến bay khởi hành từ ga đó.
	@Query(value = "select [Ga_Di], sum(chi_Phi) as Tongchiphi from [dbo].[chuyenbay]\r\n"
			+ "group by Ga_Di", nativeQuery = true)
	public List<Object[]> tongChiPhiPhaiTra();
	
//	20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
	@Query(value = "select * from chuyenbay where [Gio_Di]<'12:00:00'", nativeQuery = true)
	public List<ChuyenBay> findCBKHTruoc12h();
	
//	21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
	@Query(value = "select [Ga_Di], count(*) as soluong from [dbo].[chuyenbay]where [Gio_Di]<'12:00:00'\r\n"
			+ "group by [Ga_Di]", nativeQuery = true)
	public List<Object[]> countDiaDiemKhoiHanhTruoc12h();
	
//	28. Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing
	@Query(value = "\r\n"
			+ "SELECT        MaCB, Ga_Di, Ga_Den, Do_Dai, Gio_Di, Gio_Den, Chi_Phi\r\n"
			+ "FROM            chuyenbay\r\n"
			+ "group by MaCB, Ga_Di, Ga_Den, Do_Dai, Gio_Di, Gio_Den, Chi_Phi\r\n"
			+ "having Do_Dai<= all(select Tam_Bay from [dbo].[maybay] where Loai like '%Boeing%')", nativeQuery = true)
	public List<ChuyenBay> findCBDuocLaiBoiBoeing();
}
