package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.PhongTap;
import utils.FileUtils;
import xml.PhongTapXML;

public class PhongTapDao {
	private static final String PhongTap_FILE_NAME = "src/phongtap.xml";
	private List<PhongTap> lstPhongTap;

	public PhongTapDao() {
		this.lstPhongTap = readLstPhongTap();
	}

	public void writeLstPhongTap(List<PhongTap> phongTaps) {
		PhongTapXML phongTapXML = new PhongTapXML();
		phongTapXML.setPhongTap(phongTaps);
		FileUtils.writeXMLtoFile(PhongTap_FILE_NAME, phongTapXML);
	}

	public List<PhongTap> readLstPhongTap() {
		List<PhongTap> list = new ArrayList<>();
		PhongTapXML phongTapXML = (PhongTapXML) FileUtils.readXMLFile(PhongTap_FILE_NAME, PhongTapXML.class);
		if (phongTapXML != null && phongTapXML.getPhongTap() != null) {
			list = phongTapXML.getPhongTap();
		}
		return list;
	}

	public void add(PhongTap phongTap) {
		int id = (lstPhongTap.size() > 0) ? (lstPhongTap.size() + 1) : 1;
		phongTap.setMaPhongTap(id);
		lstPhongTap.add(phongTap);
		writeLstPhongTap(lstPhongTap);
	}

	public void edit(PhongTap phongTap) {
		int size = lstPhongTap.size();
		for (int i = 0; i < size; i++) {
			if (lstPhongTap.get(i).getMaPhongTap() == phongTap.getMaPhongTap()) {
				lstPhongTap.get(i).setTenPhongTap(phongTap.getTenPhongTap());
				lstPhongTap.get(i).setDiaChi(phongTap.getDiaChi());
				writeLstPhongTap(lstPhongTap);
				break;
			}
		}
	}

	public boolean delete(PhongTap phongTap) {
		boolean isFound = false;
		int size = lstPhongTap.size();
		for (int i = 0; i < size; i++) {
			if (lstPhongTap.get(i).getMaPhongTap() == phongTap.getMaPhongTap()) {
				phongTap = lstPhongTap.get(i);
				isFound = true;
				break;
			}
		}
		if (isFound) {
			lstPhongTap.remove(phongTap);
			writeLstPhongTap(lstPhongTap);
			return true;
		}
		return false;
	}

	public void sortPhongTapByName() {
		Collections.sort(lstPhongTap, Comparator.comparing(PhongTap::getTenPhongTap));
	}

	public List<PhongTap> getLstPhongTap() {
		return lstPhongTap;
	}

	public void setLstPhongTap(List<PhongTap> lstPhongTap) {
		this.lstPhongTap = lstPhongTap;
	}

	public void searchHocVien(String searchQuery) {
		List<PhongTap> filteredList = new ArrayList<>();
		for (PhongTap pt : readLstPhongTap()) {
			if (pt.getTenPhongTap().toLowerCase().contains(searchQuery.toLowerCase())
					|| pt.getDiaChi().toLowerCase().contains(searchQuery.toLowerCase())
					|| (pt.getMaPhongTap() + "") == searchQuery.toLowerCase()) {
				filteredList.add(pt);
			}
		}
		lstPhongTap = filteredList;
	}
}
