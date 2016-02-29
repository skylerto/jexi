package me.skylerlayne.view.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;

import me.skylerlayne.model.FileFormatter;

/**
 * 
 * Skyler Layne © Feb 28, 2016
 *
 * @version 0.0.1
 */
public class SaveAsActionListener implements ActionListener {

	private final static Logger LOGGER = Logger.getLogger(SaveAsActionListener.class.getName());
	private Component component;
	private JTextPane pane;

	public SaveAsActionListener(Component component, JTextPane pane) {
		this.component = component;
		this.pane = pane;
	}

	/**
	 * Pop a JFileChooser to determine file path, dump the contents from the
	 * JTextPane into the file.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(this.getComponent());

		/*
		 * Check if the File Chooser was approved, if so write the contents to
		 * the file.
		 */
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			FileFormatter fm = new FileFormatter(file);
			file = fm.getMarkdownFile();
			
			
//			String filename = file.getName();
//			System.out.println(filename);
//			String fileExtention = filename.substring(filename.lastIndexOf("."), filename.length());
//			System.out.println(fileExtention);
//			filename = filename.substring(0, filename.lastIndexOf("."));
//			System.out.println(filename);
//			if (!fileExtention.equals(".md")) {
//				file = new File(filename + ".md");
//			}

			try {
				FileWriter writer = new FileWriter(file);
				String contents = validate(this.getContents());
				writer.append(contents);
				writer.close();
				LOGGER.log(Level.INFO, "File Saved to: " + file.getAbsolutePath());
			} catch (IOException e1) {
				LOGGER.log(Level.SEVERE, "Cannot write to file!", e1);
			}
		} else {
			LOGGER.log(Level.INFO, "File Save Dialog Closed");
		}

	}

	/**
	 * Validate the contents of the file.
	 * 
	 * @param contents
	 *            - the file contents.
	 * @return - the validated file contents.
	 */
	private String validate(String contents) {

		return contents;
	}

	/**
	 * Get the contents of the file to be saved.
	 * 
	 * @return - the contents of the file.
	 */
	private String getContents() {
		return this.pane.getText();
	}

	/**
	 * Get the name of the component created with.
	 * 
	 * @return - the component.
	 */
	private Component getComponent() {
		return this.component;
	}

}
