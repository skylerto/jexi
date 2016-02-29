package me.skylerlayne.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * @author Skyler Layne © Feb 29, 2016
 *
 * @version 0.0.1
 */
public class FileContent {

	private File file;
	private FileReader fileReader;
	private BufferedReader reader;

	/**
	 * Constructors a FileContent object with a desired file.
	 * 
	 * @param file
	 */
	public FileContent(File file) {
		this.setFile(file);
		try {
			this.setFileReader(new FileReader(this.getFile()));
			this.reader = new BufferedReader(this.getFileReader());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public String getAll() {
		StringBuilder contents = new StringBuilder();
		contents.append("");
		this.getReader().lines().forEach(e -> {
			contents.append(e + "\n");
		});
		return contents.toString();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public BufferedReader getReader() {
		return this.reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

}
