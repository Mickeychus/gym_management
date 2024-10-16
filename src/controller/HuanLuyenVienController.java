package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.HuanLuyenVienDao;
import entities.HuanLuyenVien;
import view.HuanLuyenVienView;

public class HuanLuyenVienController {

	private HuanLuyenVienDao huanLuyenVienDao;
	private HuanLuyenVienView huanLuyenVienView;

	public HuanLuyenVienController(HuanLuyenVienView view) {
		this.huanLuyenVienView = view;
		huanLuyenVienDao = new HuanLuyenVienDao();

		view.addAddStudentListener(new AddStudentListener());
		view.addEdiStudentListener(new EditStudentListener());
		view.addDeleteStudentListener(new DeleteStudentListener());
		view.addClearListener(new ClearStudentListener());
//		view.addSortStudentGPAListener(new SortStudentGPAListener());
		view.addSortStudentNameListener(new SortStudentNameListener());
		view.addListStudentSelectionListener(new ListStudentSelectionListener());
		view.addSearchListener(new SearchListener());
	}

	public void showhuanLuyenVienView() {
		List<HuanLuyenVien> hocVienList = huanLuyenVienDao.getlstHuanLuyenVien();
		huanLuyenVienView.setVisible(true);
		huanLuyenVienView.showListHuanLuyenViens(hocVienList);
	}

	class AddStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HuanLuyenVien hocVien = huanLuyenVienView.getHuanLuyenVienInfo();
			if (hocVien != null) {
				huanLuyenVienDao.add(hocVien);
				huanLuyenVienView.showHuanLuyenVien(hocVien);
				huanLuyenVienView.showListHuanLuyenViens(huanLuyenVienDao.getlstHuanLuyenVien());
				huanLuyenVienView.showMessage("Thêm thành công!");
			}
		}
	}

	class EditStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HuanLuyenVien hocVien = huanLuyenVienView.getHuanLuyenVienInfo();
			if (hocVien != null) {
				huanLuyenVienDao.edit(hocVien);
				huanLuyenVienView.showHuanLuyenVien(hocVien);
				huanLuyenVienView.showListHuanLuyenViens(huanLuyenVienDao.getlstHuanLuyenVien());
				huanLuyenVienView.showMessage("Cập nhật thành công!");
			}
		}
	}

	class DeleteStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HuanLuyenVien hocVien = huanLuyenVienView.getHuanLuyenVienInfo();
			if (hocVien != null) {
				huanLuyenVienDao.delete(hocVien);
				huanLuyenVienView.clearHuanLuyenVienInfo();
				huanLuyenVienView.showListHuanLuyenViens(huanLuyenVienDao.getlstHuanLuyenVien());
				huanLuyenVienView.showMessage("Xóa thành công!");
			}
		}
	}

	class ClearStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			huanLuyenVienView.clearHuanLuyenVienInfo();
		}
	}

	class SortStudentNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			huanLuyenVienDao.sortHuanLuyenVienByName();
			huanLuyenVienView.showListHuanLuyenViens(huanLuyenVienDao.getlstHuanLuyenVien());
		}
	}

	class ListStudentSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			huanLuyenVienView.fillHuanLuyenVienFromSelectedRow();
		}
	}

	class SearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String searchQuery = huanLuyenVienView.getSearchQuery();
			huanLuyenVienDao.searchHuanLuyenVien(searchQuery);
			huanLuyenVienView.showListHuanLuyenViens(huanLuyenVienDao.getlstHuanLuyenVien());
		}
	}
}
