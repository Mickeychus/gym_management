package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entities.HocVien;

public class HocVienView extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private JButton addStudentBtn;
	private JButton editStudentBtn;
	private JButton deleteStudentBtn;
	private JButton clearBtn;
//	private JButton sortStudentGPABtn;
	private JButton sortStudentNameBtn;
	private JScrollPane jScrollPaneStudentTable;
	private JScrollPane jScrollPaneAddress;
	private JTable studentTable;

	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel ageLabel;
        private JLabel kieuhinhLabel;
        private JLabel dateLabel;
	private JLabel addressLabel;
//	private JLabel gpaLabel;

	private JTextField idField;
	private JTextField nameField;
	private JTextField ageField;
        private JTextField kieuhinhField;
        private JTextField dateField;
	private JTextArea addressTA;
//	private JTextField gpaField;

	private JButton searchBtn;
	private JTextField searchField;

	// định nghĩa các cột của bảng student
	private final String[] columnNames = new String[] { "Mã học viên", "Họ tên", "Tuổi", "Kiểu Hình", "Ngày tập", "Địa chỉ" };
	// định nghĩa dữ liệu mặc định của bẳng student là rỗng
	private final Object data = new Object[][] {};

	public HocVienView() {
		initComponents();
	}

	private void initComponents() {
//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// khởi tạo các phím chức năng
		addStudentBtn = new JButton("Thêm");
		editStudentBtn = new JButton("Sửa");
		deleteStudentBtn = new JButton("Xóa");
		clearBtn = new JButton("Làm mới");
//		sortStudentGPABtn = new JButton("Sort By GPA");
		sortStudentNameBtn = new JButton("Sắp xếp");
		// khởi tạo bảng student
		jScrollPaneStudentTable = new JScrollPane();
		studentTable = new JTable();

		// khởi tạo các label
		idLabel = new JLabel("Mã HV");
		nameLabel = new JLabel("Họ và tên");
		ageLabel = new JLabel("Tuổi");
                kieuhinhLabel = new JLabel("Kiểu hình");
                dateLabel = new JLabel("Ngày Tập");
		addressLabel = new JLabel("Địa chỉ");
//		gpaLabel = new JLabel("GPA");

		searchBtn = new JButton("Tìm kiếm");
		searchField = new JTextField(15);

		// khởi tạo các trường nhập dữ liệu cho student
		idField = new JTextField(6);
		idField.setEditable(false);
		nameField = new JTextField(15);
		ageField = new JTextField(15);
                kieuhinhField = new JTextField(15);
                dateField = new JTextField(15);
		addressTA = new JTextArea();
		addressTA.setColumns(15);
		addressTA.setRows(4);
		jScrollPaneAddress = new JScrollPane();
		jScrollPaneAddress.setViewportView(addressTA);
//		gpaField = new JTextField(6);

		// cài đặt các cột và data cho bảng student
		studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
		jScrollPaneStudentTable.setViewportView(studentTable);
		jScrollPaneStudentTable.setPreferredSize(new Dimension(480, 300));

		// tạo spring layout
		SpringLayout layout = new SpringLayout();
		// tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
		JPanel panel = new JPanel();
		panel.setSize(800, 420);
		panel.setLayout(layout);
		panel.add(jScrollPaneStudentTable);

		panel.add(addStudentBtn);
		panel.add(editStudentBtn);
		panel.add(deleteStudentBtn);
		panel.add(clearBtn);
//		panel.add(sortStudentGPABtn);
		panel.add(sortStudentNameBtn);

		panel.add(idLabel);
		panel.add(nameLabel);
		panel.add(ageLabel);
                panel.add(kieuhinhLabel);
                panel.add(dateLabel);
		panel.add(addressLabel);
//		panel.add(gpaLabel);

		panel.add(idField);
		panel.add(nameField);
		panel.add(ageField);
                panel.add(kieuhinhField);
                panel.add(dateField);
                panel.add(nameField);
		panel.add(jScrollPaneAddress);
//		panel.add(gpaField);
		panel.add(searchField);
		panel.add(searchBtn);

		// cài đặt vị trí các thành phần trên màn hình login
		layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
                
                layout.putConstraint(SpringLayout.WEST, kieuhinhLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, kieuhinhLabel, 100, SpringLayout.NORTH, panel);
                layout.putConstraint(SpringLayout.WEST, dateLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, dateLabel, 130, SpringLayout.NORTH, panel);
                
		layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, addressLabel, 170, SpringLayout.NORTH, panel);
//		layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
//		layout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
                
                layout.putConstraint(SpringLayout.WEST, kieuhinhField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, kieuhinhField, 100, SpringLayout.NORTH, panel);
                layout.putConstraint(SpringLayout.WEST, dateField, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, dateField, 130, SpringLayout.NORTH, panel);
                
		layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 160, SpringLayout.NORTH, panel);
//		layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
//		layout.putConstraint(SpringLayout.NORTH, gpaField, 200, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, addStudentBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 240, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, editStudentBtn, 60, SpringLayout.WEST, addStudentBtn);
		layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 240, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 60, SpringLayout.WEST, editStudentBtn);

		layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, clearBtn, 60, SpringLayout.WEST, deleteStudentBtn);

		layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 240, SpringLayout.NORTH, panel);
//		layout.putConstraint(SpringLayout.WEST, sortStudentGPABtn, 300, SpringLayout.WEST, panel);
//		layout.putConstraint(SpringLayout.NORTH, sortStudentGPABtn, 330, SpringLayout.NORTH, panel);
//		layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 115, SpringLayout.WEST, sortStudentGPABtn);

		layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, panel);

		layout.putConstraint(SpringLayout.WEST, searchField, 150, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, searchField, 330, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, searchBtn, 0, SpringLayout.EAST, searchField);
		layout.putConstraint(SpringLayout.NORTH, searchBtn, 330, SpringLayout.NORTH, panel);
               

		this.add(panel);
		this.pack();
		this.setTitle("Thông tin Học viên");
		this.setSize(800, 420);
		// disable Edit and Delete buttons
		editStudentBtn.setEnabled(false);
		deleteStudentBtn.setEnabled(false);
		// enable Add button
		addStudentBtn.setEnabled(true);
		searchBtn.setEnabled(true);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public void showListHocViens(List<HocVien> list) {
		int size = list.size();
		Object[][] hocViens = new Object[size][5];
		for (int i = 0; i < size; i++) {
			hocViens[i][0] = list.get(i).getMaHocVien();
			hocViens[i][1] = list.get(i).getHoTen();
			hocViens[i][2] = list.get(i).getTuoi();
                        hocViens[i][3] = list.get(i).getkieuhinh();
                        hocViens[i][4] = list.get(i).getdate();
			hocViens[i][5] = list.get(i).getDiaChi();
		}
		studentTable.setModel(new DefaultTableModel(hocViens, columnNames));
	}

	public void fillHocVienFromSelectedRow() {
		int row = studentTable.getSelectedRow();
		if (row >= 0) {
			idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
			nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
			ageField.setText(studentTable.getModel().getValueAt(row, 2).toString());
                        kieuhinhField.setText(studentTable.getModel().getValueAt(row, 3).toString());
                        dateField.setText(studentTable.getModel().getValueAt(row, 4).toString());
			addressTA.setText(studentTable.getModel().getValueAt(row, 5).toString());
			editStudentBtn.setEnabled(true);
			deleteStudentBtn.setEnabled(true);
			addStudentBtn.setEnabled(false);
		}
	}

	public void clearHocVienInfo() {
		idField.setText("");
		nameField.setText("");
		ageField.setText("");
                kieuhinhField.setText("");
                dateField.setText("");
		addressTA.setText("");
//		gpaField.setText("");
		// disable Edit and Delete buttons
		editStudentBtn.setEnabled(false);
		deleteStudentBtn.setEnabled(false);
		// enable Add button
		addStudentBtn.setEnabled(true);
	}

	public void showHocVien(HocVien hocVien) {
		idField.setText("" + hocVien.getMaHocVien());
		nameField.setText(hocVien.getHoTen());
		ageField.setText("" + hocVien.getTuoi());
                kieuhinhField.setText(hocVien.getkieuhinh());
                dateField.setText("" + hocVien.getdate());
		addressTA.setText(hocVien.getDiaChi());
//		gpaField.setText("" + hocVien.getGpa());
		// enable Edit and Delete buttons
		editStudentBtn.setEnabled(true);
		deleteStudentBtn.setEnabled(true);
		// disable Add button
		addStudentBtn.setEnabled(false);
	}

	public HocVien getHocVienInfo() {
		// validate student
		if (!validateName() || !validateAge() || !validatekieuhinh() || !validateAddress() 
                                || !validatedatedate()
//				|| !validateGPA()
		) {
			return null;
		}
		try {
			HocVien hocVien = new HocVien();
			if (idField.getText() != null && !"".equals(idField.getText())) {
				hocVien.setMaHocVien(Integer.parseInt(idField.getText()));
			}
			hocVien.setHoTen(nameField.getText().trim());
			hocVien.setTuoi(Byte.parseByte(ageField.getText().trim()));
                        hocVien.setkieuhinh(kieuhinhField.getText().trim());
                        hocVien.setdate(dateField.getText().trim());
			hocVien.setDiaChi(addressTA.getText().trim());
//			hocVien.setGpa(Float.parseFloat(gpaField.getText().trim()));
			return hocVien;
		} catch (Exception e) {
			showMessage(e.getMessage());
		}
		return null;
	}

	private boolean validateName() {
		String name = nameField.getText();
		if (name == null || "".equals(name.trim())) {
			nameField.requestFocus();
			showMessage("Name không được trống.");
			return false;
		}
		return true;
	}
        private boolean validatekieuhinh() {
		String kieuhinh = kieuhinhField.getText();
		if (kieuhinh == null || "".equals(kieuhinh.trim())) {
			kieuhinhField.requestFocus();
			showMessage("Kiểu hình không được trống.");
			return false;
		}
		return true;
	}

	private boolean validateAddress() {
		String address = addressTA.getText();
		if (address == null || "".equals(address.trim())) {
			addressTA.requestFocus();
			showMessage("Address không được trống.");
			return false;
		}
		return true;
	}

	private boolean validateAge() {
		try {
			Byte age = Byte.parseByte(ageField.getText().trim());
			if (age < 0 || age > 100) {
				ageField.requestFocus();
				showMessage("Tuổi không hợp lệ, age nên trong khoảng 0 đến 100.");
				return false;
			}
		} catch (Exception e) {
			ageField.requestFocus();
			showMessage("Tuổi không hợp lệ!");
			return false;
		}
		return true;
	}

//	private boolean validateGPA() {
//		try {
//			Float gpa = Float.parseFloat(gpaField.getText().trim());
//			if (gpa < 0 || gpa > 10) {
//				gpaField.requestFocus();
//				showMessage("GPA không hợp lệ, gpa nên trong khoảng 0 đến 10.");
//				return false;
//			}
//		} catch (Exception e) {
//			gpaField.requestFocus();
//			showMessage("GPA không hợp lệ!");
//			return false;
//		}
//		return true;
//	}

	public void actionPerformed(ActionEvent e) {
	}

	public void valueChanged(ListSelectionEvent e) {
	}

	public void addAddStudentListener(ActionListener listener) {
		addStudentBtn.addActionListener(listener);
	}

	public void addEdiStudentListener(ActionListener listener) {
		editStudentBtn.addActionListener(listener);
	}

	public void addDeleteStudentListener(ActionListener listener) {
		deleteStudentBtn.addActionListener(listener);
	}

	public void addClearListener(ActionListener listener) {
		clearBtn.addActionListener(listener);
	}

//	public void addSortStudentGPAListener(ActionListener listener) {
//		sortStudentGPABtn.addActionListener(listener);
//	}

	public void addSortStudentNameListener(ActionListener listener) {
		sortStudentNameBtn.addActionListener(listener);
	}

	public void addListStudentSelectionListener(ListSelectionListener listener) {
		studentTable.getSelectionModel().addListSelectionListener(listener);
	}

	public String getSearchQuery() {
		return searchField.getText().trim();
	}

	public void addSearchListener(ActionListener listener) {
		searchBtn.addActionListener(listener);
	}

    private boolean validatedatedate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
