package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.LoaiHinhDao;
import entities.LoaiHinh;
import view.LoaiHinhView;

public class LoaiHinhController {

	private LoaiHinhDao loaiHinhDao;
	private LoaiHinhView loaiHinhView;

	public LoaiHinhController(LoaiHinhView view) {
		this.loaiHinhView = view;
		loaiHinhDao = new LoaiHinhDao();

		view.addAddStudentListener(new AddStudentListener());
		view.addEdiStudentListener(new EditStudentListener());
		view.addDeleteStudentListener(new DeleteStudentListener());
		view.addClearListener(new ClearStudentListener());
//		view.addSortStudentGPAListener(new SortStudentGPAListener());
		view.addSortStudentNameListener(new SortStudentNameListener());
		view.addListStudentSelectionListener(new ListStudentSelectionListener());
		view.addSearchListener(new SearchListener());
	}

	public void showLoaiHinhView() {
		List<LoaiHinh> loaiHinhList = loaiHinhDao.getLstLoaiHinh();
		loaiHinhView.setVisible(true);
		loaiHinhView.showListLoaiHinhs(loaiHinhList);
	}

	class AddStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoaiHinh loaiHinh = loaiHinhView.getLoaiHinhInfo();
			if (loaiHinh != null) {
				loaiHinhDao.add(loaiHinh);
				loaiHinhView.showLoaiHinh(loaiHinh);
				loaiHinhView.showListLoaiHinhs(loaiHinhDao.getLstLoaiHinh());
				loaiHinhView.showMessage("Thêm thành công!");
			}
		}
	}

	class EditStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoaiHinh loaiHinh = loaiHinhView.getLoaiHinhInfo();
			if (loaiHinh != null) {
				loaiHinhDao.edit(loaiHinh);
				loaiHinhView.showLoaiHinh(loaiHinh);
				loaiHinhView.showListLoaiHinhs(loaiHinhDao.getLstLoaiHinh());
				loaiHinhView.showMessage("Cập nhật thành công!");
			}
		}
	}

	class DeleteStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoaiHinh loaiHinh = loaiHinhView.getLoaiHinhInfo();
			if (loaiHinh != null) {
				loaiHinhDao.delete(loaiHinh);
				loaiHinhView.clearLoaiHinhInfo();
				loaiHinhView.showListLoaiHinhs(loaiHinhDao.getLstLoaiHinh());
				loaiHinhView.showMessage("Xóa thành công!");
			}
		}
	}

	class ClearStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			loaiHinhView.clearLoaiHinhInfo();
		}
	}

	class SortStudentNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			loaiHinhDao.sortLoaiHinhByName();
			loaiHinhView.showListLoaiHinhs(loaiHinhDao.getLstLoaiHinh());
		}
	}

	class ListStudentSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			loaiHinhView.fillLoaiHinhFromSelectedRow();
		}
	}

	class SearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String searchQuery = loaiHinhView.getSearchQuery();
			loaiHinhDao.searchHocVien(searchQuery);
			loaiHinhView.showListLoaiHinhs(loaiHinhDao.getLstLoaiHinh());
		}
	}
}
