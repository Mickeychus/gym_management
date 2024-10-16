package xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import entities.HuanLuyenVien;

@XmlRootElement(name = "HuanLuyenViens")
@XmlAccessorType(XmlAccessType.FIELD)
public class HuanLuyenVienXML {

	private List<HuanLuyenVien> HuanLuyenVien;

	public List<HuanLuyenVien> getHuanLuyenVien() {
		return HuanLuyenVien;
	}

	public void setHuanLuyenVien(List<HuanLuyenVien> huanLuyenVien) {
		this.HuanLuyenVien = huanLuyenVien;
	}
}
