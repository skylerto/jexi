package me.skylerlayne.view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import me.skylerlayne.view.MainView;

/**
 * 
 * @author skyler layne
 *
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
