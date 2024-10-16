package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.HuanLuyenVien;
import utils.FileUtils;
import xml.HuanLuyenVienXML;

public class HuanLuyenVienDao {
	private static final String HuanLuyenVien_FILE_NAME = "src/huanluyenvien.xml";
	private List<HuanLuyenVien> lstHuanLuyenVien;

	public HuanLuyenVienDao() {
		this.lstHuanLuyenVien = readlstHuanLuyenVien();
	}

	public void writelstHuanLuyenVien(List<HuanLuyenVien> huanLuyenViens) {
		HuanLuyenVienXML HuanLuyenVienXML = new HuanLuyenVienXML();
		HuanLuyenVienXML.setHuanLuyenVien(huanLuyenViens);
		FileUtils.writeXMLtoFile(HuanLuyenVien_FILE_NAME, HuanLuyenVienXML);
	}

	public List<HuanLuyenVien> readlstHuanLuyenVien() {
		List<HuanLuyenVien> list = new ArrayList<HuanLuyenVien>();
		HuanLuyenVienXML HuanLuyenVienXML = (HuanLuyenVienXML) FileUtils.readXMLFile(HuanLuyenVien_FILE_NAME,
				HuanLuyenVienXML.class);
		if (HuanLuyenVienXML != null && HuanLuyenVienXML.getHuanLuyenVien() != null) {
			list = HuanLuyenVienXML.getHuanLuyenVien();
		}
		return list;
	}

	public void add(HuanLuyenVien huanLuyenVien) {
		/*int id = (lstHuanLuyenVien.size() > 0) ? (lstHuanLuyenVien.size() + 1) : 1;
		huanLuyenVien.setMaHuanLuyenVien(id);
		lstHuanLuyenVien.add(huanLuyenVien);
		writelstHuanLuyenVien(lstHuanLuyenVien);*/
                   int id;

                   if (lstHuanLuyenVien.size() > 0) {
                       // Tìm giá trị id lớn nhất trong danh sách và cộng thêm 1
                       int maxId = lstHuanLuyenVien.stream()
                               .mapToInt(HuanLuyenVien::getMaHuanLuyenVien)
                               .max()
                               .orElse(0);
                       id = maxId + 1;
                   } else {
                       id = 1;
                   }

                   huanLuyenVien.setMaHuanLuyenVien(id);
                   lstHuanLuyenVien.add(huanLuyenVien);
                   writelstHuanLuyenVien(lstHuanLuyenVien);
                
	}

	public void edit(HuanLuyenVien huanLuyenVien) {
		int size = lstHuanLuyenVien.size();
		for (int i = 0; i < size; i++) {
			if (lstHuanLuyenVien.get(i).getMaHuanLuyenVien() == huanLuyenVien.getMaHuanLuyenVien()) {
				lstHuanLuyenVien.get(i).setHoTen(huanLuyenVien.getHoTen());
				lstHuanLuyenVien.get(i).setTuoi(huanLuyenVien.getTuoi());
				lstHuanLuyenVien.get(i).setDiaChi(huanLuyenVien.getDiaChi());
				writelstHuanLuyenVien(lstHuanLuyenVien);
				break;
			}
		}
	}

	public boolean delete(HuanLuyenVien huanLuyenVien) {
		boolean isFound = false;
		int size = lstHuanLuyenVien.size();
		for (int i = 0; i < size; i++) {
			if (lstHuanLuyenVien.get(i).getMaHuanLuyenVien() == huanLuyenVien.getMaHuanLuyenVien()) {
				huanLuyenVien = lstHuanLuyenVien.get(i);
				isFound = true;
				break;
			}
		}
		if (isFound) {
			lstHuanLuyenVien.remove(huanLuyenVien);
			writelstHuanLuyenVien(lstHuanLuyenVien);
			return true;
		}
		return false;
	}

	public void sortHuanLuyenVienByName() {
		Collections.sort(lstHuanLuyenVien, new Comparator<HuanLuyenVien>() {
			public int compare(HuanLuyenVien huanLuyenVien1, HuanLuyenVien huanLuyenVien2) {
				return huanLuyenVien1.getHoTen().compareTo(huanLuyenVien2.getHoTen());
			}
		});
	}

	public List<HuanLuyenVien> getlstHuanLuyenVien() {
		return lstHuanLuyenVien;
	}

	public void setlstHuanLuyenVien(List<HuanLuyenVien> lstHuanLuyenVien) {
		this.lstHuanLuyenVien = lstHuanLuyenVien;
	}

	public void searchHuanLuyenVien(String searchQuery) {
		List<HuanLuyenVien> filteredList = new ArrayList<>();

		for (HuanLuyenVien hlv : readlstHuanLuyenVien()) {
			if (hlv.getHoTen().toLowerCase().contains(searchQuery.toLowerCase())
					|| hlv.getDiaChi().toLowerCase().contains(searchQuery.toLowerCase())
					|| (hlv.getMaHuanLuyenVien() + "") == searchQuery.toLowerCase()) {
				filteredList.add(hlv);
			}
		}
		lstHuanLuyenVien = filteredList;
	}
}
