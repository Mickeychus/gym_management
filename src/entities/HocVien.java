package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HocVien")
@XmlAccessorType(XmlAccessType.FIELD)
public class HocVien {
	@XmlElement(name = "MaHocVien")
	private int maHocVien;
	@XmlElement(name = "HoTen")
	private String hoTen;
	@XmlElement(name = "Tuoi")
	private int tuoi;
        @XmlElement(name = "kieuhinh")
	private String  kieuhinh;
        @XmlElement(name = "date")
	private String date;
	@XmlElement(name = "DiaChi")
	private String diaChi;

	public HocVien(int maHocVien, String hoTen, int tuoi, String kieuhinh, String date, String diaChi) {
		this.maHocVien = maHocVien;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
                this.kieuhinh = kieuhinh;
                this.date = date;
		this.diaChi = diaChi;
	}

	public HocVien() {
	}

	public int getMaHocVien() {
		return maHocVien;
	}

	public void setMaHocVien(int maHocVien) {
		this.maHocVien = maHocVien;
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
        public String getkieuhinh() {
		return kieuhinh;
	}

	public void setkieuhinh(String kieuhinh) {
		this.kieuhinh = kieuhinh;
	}
         
        public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}