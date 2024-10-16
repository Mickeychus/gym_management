package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.LoaiHinh;
import utils.FileUtils;
import xml.LoaiHinhXML;

public class LoaiHinhDao {
	private static final String LoaiHinh_FILE_NAME = "src/loaihinh.xml";
	private List<LoaiHinh> lstLoaiHinh;

	public LoaiHinhDao() {
		this.lstLoaiHinh = readLstLoaiHinh();
	}

	public void writeLstLoaiHinh(List<LoaiHinh> loaiHinhs) {
		LoaiHinhXML loaiHinhXML = new LoaiHinhXML();
		loaiHinhXML.setLoaiHinh(loaiHinhs);
		FileUtils.writeXMLtoFile(LoaiHinh_FILE_NAME, loaiHinhXML);
	}

	public List<LoaiHinh> readLstLoaiHinh() {
		List<LoaiHinh> list = new ArrayList<>();
		LoaiHinhXML loaiHinhXML = (LoaiHinhXML) FileUtils.readXMLFile(LoaiHinh_FILE_NAME, LoaiHinhXML.class);
		if (loaiHinhXML != null && loaiHinhXML.getLoaiHinh() != null) {
			list = loaiHinhXML.getLoaiHinh();
		}
		return list;
	}

	public void add(LoaiHinh loaiHinh) {
		int id = (lstLoaiHinh.size() > 0) ? (lstLoaiHinh.size() + 1) : 1;
		loaiHinh.setMaLoaiHinh(id);
		lstLoaiHinh.add(loaiHinh);
		writeLstLoaiHinh(lstLoaiHinh);
	}

	public void edit(LoaiHinh loaiHinh) {
		int size = lstLoaiHinh.size();
		for (int i = 0; i < size; i++) {
			if (lstLoaiHinh.get(i).getMaLoaiHinh() == loaiHinh.getMaLoaiHinh()) {
				lstLoaiHinh.get(i).setTenLoaiHinh(loaiHinh.getTenLoaiHinh());
				writeLstLoaiHinh(lstLoaiHinh);
				break;
			}
		}
	}

	public boolean delete(LoaiHinh loaiHinh) {
		boolean isFound = false;
		int size = lstLoaiHinh.size();
		for (int i = 0; i < size; i++) {
			if (lstLoaiHinh.get(i).getMaLoaiHinh() == loaiHinh.getMaLoaiHinh()) {
				loaiHinh = lstLoaiHinh.get(i);
				isFound = true;
				break;
			}
		}
		if (isFound) {
			lstLoaiHinh.remove(loaiHinh);
			writeLstLoaiHinh(lstLoaiHinh);
			return true;
		}
		return false;
	}

	public void sortLoaiHinhByName() {
		Collections.sort(lstLoaiHinh, Comparator.comparing(LoaiHinh::getTenLoaiHinh));
	}

	public List<LoaiHinh> getLstLoaiHinh() {
		return lstLoaiHinh;
	}

	public void setLstLoaiHinh(List<LoaiHinh> lstLoaiHinh) {
		this.lstLoaiHinh = lstLoaiHinh;
	}

	public void searchHocVien(String searchQuery) {
		List<LoaiHinh> filteredList = new ArrayList<>();

		for (LoaiHinh lh : readLstLoaiHinh()) {
			if (lh.getTenLoaiHinh().toLowerCase().contains(searchQuery.toLowerCase())
					|| (lh.getMaLoaiHinh() + "") == searchQuery.toLowerCase()) {
				filteredList.add(lh);
			}
		}
		lstLoaiHinh = filteredList;
	}
}
