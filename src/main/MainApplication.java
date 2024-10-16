package main;


import java.awt.EventQueue;

import controller.DangNhapController;
import view.DangNhapView;

public class MainApplication {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DangNhapView view = new DangNhapView();
				DangNhapController controller = new DangNhapController(view);
				controller.showLoginView();
			}
		});
	}

}
