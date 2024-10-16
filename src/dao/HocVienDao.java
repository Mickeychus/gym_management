package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.HocVien;
import utils.FileUtils;
import xml.HocVienXML;

/**
 * HocVienFunc class
 * 
 * @author viettuts.vn
 */
public class HocVienDao {
	private static final String HocVien_FILE_NAME = "src/hocvien.xml";
	private List<HocVien> lstHocVien;

	public HocVienDao() {
		this.lstHocVien = readlstHocVien();
	}

	public void writelstHocVien(List<HocVien> hocViens) {
		HocVienXML HocVienXML = new HocVienXML();
		HocVienXML.setHocVien(hocViens);
		FileUtils.writeXMLtoFile(HocVien_FILE_NAME, HocVienXML);
	}

	public List<HocVien> readlstHocVien() {
		List<HocVien> list = new ArrayList<HocVien>();
		HocVienXML hocVienXML = (HocVienXML) FileUtils.readXMLFile(HocVien_FILE_NAME, HocVienXML.class);
		if (hocVienXML != null && hocVienXML.getHocVien() != null) {
			list = hocVienXML.getHocVien();
		}
		return list;
	}

	public void add(HocVien hocVien) {
		/*int id = (lstHocVien.size() > 0) ? (lstHocVien.size() + 1) : 1;
		hocVien.setMaHocVien(id);
		lstHocVien.add(hocVien);
		writelstHocVien(lstHocVien);*/
                int id;

                if (lstHocVien.size() > 0) {
                    // Tìm giá trị id lớn nhất trong danh sách và cộng thêm 1
                    int maxId = lstHocVien.stream()
                            .mapToInt(HocVien::getMaHocVien)
                            .max()
                            .orElse(0);
                    id = maxId + 1;
                } else {
                    id = 1;
                }

                hocVien.setMaHocVien(id);
                lstHocVien.add(hocVien);
                writelstHocVien(lstHocVien);
	}

	public void edit(HocVien hocVien) {
		for (HocVien existingHocVien : lstHocVien) {
			if (existingHocVien.getMaHocVien() == hocVien.getMaHocVien()) {
				existingHocVien.setHoTen(hocVien.getHoTen());
				existingHocVien.setTuoi(hocVien.getTuoi());
                                existingHocVien.setkieuhinh(hocVien.getkieuhinh());
				existingHocVien.setDiaChi(hocVien.getDiaChi());
				break;
			}
		}
		writelstHocVien(lstHocVien);
	}

	public boolean delete(HocVien hocVien) {
		boolean isFound = false;
		int size = lstHocVien.size();
		for (int i = 0; i < size; i++) {
			if (lstHocVien.get(i).getMaHocVien() == hocVien.getMaHocVien()) {
				hocVien = lstHocVien.get(i);
				isFound = true;
				break;
			}
		}
		if (isFound) {
			lstHocVien.remove(hocVien);
			writelstHocVien(lstHocVien);
			return true;
		}
		return false;
	}

	public void sortHocVienByName() {
		Collections.sort(lstHocVien, new Comparator<HocVien>() {
			public int compare(HocVien hocVien1, HocVien hocVien2) {
				return hocVien1.getHoTen().compareTo(hocVien2.getHoTen());
			}
		});
	}

	public List<HocVien> getlstHocVien() {
		return lstHocVien;
	}

	public void setlstHocVien(List<HocVien> lstHocVien) {
		this.lstHocVien = lstHocVien;
	}

	public void searchHocVien(String searchQuery) {
		List<HocVien> filteredList = new ArrayList<>();

		for (HocVien hocVien : readlstHocVien()) {
			if (hocVien.getHoTen().toLowerCase().contains(searchQuery.toLowerCase())
                                        || hocVien.getdate().toLowerCase().contains(searchQuery.toLowerCase())
					|| hocVien.getkieuhinh().toLowerCase().contains(searchQuery.toLowerCase())
                                        || hocVien.getDiaChi().toLowerCase().contains(searchQuery.toLowerCase())
					|| (hocVien.getMaHocVien() + "") == searchQuery.toLowerCase()) {
				filteredList.add(hocVien);
			}
		}
		lstHocVien = filteredList;
	}
}