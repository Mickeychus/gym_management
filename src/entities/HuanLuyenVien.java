package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HuanLuyenVien")
@XmlAccessorType(XmlAccessType.FIELD)
public class HuanLuyenVien {
	@XmlElement(name = "MaHuanLuyenVien")
	private int maHuanLuyenVien;
	@XmlElement(name = "HoTen")
	private String hoTen;
	@XmlElement(name = "Tuoi")
	private int tuoi;
	@XmlElement(name = "DiaChi")
	private String diaChi;

	public HuanLuyenVien(int maHuanLuyenVien, String hoTen, int tuoi, String diaChi) {
		this.maHuanLuyenVien = maHuanLuyenVien;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
	}

	public HuanLuyenVien() {
	}

	public int getMaHuanLuyenVien() {
		return maHuanLuyenVien;
	}

	public void setMaHuanLuyenVien(int maHuanLuyenVien) {
		this.maHuanLuyenVien = maHuanLuyenVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}
