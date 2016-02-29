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

import me.skylerlayne.model.FileContent;

/**
 * `OpenActionListener`, listener attached to the `Open` menu bar event.
 * 
 * @author Skyler Layne © Feb 29, 2016
 *
 * @version 0.0.1
 */
public class OpenActionListener implements ActionListener {

	private final static Logger LOGGER = Logger.getLogger(SaveAsActionListener.class.getName());
	private Component component;
	private JTextPane pane;

	/**
	 * 
	 * @param component
	 */
	public OpenActionListener(Component component, JTextPane pane) {
		this.setComponent(component);
		this.setPane(pane);
	}

	/**
	 * Span a new open dialog {@link JFileChooser}, setting the contents of the
	 * JEditorPane to the contents of the file.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(getComponent());

		/*
		 * Check if the File Chooser was approved, if so write the contents to
		 * the file.
		 */
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			FileContent content = new FileContent(file);
			getPane().setText(content.getAll());
			LOGGER.log(Level.INFO, "File " + file.getAbsolutePath() + " opened.");
		} else {
			LOGGER.log(Level.INFO, "File Open Dialog Closed");
		}

	}

	/**
	 * Get the component the listener is attached to.
	 * 
	 * @return - the component.
	 */
	public Component getComponent() {
		return component;
	}

	/**
	 * Set the component the listener is attached to.
	 * 
	 * @param component
	 *            - the new component.
	 */
	public void setComponent(Component component) {
		this.component = component;
	}

	private void setPane(JTextPane pane) {
		this.pane = pane;
	}

	private JTextPane getPane() {
		return this.pane;
	}

}
