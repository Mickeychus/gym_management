package xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import entities.HocVien;

@XmlRootElement(name = "HocViens")
@XmlAccessorType(XmlAccessType.FIELD)
public class HocVienXML {

	private List<HocVien> HocVien;

	public List<HocVien> getHocVien() {
		return HocVien;
	}

	public void setHocVien(List<HocVien> hocVien) {
		this.HocVien = hocVien;
	}
}
