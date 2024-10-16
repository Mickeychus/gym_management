package xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import entities.LoaiHinh;

@XmlRootElement(name = "LoaiHinhs")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoaiHinhXML {

	private List<LoaiHinh> LoaiHinh;

	public List<LoaiHinh> getLoaiHinh() {
		return LoaiHinh;
	}

	public void setLoaiHinh(List<LoaiHinh> loaiHinh) {
		this.LoaiHinh = loaiHinh;
	}
}
