package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Admin extends JFrame  {
	JLabel l1, l2, l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b3;

	Admin() {

		setTitle("Admin Login");
		setSize(600, 480);
		setLocation(350, 150);
		setVisible(true);
		setLayout(null);

		l1 = new JLabel("ADMIN LOGIN");
		l1.setFont(new Font("Osward", Font.BOLD, 30));
		l1.setBounds(180, 40, 450, 40);
		add(l1);

		l2 = new JLabel("USERNAME");
		l2.setFont(new Font("Arial", Font.BOLD, 18));
		l2.setBounds(100, 150, 500, 40);
		add(l2);

		tf1 = new JTextField(15);
		tf1.setBounds(300, 150, 230, 30);
		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		add(tf1);

		l3 = new JLabel("PASSWORD");
		l3.setFont(new Font("Arial", Font.BOLD, 18));
		l3.setBounds(100, 220, 500, 40);
		add(l3);

		pf2 = new JPasswordField(15);
		pf2.setFont(new Font("Arial", Font.BOLD, 14));
		pf2.setBounds(300, 220, 230, 30);
		add(pf2);

		b3 = new JButton("LOGIN");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);

		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.setBounds(300, 350, 230, 30);
		add(b3);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new View().setVisible(true);
				
				
			}
		});

	}

	// Driver
	public static void main(String[] args) {

		Admin ad = new Admin();
	}

}
