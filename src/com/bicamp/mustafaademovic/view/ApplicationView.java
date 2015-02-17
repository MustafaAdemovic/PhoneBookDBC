package com.bicamp.mustafaademovic.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;

import com.bicamp.mustafaademovic.controller.ApplicationController;
import com.bicamp.mustafaademovic.model.Contact;

/**
 * Ovdje smo extendali klasu Main da bi mogli koristiti metode iz te klase
 * 
 * @author mustafaademovic
 *
 */
public class ApplicationView extends Main {

	public static void home() {

		JPanel panel = new JPanel();
		JLabel lable = new JLabel("Wellcome to BitBook");
		Font lableFont = new Font("SansSerif", Font.BOLD, 30);

		lable.setFont(lableFont);
		panel.add(lable);

		JButton button2 = new JButton("Show Contacts");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.list();
			}
		});

		JButton button1 = new JButton("Add Contact");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.addContact();

			}
		});

		panel.add(button2);
		panel.add(button1);

		Main.replaceContent(panel);
	}
	
	public static void addContact() {

		JPanel panel = new JPanel();
		JLabel name = new JLabel("Name:");
		JLabel surname = new JLabel("Surname:");
		JLabel number = new JLabel("Number:");

		final JTextField textname = new JTextField();
		final JTextField textsurname = new JTextField();
		final JTextField textnumber = new JTextField();

		Font lableFont = new Font("SansSerif", Font.BOLD, 15);
		Font lableFont2 = new Font("SansSerif", Font.BOLD, 10);

		name.setFont(lableFont);
		surname.setFont(lableFont);
		number.setFont(lableFont);

		name.setPreferredSize(new Dimension(350, 50));
		textname.setPreferredSize(new Dimension(350, 40));
		surname.setPreferredSize(new Dimension(350, 50));
		textsurname.setPreferredSize(new Dimension(350, 40));
		number.setPreferredSize(new Dimension(350, 50));
		textnumber.setPreferredSize(new Dimension(350, 40));

		panel.add(name);
		panel.add(textname);
		panel.add(surname);
		panel.add(textsurname);
		panel.add(number);
		panel.add(textnumber);

		JButton button1 = new JButton("Save");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cName = textname.getText();
				String cSurname = textsurname.getText();
				String cNumber = textnumber.getText();
				ApplicationController.create(cName, cSurname, cNumber);
			}
		});

		JButton button2 = new JButton("Exit");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.home();

			}
		});

		button1.setFont(lableFont2);
		button2.setFont(lableFont2);
		button1.setPreferredSize(new Dimension(100, 50));
		button2.setPreferredSize(new Dimension(100, 50));

		panel.add(button1);
		panel.add(button2);

		Main.replaceContent(panel);

	}
	
	public static void list(Contact[] all) {
		int buttonHeight = 50;
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(ApplicationView.windowWidth -75, all.length * (buttonHeight + 20)));
		if(all.length < 1) {
		JLabel lable = new JLabel("Welcome to BitBook");
		Font lableFont = new Font("SansSerif", Font.BOLD, 30);
		lable.setFont(lableFont);
		content.add(lable);
		}
		
		JButton button1 = new JButton("Add Contact");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JPanel panel = new JPanel();
				JLabel name = new JLabel("Name:");
				JLabel surname = new JLabel("Surname:");
				JLabel number = new JLabel("Number:");

				final JTextField textname = new JTextField();
				final JTextField textsurname = new JTextField();
				final JTextField textnumber = new JTextField();

				Font lableFont = new Font("SansSerif", Font.BOLD, 15);
				Font lableFont2 = new Font("SansSerif", Font.BOLD, 10);

				name.setFont(lableFont);
				surname.setFont(lableFont);
				number.setFont(lableFont);

				name.setPreferredSize(new Dimension(350, 50));
				textname.setPreferredSize(new Dimension(350, 40));
				surname.setPreferredSize(new Dimension(350, 50));
				textsurname.setPreferredSize(new Dimension(350, 40));
				number.setPreferredSize(new Dimension(350, 50));
				textnumber.setPreferredSize(new Dimension(350, 40));

				panel.add(name);
				panel.add(textname);
				panel.add(surname);
				panel.add(textsurname);
				panel.add(number);
				panel.add(textnumber);

				JButton button1 = new JButton("Save");
				button1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String cName = textname.getText();
						String cSurname = textsurname.getText();
						String cNumber = textnumber.getText();
						ApplicationController.create(cName, cSurname, cNumber);
					}
				});

				JButton button2 = new JButton("Exit");
				button2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ApplicationController.home();

					}
				});

				button1.setFont(lableFont2);
				button2.setFont(lableFont2);
				button1.setPreferredSize(new Dimension(100, 50));
				button2.setPreferredSize(new Dimension(100, 50));

				panel.add(button1);
				panel.add(button2);
				Main.replaceContent(panel);
			}
		});
		
		JButton button2 = new JButton("Exit");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.home();

			}
		});
		button1.setPreferredSize(new Dimension(100, 50));
		content.add(button1);
		button2.setPreferredSize(new Dimension(100, 50));
		content.add(button2);
		
		
		
		for (int i = 0; i < all.length; i++) {
			JButton current = new JButton(all[i].getDisplayName());
			current.setName(Integer.toString(all[i].getId()));
			current.setPreferredSize(new Dimension(
					ApplicationView.windowWidth - 75, buttonHeight));
			current.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					JButton clicked = (JButton) (e.getSource());
					int id = Integer.parseInt(clicked.getName());
					System.out.println("Korisnik " + id);
				}
			});

			content.add(current);
		}
		JScrollPane sp = new JScrollPane(content);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		replaceContent(sp);
	}

}
