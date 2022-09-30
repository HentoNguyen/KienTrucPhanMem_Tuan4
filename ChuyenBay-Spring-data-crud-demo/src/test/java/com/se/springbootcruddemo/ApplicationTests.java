package com.se.springbootcruddemo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.se.springbootcruddemo.entity.ChungNhan;
import com.se.springbootcruddemo.entity.ChuyenBay;
import com.se.springbootcruddemo.entity.MayBay;
import com.se.springbootcruddemo.entity.NhanVien;
import com.se.springbootcruddemo.respository.ChuyenBayRespository;
import com.se.springbootcruddemo.service.ChungNhanService;
import com.se.springbootcruddemo.service.ChuyenBayService;
import com.se.springbootcruddemo.service.MayBayService;
import com.se.springbootcruddemo.service.NhanVienService;
import com.se.springbootcruddemo.serviceImpl.ChungNhanServiceImpl;
import com.se.springbootcruddemo.serviceImpl.ChuyenBayServiceImpl;
import com.se.springbootcruddemo.serviceImpl.MayBayServiceImpl;
import com.se.springbootcruddemo.serviceImpl.NhanVienServiceImpl;

@SpringBootTest
class ApplicationTests {
	@Autowired
	ChuyenBayServiceImpl chuyenBayServiceImpl;
	
	@Autowired
	MayBayServiceImpl mayBayServiceImpl;
	@Autowired
	NhanVienServiceImpl nhanVienServiceImpl;
	@Autowired
	ChungNhanServiceImpl chungNhanServiceImpl;

//	1. Cho biết các chuyến bay đi Đà Lạt (DAD).
	@Test
	void testCau1() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findByGaDen("DAD");
		System.out.println("Câu 1:các chuyến bay đi Đà Lạt (DAD) là: ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("\t"+chuyenBay);
		}
	}
	
	
	@Test
	void testCau1_2() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findByDoDaiDBNhoHon10000VaLoHon8000();
		System.out.println("Câu 1.2:Chuyen bay do dai 8->10k là: ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("\t" + chuyenBay);
		}
		System.out.println("\n");
	}
	
	

//  2. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
	@Test
	void testCau2() {
		List<String> mayBays = mayBayServiceImpl.findByTamBayLonHon10000();
		System.out.println("Câu 2:các loại máy bay có tầm bay lớn hơn 10,000km: ");
		for (String mayBay : mayBays) {
			System.out.println("\t" + mayBay);
		}
		System.out.println("\n");
	}

//	3. Tìm các nhân viên có lương nhỏ hơn 10,000.
	@Test
	void testCau3() {
		List<NhanVien> nhanViens = nhanVienServiceImpl.findByLuongNhoHon10000();
		System.out.println("Câu 3:các nhân viên có lương nhỏ hơn 10,000. ");
		for (NhanVien nhanVien : nhanViens) {
			System.out.println("+\t" + nhanVien);
		}
		System.out.println("\n");
	}
//	4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km
	@Test
	void testCau4() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findByDoDaiDBNhoHon10000VaLoHon8000();
		System.out.println("Câu 4:các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km: ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("+\t" + chuyenBay);
		}
		System.out.println("\n");
	}
//	5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
	@Test
	void testCau5() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findBySGtoBMT();
		System.out.println("Câu 5:các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV). ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("+\t" + chuyenBay);
		}
		System.out.println("\n");
	}
//	6. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
	@Test
	void testCau6() {
		int tongChuyenBay = chuyenBayServiceImpl.sumCBFromSG();
		System.out.println("Câu 6:các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV): "+tongChuyenBay+"\n");
	}
//	7. Có bao nhiêu loại máy báy Boeing.
	@Test
	void testCau7() {
		int sumMayBayBoeing =mayBayServiceImpl.sumMayBayBoeing();
		System.out.println("Câu 7:Tong loại máy báy Boeing: "+sumMayBayBoeing+"\n");
	}
//	8. Cho biết tổng số lương phải trả cho các nhân viên.
	@Test
	void testCau8() {
		int sumLuong =nhanVienServiceImpl.sumLuong();
		System.out.println("Câu 8:tổng số lương phải trả cho các nhân viên.: "+sumLuong+"\n");
	}
//	9. Cho biết mã số của các phi công lái máy báy Boeing
	@Test
	void testCau9() {
		List<String> listMaNV = chungNhanServiceImpl.findByBoeing();
		System.out.println("Câu 9:mã số của các phi công lái máy báy Boeing. ");
		for (String maNV : listMaNV) {
			System.out.println("+\t" + maNV);
			
		}
		System.out.println("\n");
	}
//	10. Cho biết các nhân viên có thể lái máy bay có mã số 747.
	@Test
	void testCau10() {
		List<NhanVien> nhanViens = nhanVienServiceImpl.findBymaMB747();
		System.out.println("Câu 10:các nhân viên có thể lái máy bay có mã số 747. ");
		for (NhanVien nhanVien : nhanViens) {
			System.out.println("+\t" + nhanVien);
		}
		System.out.println("\n");
	}
//	11. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
	@Test
	void testCau11() {
		List<String> listMaMB = mayBayServiceImpl.findMaByNameNguyen();
		System.out.println("Câu 11:mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái. ");
		for (String maMB : listMaMB) {
			System.out.println("+\t" + maMB);
			
		}
		System.out.println("\n");
	}
//	12. Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
	@Test
	void testCau12() {
		List<String> listMaNV = nhanVienServiceImpl.findMaByNVLaiBoeingVaAirbus();
		System.out.println("Câu 12:mã số của các phi công vừa lái được Boeing vừa lái được Airbus. ");
		for (String maNV : listMaNV) {
			System.out.println("+\t" + maNV);
			
		}
		System.out.println("\n");
	}
//	13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280
	@Test
	void testCau13() {
		List<String> listLoaiMB = mayBayServiceImpl.findLoaiByCBVN280();
		System.out.println("Câu 13:các loại máy bay có thể thực hiện chuyến bay VN280 ");
		for (String loaiMB : listLoaiMB) {
			System.out.println("+\t" + loaiMB);
			
		}
		System.out.println("\n");
	}
//	14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320
	@Test
	void testCau14() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findCBByMBAirbusA320();
		System.out.println("Câu 14:các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320 ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("+\t" + chuyenBay);
		}
		System.out.println("\n");
	}
//	15. Cho biết tên của các phi công lái máy bay Boein
	@Test
	void testCau15() {
		List<String> listTenNV = nhanVienServiceImpl.findTenByNVLaiBoeing();
		System.out.println("Câu 15:tên của các phi công lái máy bay Boein ");
		for (String tenNV : listTenNV) {
			System.out.println("+\t" + tenNV);
			
		}
		System.out.println("\n");
	}
//	16. Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
	@Test
	void testCau16() {
		List<Object[]> objects =  mayBayServiceImpl.findMaLoaiVaTongPhiCong();
		System.out.println("Câu 16:Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó: ");
		for (Object[] objects2 : objects) {
			System.out.println("+\t" + "MaMB: " + objects2[0] + ", Loai: " + objects2[1] + ", So luong phi cong: " + objects2[2]);
		}
		System.out.println("\n");
	}
//	17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các
//	đường bay nào có thể đáp ứng yêu cầu này.
	@Test
	void testCau17() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findDBFromAtoBAndToA();
		System.out.println("Câu 17:các đường bay bay từ ga A đến ga B rồi quay trở về ga A: ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("+\t" + chuyenBay);
		}
		System.out.println("\n");
	}
//	18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga 
//	đó.
	@Test
	void testCau18() {
		List<Object[]> objects =  chuyenBayServiceImpl.countChuyenBayKhoiHanh();
		System.out.println("Câu 18:Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga \n"
				+ "	đó.");
		for (Object[] objects2 : objects) {
			System.out.println("+\t" + "Ga di: " + objects2[0] + ", So luong chuyen bay: " + objects2[1]);
		}
		System.out.println("\n");
	}
//	19. Với mỗi ga có chuyến bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các 
//	chuyến bay khởi hành từ ga đó.
	@Test
	void testCau19() {
		List<Object[]> objects =  chuyenBayServiceImpl.tongChiPhiPhaiTra();
		System.out.println("Câu 19:Với mỗi ga có chuyến bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các \n"
				+ "chuyến bay khởi hành từ ga đó.");
		for (Object[] objects2 : objects) {
			System.out.println("+\t" + "Ga di: " + objects2[0] + ", Tong chi phi: " + objects2[1]);
		}
		System.out.println("\n");
	}
//	20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00
	@Test
	void testCau20() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findCBKHTruoc12h();
		System.out.println("Câu 20:danh sách các chuyến bay có thể khởi hành trước 12:00: ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("+\t" + chuyenBay);
		}
		System.out.println("\n");
	}
//	21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.
	@Test
	void testCau21() {
		List<Object[]> objects =  chuyenBayServiceImpl.countDiaDiemKhoiHanhTruoc12h();
		System.out.println("Câu 21:Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00.");
		for (Object[] objects2 : objects) {
			System.out.println("+\t" + "Ga di: " + objects2[0] + ", So luong chuyen bay: " + objects2[1]);
		}
		System.out.println("\n");
	}
//	22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
	@Test
	void testCau22() {
		List<String> listMaNV = nhanVienServiceImpl.findMaNVChiLaiDuoc3LoaiMayBay();
		System.out.println("Câu 22:mã số của các phi công chỉ lái được 3 loại máy bay ");
		for (String maNV : listMaNV) {
			System.out.println("+\t" + maNV);	
		}
		System.out.println("\n");
	}
//	23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn 
//	nhất của các loại máy bay mà phi công đó có thể lái.
	@Test
	void testCau23() {
		List<Object[]> objects =  nhanVienServiceImpl.findMaNVLaiDuocHon3LoaiMayBayVaMaxTamBay();
		System.out.println("Câu 23:Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn \n"
				+ "nhất của các loại máy bay mà phi công đó có thể lái.");
		for (Object[] objects2 : objects) {
			System.out.println("+\t" + "Ma NV: " + objects2[0] + ", Tam bay lon nhat: " + objects2[1]);
		}
		System.out.println("\n");
	}
//	24. Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
	@Test
	void testCau24() {
		List<Object[]> objects =  nhanVienServiceImpl.findMaNVAndCountLoaiMayBayCoTheLai();
		System.out.println("Câu 24:Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.");
		for (Object[] objects2 : objects) {
			System.out.println("+\t" + "Ma NV: " + objects2[0] + ", tổng số loại máy bay: " + objects2[1]);
		}
		System.out.println("\n");
	}
//	25. Tìm các nhân viên không phải là phi công.
	@Test
	void testCau25() {
		List<NhanVien> nhanViens = nhanVienServiceImpl.findNVKhongPhaiPhiCong();
		System.out.println("Câu 25:các nhân viên không phải là phi công. ");
		for (NhanVien nhanVien : nhanViens) {
			System.out.println("+\t" + nhanVien);
		}
		System.out.println("\n");
	}
//	26. Cho biết mã số của các nhân viên có lương cao nhất.
	@Test
	void testCau26() {
		List<String> listMaNV = nhanVienServiceImpl.findNVMaxLuong();
		System.out.println("Câu 26:mã số của các nhân viên có lương cao nhất. ");
		for (String maNV : listMaNV) {
			System.out.println("+\t" + maNV);
		}
		System.out.println("\n");
	}
//	27. Cho biết tổng số lương phải trả cho các phi công
	@Test
	void testCau27() {
		int tongSoLuong=nhanVienServiceImpl.tongSoLuongPhaiTra();
		System.out.println("Câu 27:tổng số lương phải trả cho các phi công: "+tongSoLuong+"\n");
	}
//	28. Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing
	@Test
	void testCau28() {
		List<ChuyenBay> chuyenBays = chuyenBayServiceImpl.findCBDuocLaiBoiBoeing();
		System.out.println("Câu 28:các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing ");
		for (ChuyenBay chuyenBay : chuyenBays) {
			System.out.println("+\t" + chuyenBay);
		}
		System.out.println("\n");
	}
}
