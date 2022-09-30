package com.se.springbootcruddemo.respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.springbootcruddemo.entity.NhanVien;

public interface NhanVienRespository extends JpaRepository<NhanVien, String>  {
//	3. Tìm các nhân viên có lương nhỏ hơn 10,000.
	@Query(value = "select * from [dbo].[nhanvien] where [Luong]<10000",nativeQuery = true)
	public List<NhanVien> findByLuongNhoHon10000();
	
//	8. Cho biết tổng số lương phải trả cho các nhân viên.
	@Query(value = "select SUM([Luong]) from [dbo].[nhanvien]", nativeQuery = true)
	public int sumLuong();
	
//	10. Cho biết các nhân viên có thể lái máy bay có mã số 747.
	@Query(value = "SELECT        nhanvien.MaNV, nhanvien.Ten, nhanvien.Luong\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "where chungnhan.MaMB=747", nativeQuery = true)
	public List<NhanVien> findBymaMB747();
	
//	12. Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
	@Query(value = "SELECT        nhanvien.MaNV\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "where ([Loai] like '%Boeing%' or [Loai] like '%Airbus%')\r\n"
			+ "group by nhanvien.MaNV", nativeQuery = true)
	public List<String> findMaByNVLaiBoeingVaAirbus();
	
//	15. Cho biết tên của các phi công lái máy bay Boein
	@Query(value = "SELECT        nhanvien.Ten\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "where [Loai] like '%Boeing%'\r\n"
			+ "group by nhanvien.Ten", nativeQuery = true)
	public List<String> findTenByNVLaiBoeing();
	
//	22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
	@Query(value = "SELECT        nhanvien.MaNV\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "group by  nhanvien.MaNV\r\n"
			+ "having COUNT(maybay.MaMB)=3", nativeQuery = true)
	public List<String> findMaNVChiLaiDuoc3LoaiMayBay();
	
//	23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn 
//	nhất của các loại máy bay mà phi công đó có thể lái.
	@Query(value = "SELECT        nhanvien.MaNV, MAX(maybay.Tam_Bay) as TamBayLonNhat\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "group by  nhanvien.MaNV\r\n"
			+ "HAVING COUNT(maybay.MaMB)>3", nativeQuery = true)
	public List<Object[]> findMaNVLaiDuocHon3LoaiMayBayVaMaxTamBay();
	
//	24. Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
	@Query(value = "SELECT        nhanvien.MaNV, COUNT(maybay.Loai) as TongLoaiSoMayBay\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "group by nhanvien.MaNV", nativeQuery = true)
	public List<Object[]> findMaNVAndCountLoaiMayBayCoTheLai();
	
//	25. Tìm các nhân viên không phải là phi công.
	@Query(value = "select * from [dbo].[nhanvien]\r\n"
			+ "where MaNV not in (select MaNV from chungnhan)", nativeQuery = true)
	public List<NhanVien> findNVKhongPhaiPhiCong();
	
//	26. Cho biết mã số của các nhân viên có lương cao nhất.
	@Query(value = "select MaNV from [dbo].[nhanvien] where Luong=(select max(Luong) from [dbo].[nhanvien])", nativeQuery = true)
	public List<String> findNVMaxLuong();
	
//	27. Cho biết tổng số lương phải trả cho các phi công
	@Query(value = "SELECT       sum(luong) as TongSoLuong\r\n"
			+ "FROM            nhanvien\r\n"
			+ "where MaNV  in (select MaNV from chungnhan)", nativeQuery = true)
	public int tongSoLuongPhaiTra();
	
}
