package com.se.springbootcruddemo.respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.se.springbootcruddemo.entity.MayBay;

public interface MayBayRespository extends JpaRepository<MayBay, Integer>  {
	
//	2. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
	@Query(value = "select loai from [dbo].[maybay] where [Tam_Bay]>10000", nativeQuery = true)
	public List<String> findByTamBayLonHon10000();
	
//	7. Có bao nhiêu loại máy báy Boeing.
	@Query(value = "select count(*) from [dbo].[maybay] where [Loai] like '%Boeing%'", nativeQuery = true)
	public int sumMayBayBoeing();
	
//	11. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
	@Query(value = "SELECT        maybay.MaMB\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "where [dbo].[nhanvien].Ten like '%Nguyen%'\r\n"
			+ "group by maybay.MaMB", nativeQuery = true)
	public List<String> findMaByNameNguyen();

//	13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280
	@Query(value = "select Loai from maybay where Tam_Bay < (select Do_Dai from chuyenbay where MaCB = 'VN280')", nativeQuery = true)
	public List<String> findLoaiByCBVN280();
//	16. Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
	@Query(value = "SELECT        maybay.MaMB, maybay.Loai, maybay.Tam_Bay, COUNT(distinct nhanvien.MaNV) AS SoLuongPhiCong\r\n"
			+ "FROM            chungnhan INNER JOIN\r\n"
			+ "                         maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                         nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "group by maybay.MaMB, maybay.Loai,maybay.Tam_Bay", nativeQuery = true)
	public List<Object[]> findMaLoaiVaTongPhiCong();
}
