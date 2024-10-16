package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.HocVienDao;
import entities.HocVien;
import view.HocVienView;

public class HocVienController {

	private HocVienDao hocVienDao;
	private HocVienView hocVienView;

	public HocVienController(HocVienView view) {
		this.hocVienView = view;
		hocVienDao = new HocVienDao();

		view.addAddStudentListener(new AddStudentListener());
		view.addEdiStudentListener(new EditStudentListener());
		view.addDeleteStudentListener(new DeleteStudentListener());
		view.addClearListener(new ClearStudentListener());
//		view.addSortStudentGPAListener(new SortStudentGPAListener());
		view.addSortStudentNameListener(new SortStudentNameListener());
		view.addListStudentSelectionListener(new ListStudentSelectionListener());
		view.addSearchListener(new SearchListener());
	}

	public void showHocVienView() {
		List<HocVien> hocVienList = hocVienDao.getlstHocVien();
		hocVienView.setVisible(true);
		hocVienView.showListHocViens(hocVienList);
	}

	class AddStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HocVien hocVien = hocVienView.getHocVienInfo();
			if (hocVien != null) {
				hocVienDao.add(hocVien);
				hocVienView.showHocVien(hocVien);
				hocVienView.showListHocViens(hocVienDao.getlstHocVien());
				hocVienView.showMessage("Thêm thành công!");
			}
		}
	}

	class EditStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HocVien hocVien = hocVienView.getHocVienInfo();
			if (hocVien != null) {
				hocVienDao.edit(hocVien);
				hocVienView.showHocVien(hocVien);
				hocVienView.showListHocViens(hocVienDao.getlstHocVien());
				hocVienView.showMessage("Cập nhật thành công!");
			}
		}
	}

	class DeleteStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			HocVien hocVien = hocVienView.getHocVienInfo();
			if (hocVien != null) {
				hocVienDao.delete(hocVien);
				hocVienView.clearHocVienInfo();
				hocVienView.showListHocViens(hocVienDao.getlstHocVien());
				hocVienView.showMessage("Xóa thành công!");
			}
		}
	}

	class ClearStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			hocVienView.clearHocVienInfo();
		}
	}

	class SortStudentNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			hocVienDao.sortHocVienByName();
			hocVienView.showListHocViens(hocVienDao.getlstHocVien());
		}
	}

	class ListStudentSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			hocVienView.fillHocVienFromSelectedRow();
		}
	}

	class SearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String searchQuery = hocVienView.getSearchQuery();
			hocVienDao.searchHocVien(searchQuery);
			hocVienView.showListHocViens(hocVienDao.getlstHocVien());
		}
	}

}
