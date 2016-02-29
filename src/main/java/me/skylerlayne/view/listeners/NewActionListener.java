package me.skylerlayne.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.skylerlayne.view.MainView;

/**
 * 
 * Skyler Layne © Feb 29, 2016
 *
 * @version 0.0.1
 */
public class NewActionListener implements ActionListener {

	/**
	 * Perform the New operation.
	 * 
	 * Create a new instance of the app?
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MainView mv = new MainView();
		mv.main(null);
	}

}
