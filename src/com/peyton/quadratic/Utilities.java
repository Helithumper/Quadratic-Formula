package com.peyton.quadratic;

/**
 * This is a utilities class made for many
 * projects that contains many common
 * methods and constants
 * @Author Peyton Duncan
 * @version 1.0.0
 */

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utilities {

	/**
	 * @param Message
	 *            that you want to display in the error window
	 * @param Title
	 *            of the Error Windowlkas
	 */
	public static void throwErrorBox(String message, String title) {
		JOptionPane.showMessageDialog(new JFrame(), message, title,
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Main font for most texts
	 */
	public static final Font TEXT_FONT = new Font("Serif", Font.BOLD, 16);

}
