package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.TaiKhoanDao;
import entities.TaiKhoan;
import view.ControlPanelView;
import view.DangNhapView;

public class DangNhapController {
	private TaiKhoanDao taiKhoanDao;
	private DangNhapView dangNhapView;
//	private HocVienView hocVienView;
	private ControlPanelView controlPanelView;

	public DangNhapController(DangNhapView view) {
		this.dangNhapView = view;
		this.taiKhoanDao = new TaiKhoanDao();
		view.addLoginListener(new LoginListener());
	}

	public void showLoginView() {
		dangNhapView.setVisible(true);
	}

	/**
	 * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
	 * 
	 * @author viettuts.vn
	 */
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TaiKhoan taiKhoan = dangNhapView.getTaiKhoan();
			if (taiKhoanDao.checkUser(taiKhoan)) {
				// nếu đăng nhập thành công, mở màn hình quản lý sinh viên
//				hocVienView = new HocVienView();
//				HocVienController hocVienController = new HocVienController(hocVienView);
//				hocVienController.showHocVienView();
				controlPanelView = new ControlPanelView();
//				controlPanelView
				dangNhapView.setVisible(false);
			} else {
				dangNhapView.showMessage("username hoặc password không đúng.");
			}
		}
	}

}
