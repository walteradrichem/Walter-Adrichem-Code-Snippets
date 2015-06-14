package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Business.Speler;
import Process.TaskInzienSpelregels;
import Process.TaskSpelLaden;
import Process.TaskStartSpel;
// Gerben

public class Hoofdmenu extends JFrame {
	private JPanel container;
	
	private JLabel speler1Lbl, speler2Lbl;
	private JButton spelStarten, spelRegels;
	private JTextField speler1,speler2;
	private JLabel spelHeader;
	
	private ImageIcon plaatje = new ImageIcon("images/logo.png");
	
	
	
	public Hoofdmenu(ActionListener task) {
		TaskInzienSpelregels spelregelsInzien = new TaskInzienSpelregels();
		TaskStartSpel startSpel = new TaskStartSpel();

		container = new JPanel();
				
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		spelStarten = new JButton("Spel starten");
		spelRegels = new JButton("Spelregels");

		speler1 = new JTextField(15);
		speler2 = new JTextField(15);
		
		speler1Lbl = new JLabel("Speler 1");
		speler2Lbl = new JLabel("Speler 2");
		spelHeader = new JLabel();
		
		spelHeader.setIcon(plaatje);
		
		spelStarten.addActionListener(startSpel);
		spelRegels.addActionListener(spelregelsInzien);
		
		container.add(spelHeader);
		
		container.add(speler1Lbl);
		container.add(speler1);

		container.add(speler2Lbl);
		container.add(speler2);

		container.add(spelStarten);
		container.add(spelRegels);
		container.setVisible(true);
		
		this.add(container);
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.setTitle("Quarto");
		this.setSize(1024, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


}
