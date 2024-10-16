package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LoaiHinh")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoaiHinh {
	@XmlElement(name = "MaLoaiHinh")
	private int maLoaiHinh;
	@XmlElement(name = "TenLoaiHinh")
	private String tenLoaiHinh;

	public LoaiHinh(int maLoaiHinh, String tenLoaiHinh) {
		this.maLoaiHinh = maLoaiHinh;
		this.tenLoaiHinh = tenLoaiHinh;
	}

	public LoaiHinh() {
	}

	public int getMaLoaiHinh() {
		return maLoaiHinh;
	}

	public void setMaLoaiHinh(int maLoaiHinh) {
		this.maLoaiHinh = maLoaiHinh;
	}

	public String getTenLoaiHinh() {
		return tenLoaiHinh;
	}

	public void setTenLoaiHinh(String tenLoaiHinh) {
		this.tenLoaiHinh = tenLoaiHinh;
	}
}