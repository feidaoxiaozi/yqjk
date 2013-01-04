package net.dbet.deletefiles;

import java.io.File;
import java.io.FileFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DeleteFilesServlet extends HttpServlet {

	public DeleteFilesServlet() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void init() throws ServletException {

		// File file = new File(".");
		//
		// File[] filePath = file.listFiles();
		//
		// for (File f : filePath) {
		//
		// if (f.getName().endsWith("xls")) {
		//
		// file.delete();
		//
		// }
		// }
		File file = new File(".");

		File[] filePath = file.listFiles(new FileFilter() {

			public boolean accept(File pathname) {

				if (pathname.getName().endsWith("xls")) {

					return true;
				}
				return false;
			}
		});
		for (File f : filePath) {
			file.delete();
		}
	}
}
