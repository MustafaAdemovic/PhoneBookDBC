package com.bicamp.mustafaademovic.view;


import java.awt.Container;

import javax.swing.JFrame;

public class Main {

	private static JFrame window = null;
	protected static int windowWidth = 400;
	protected static int windowHeigth = 500;

	public static void init() {
		window = new JFrame("BitBook");
		window.setSize(windowWidth, windowHeigth);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	}

	protected static void setVisible() {
		window.validate();
		window.repaint();
		window.setVisible(true);
	}

	protected static void replaceContent(Container panel) {

		// TODO izbrisati stari panel
		window.setContentPane(panel);
		setVisible();
	}
}
