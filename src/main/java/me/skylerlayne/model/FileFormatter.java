package me.skylerlayne.model;

import java.io.File;

/**
 * File formatter helper, converts file names.
 * 
 * Skyler Layne © Feb 28, 2016
 *
 * @version 0.0.1
 */
public class FileFormatter {

	private String name;
	private String extention;
	private File file;
	private String path;

	/**
	 * Default constructor.
	 */
	public FileFormatter() {

	}

	/**
	 * Constructor which takes a file as input.
	 * 
	 * @param file
	 *            - the desired file to format.
	 */
	public FileFormatter(File file) {
		this(file.getName());
		this.setFile(file);
		this.path = file.getParent();

	}

	/**
	 * Constructor with a fill filename.
	 * 
	 * @param fullname
	 *            - the name of the file.
	 */
	public FileFormatter(String fullname) {

		String fileExtention = fullname.substring(fullname.lastIndexOf("."), fullname.length());
		this.extention = fileExtention;
		name = fullname.substring(0, fullname.lastIndexOf("."));
		this.name = name;

	}

	/**
	 * Constructor where the file is already seperated into name and extension.
	 * 
	 * @param name
	 *            - the name of the file without the extension.
	 * @param extention
	 *            - the extension of the file.
	 */
	public FileFormatter(String name, String extention) {
		this.name = name;
		this.extention = extention;
	}

	/**
	 * Convert the file name into markdown.
	 * 
	 * @return - a full file name with the `.md` extension.
	 */
	public String markdown() {
		setExtention(".md");
		return getFullName();
	}

	/**
	 * Get the full name of the file.
	 * 
	 * @return - the full name.
	 */
	public String getFullName() {
		return getName() + getExtention();
	}

	/**
	 * The files extension.
	 * 
	 * @return - the extension.
	 */
	private String getExtention() {
		return this.extention;
	}

	/**
	 * Change the file extension.
	 * 
	 * @param extention
	 *            - the new extension.
	 */
	public void setExtention(String extention) {
		this.extention = extention;
	}

	/**
	 * Get the name of the file without the extention.
	 * 
	 * @return - the file name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Change the name of the file.
	 * 
	 * @param name
	 *            - new file name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Change the files extension to markdown.
	 * 
	 * @return - the full name of the file.
	 */
	public String formatMarkdown() {
		String name;
		if (getExtention().equals(".md")) {
			name = getFullName();
		} else {
			name = markdown();
		}
		return name;
	}

	/**
	 * Get a file with a confirmed markdown extension.
	 * 
	 * @return - a new file.
	 */
	public File getMarkdownFile() {
		String filename = formatMarkdown();
		if (this.path != "" || this.path != null) {
			filename = this.path + "/" + filename;
		} else {

		}
		return new File(filename);

	}

	/**
	 * Get the file.
	 * 
	 * @return - get the file.
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Set the file nam.
	 * 
	 * @param file
	 *            - the new file name.
	 */
	public void setFile(File file) {
		this.file = file;
	}
}
