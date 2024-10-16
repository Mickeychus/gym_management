package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.HocVienController;
import controller.HuanLuyenVienController;
import controller.LoaiHinhController;
import controller.PhongTapController;

public class ControlPanelView {

	private JFrame frmCngCQun;
	private HocVienView hocVienView;
	private HuanLuyenVienView huanLuyenVienView;
	private PhongTapView phongTapView;
	private LoaiHinhView loaiHinhView;
	JButton btnHV;
	JButton btnHLV;
	JButton btnPT;
	JButton btnLH;

	public ControlPanelView() {
		initialize();
	}

	private void initialize() {
		frmCngCQun = new JFrame();
		frmCngCQun.setTitle("QUẢN LÝ PHÒNG GYM");
		frmCngCQun.setBounds(100, 100, 1275, 328);
		frmCngCQun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCngCQun.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		btnHV = new JButton("Quản lý Học viên");
		btnHV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hocVienView = new HocVienView();
				HocVienController hocVienController = new HocVienController(hocVienView);
				hocVienController.showHocVienView();
//				frmCngCQun.setVisible(false);
			}
		});
		btnHV.setFont(new Font("Tahoma", Font.BOLD, 19));
		frmCngCQun.getContentPane().add(btnHV);

		btnHLV = new JButton("Quản lý Huấn luyện viên");
		btnHLV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huanLuyenVienView = new HuanLuyenVienView();
				HuanLuyenVienController huanLuyenVienController = new HuanLuyenVienController(huanLuyenVienView);
				huanLuyenVienController.showhuanLuyenVienView();
//				frmCngCQun.setVisible(false);
			}
		});
		btnHLV.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmCngCQun.getContentPane().add(btnHLV);

		btnPT = new JButton("Quản lý Phòng Tập");
		btnPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phongTapView = new PhongTapView();
				PhongTapController phongTapController = new PhongTapController(phongTapView);
				phongTapController.showPhongTapView();
//				frmCngCQun.setVisible(false);
			}
		});
		btnPT.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmCngCQun.getContentPane().add(btnPT);

		btnLH = new JButton("Quản lý Loại Hình");
		btnLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loaiHinhView = new LoaiHinhView();
				LoaiHinhController loaiHinhController = new LoaiHinhController(loaiHinhView);
				loaiHinhController.showLoaiHinhView();
//				frmCngCQun.setVisible(false);
			}
		});
		btnLH.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmCngCQun.getContentPane().add(btnLH);

		frmCngCQun.setVisible(true);
	}

}
