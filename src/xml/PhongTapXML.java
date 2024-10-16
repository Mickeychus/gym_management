package xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import entities.PhongTap;

@XmlRootElement(name = "PhongTaps")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhongTapXML {

	private List<PhongTap> PhongTap;

	public List<PhongTap> getPhongTap() {
		return PhongTap;
	}

	public void setPhongTap(List<PhongTap> phongTap) {
		this.PhongTap = phongTap;
	}
}
