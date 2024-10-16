package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.PhongTapDao;
import entities.PhongTap;
import view.PhongTapView;

public class PhongTapController {

	private PhongTapDao phongTapDao;
	private PhongTapView phongTapView;

	public PhongTapController(PhongTapView view) {
		this.phongTapView = view;
		phongTapDao = new PhongTapDao();

		view.addAddStudentListener(new AddStudentListener());
		view.addEdiStudentListener(new EditStudentListener());
		view.addDeleteStudentListener(new DeleteStudentListener());
		view.addClearListener(new ClearStudentListener());
//		view.addSortStudentGPAListener(new SortStudentGPAListener());
		view.addSortStudentNameListener(new SortStudentNameListener());
		view.addListStudentSelectionListener(new ListStudentSelectionListener());
		view.addSearchListener(new SearchListener());
	}

	public void showPhongTapView() {
		List<PhongTap> phongTapList = phongTapDao.getLstPhongTap();
		phongTapView.setVisible(true);
		phongTapView.showListPhongTaps(phongTapList);
	}

	class AddStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PhongTap phongTap = phongTapView.getPhongTapInfo();
			if (phongTap != null) {
				phongTapDao.add(phongTap);
				phongTapView.showPhongTap(phongTap);
				phongTapView.showListPhongTaps(phongTapDao.getLstPhongTap());
				phongTapView.showMessage("Thêm thành công!");
			}
		}
	}

	class EditStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PhongTap phongTap = phongTapView.getPhongTapInfo();
			if (phongTap != null) {
				phongTapDao.edit(phongTap);
				phongTapView.showPhongTap(phongTap);
				phongTapView.showListPhongTaps(phongTapDao.getLstPhongTap());
				phongTapView.showMessage("Cập nhật thành công!");
			}
		}
	}

	class DeleteStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			PhongTap phongTap = phongTapView.getPhongTapInfo();
			if (phongTap != null) {
				phongTapDao.delete(phongTap);
				phongTapView.clearPhongTapInfo();
				phongTapView.showListPhongTaps(phongTapDao.getLstPhongTap());
				phongTapView.showMessage("Xóa thành công!");
			}
		}
	}

	class ClearStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			phongTapView.clearPhongTapInfo();
		}
	}

	class SortStudentNameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			phongTapDao.sortPhongTapByName();
			phongTapView.showListPhongTaps(phongTapDao.getLstPhongTap());
		}
	}

	class ListStudentSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			phongTapView.fillPhongTapFromSelectedRow();
		}
	}

	class SearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String searchQuery = phongTapView.getSearchQuery();
			phongTapDao.searchHocVien(searchQuery);
			phongTapView.showListPhongTaps(phongTapDao.getLstPhongTap());
		}
	}
}
