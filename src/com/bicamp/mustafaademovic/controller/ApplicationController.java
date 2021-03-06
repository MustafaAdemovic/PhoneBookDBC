package com.bicamp.mustafaademovic.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.bicamp.mustafaademovic.model.*;
import com.bicamp.mustafaademovic.view.*;
/**
 * Komentar
 * @author mustafa
 *
 */
public class ApplicationController {

	public static void home() {
		/* Prikaz Home Gui */
				
		ApplicationView.home();
	}
	
	
	public static void addContact() {
		
		ApplicationView.addContact();
	}
	
	
	public static void create(String name, String surname, String number) {
		
		Contact newContact = new Contact(name, surname, number);
		if(newContact.save() == true) {
			//TODO redirect to contact info
			home();
			JOptionPane.showMessageDialog(null, "Successfuly saved " + newContact.getName(), "Contact added", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "There has been a mistake", "Error saving Contacts", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void list() {
		Contact[] all = Contact.all();
		ApplicationView.list(all);
	}
	public static void main(String[] args) {

		/*TODO povezivanje s bazom */
		try {
			
			Application.init();
			
		} catch (SQLException e) {
		
			System.err.println(e.getMessage());
			
			System.exit(1);
		}
		
		Main.init();
		
		home();
		

	}

}
