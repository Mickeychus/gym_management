package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PhongTap")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhongTap {
	@XmlElement(name = "MaPhongTap")
	private int maPhongTap;
	@XmlElement(name = "TenPhongTap")
	private String tenPhongTap;
	@XmlElement(name = "DiaChi")
	private String diaChi;

	public PhongTap(int maPhongTap, String tenPhongTap, String diaChi) {
		this.maPhongTap = maPhongTap;
		this.tenPhongTap = tenPhongTap;
		this.diaChi = diaChi;
	}

	public PhongTap() {
	}

	public int getMaPhongTap() {
		return maPhongTap;
	}

	public void setMaPhongTap(int maPhongTap) {
		this.maPhongTap = maPhongTap;
	}

	public String getTenPhongTap() {
		return tenPhongTap;
	}

	public void setTenPhongTap(String tenPhongTap) {
		this.tenPhongTap = tenPhongTap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}