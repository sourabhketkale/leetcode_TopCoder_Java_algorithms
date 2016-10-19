package com.problems.miscellaneous;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindTheImageFileInAdirectory {

	private List<String> result = new ArrayList<String>();

	public void searchDirectory(File directory) {

		if (directory.isDirectory()) {
			searchImageFiles(directory);
		} else {
			System.out.println(directory.getAbsoluteFile() + " is not a directory!");
		}

	}

	private void searchImageFiles(File file) {

		if (file.isDirectory()) {
			// Permissions check
			if (file.canRead()) {
				for (File temp : file.listFiles()) {

					if (temp.isDirectory()) {
						searchImageFiles(temp);
					} else {
						if (temp.toString().contains(".png") || temp.toString().contains(".gif")
								|| temp.toString().contains(".jpg")) {

							result.add(temp.getAbsoluteFile().toString());
						}
					}
				}

			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}

	}

	public static void main(String[] args) {

		FindTheImageFileInAdirectory imageSearchObject = new FindTheImageFileInAdirectory();
		String directoryName = "C:\\CamsEye";
		imageSearchObject.searchDirectory(new File(directoryName));

		int count = imageSearchObject.result.size();
		if (count == 0) {
			System.out.println("\nNo result found!");
		} else {
			for (String imageFileFound : imageSearchObject.result) {
				System.out.println(imageFileFound);
			}
		}
	}

}
