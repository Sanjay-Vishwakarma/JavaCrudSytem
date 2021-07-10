package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.Color;

public class StudentForm {

	private JFrame frame;
	private JTextField tname;
	private JTextField temail;
	private JTextField tnumber;
	private JTextField taddress;
	private JTextField tpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm window = new StudentForm();
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
	// driver

	public StudentForm() {
		initialize();
		Conn();

	}

	// Connection
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public void Conn() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3309/crud", "root", "");

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 401, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel.setBounds(25, 52, 70, 24);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email-ID");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblEmail.setBounds(25, 104, 70, 24);
		frame.getContentPane().add(lblEmail);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(25, 154, 110, 24);
		frame.getContentPane().add(lblPhoneNumber);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(25, 206, 70, 24);
		frame.getContentPane().add(lblAddress);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(25, 257, 70, 24);
		frame.getContentPane().add(lblPassword);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSubmit.setBounds(25, 310, 100, 24);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name, email, number, address, pass;
				name = tname.getText();
				email = temail.getText();
				number = tnumber.getText();
				address = taddress.getText();
				pass = tpass.getText();

				try {

					pst = con.prepareStatement("insert into tbcrud (name,email,number,address,pass)values (?,?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, email);
					pst.setString(3, number);
					pst.setString(4, address);
					pst.setString(5, pass);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record added sucessfully ....!!!");

					// to be blank all the data
					tname.setText("");
					temail.setText("");
					tnumber.setText("");
					taddress.setText("");
					tpass.setText("");
					tname.requestFocus();

				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});

		tname = new JTextField();
		tname.setBounds(171, 54, 165, 32);
		frame.getContentPane().add(tname);
		tname.setColumns(10);

		temail = new JTextField();
		temail.setColumns(10);
		temail.setBounds(171, 102, 165, 32);
		frame.getContentPane().add(temail);

		tnumber = new JTextField();
		tnumber.setColumns(10);
		tnumber.setBounds(171, 152, 165, 32);
		frame.getContentPane().add(tnumber);

		taddress = new JTextField();
		taddress.setColumns(10);
		taddress.setBounds(171, 204, 165, 32);
		frame.getContentPane().add(taddress);

		tpass = new JTextField();
		tpass.setColumns(10);
		tpass.setBounds(171, 255, 165, 32);
		frame.getContentPane().add(tpass);

		JButton btnNewButton = new JButton("AdminLogin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == btnNewButton) {
					frame.setVisible(false);
					new Admin().setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(264, 11, 100, 32);
		frame.getContentPane().add(btnNewButton);
		frame.setTitle("Student Form");
		frame.setLocation(400, 200);

	}
}
