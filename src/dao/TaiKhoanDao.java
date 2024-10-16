package dao;

import entities.TaiKhoan;

public class TaiKhoanDao {

	public boolean checkUser(TaiKhoan taikhoan) {
		if (taikhoan != null) {
			if ("chuvanlong".equals(taikhoan.getUserName()) && "123456".equals(taikhoan.getPassword())) {
				return true;
			}
                        if ("vuviettuan".equals(taikhoan.getUserName()) && "123456".equals(taikhoan.getPassword())) {
				return true;
			}
                        if ("duongtrungkien".equals(taikhoan.getUserName()) && "123456".equals(taikhoan.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
