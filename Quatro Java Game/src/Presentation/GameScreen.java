package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Process.TaskPlaatsZet;
//Frank
public class GameScreen extends JFrame {
	
	private JPanel speelStukkenContainer;

	public GameScreen() {
		
		TaskPlaatsZet plaatsZet = new TaskPlaatsZet();
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("Quarto");
		this.setBackground(Color.BLUE);
		this.setSize(1024, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpeelBord speelbord = new SpeelBord(plaatsZet);
		SpeelStukkenContainer speelStukkenContainer = new SpeelStukkenContainer(plaatsZet);
		GameMenu menu1 = new GameMenu(this, speelStukkenContainer, plaatsZet, speelbord);
		this.add(menu1, BorderLayout.SOUTH);
		this.add(speelStukkenContainer, BorderLayout.EAST);
		this.add(speelbord, BorderLayout.CENTER);

		this.setVisible(true);
	}
		
}
