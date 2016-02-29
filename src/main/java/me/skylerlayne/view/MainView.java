package me.skylerlayne.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import me.skylerlayne.view.listeners.NewActionListener;
import me.skylerlayne.view.listeners.SaveAsActionListener;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 * 
 * Skyler Layne © Feb 28, 2016
 *
 * @version 0.0.1
 */
public class MainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		frame.setJMenuBar(menuBar);

		JTextPane textPane = new JTextPane();
		frame.getContentPane().add(textPane, BorderLayout.CENTER);

		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		mntmNew.addActionListener(new NewActionListener());

		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mnFile.add(mntmSaveAs);
		mntmSaveAs.addActionListener(new SaveAsActionListener(mntmSave, textPane));

		JMenuItem mntmExportLatex = new JMenuItem("Export");
		mnFile.add(mntmExportLatex);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnEdit);

		JMenuItem mntmNewMenuItem = new JMenuItem("Plain Text");
		mnEdit.add(mntmNewMenuItem);

		JMenuItem mntmMarkdown = new JMenuItem("Markdown");
		mnEdit.add(mntmMarkdown);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnHelp);

		JMenuItem mntmShowHelp = new JMenuItem("Show Help");
		mnHelp.add(mntmShowHelp);

	}

}
