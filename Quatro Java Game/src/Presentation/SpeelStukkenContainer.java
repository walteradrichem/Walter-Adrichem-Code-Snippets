package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Business.Speelstuk;
import Business.Speelstukken;
import Process.TaskPlaatsZet;
// Frank
public class SpeelStukkenContainer extends JPanel {
	
	public Speelstuk speelstuk1, speelstuk2, speelstuk3, speelstuk4, speelstuk5, speelstuk6, speelstuk7, speelstuk8, speelstuk9, speelstuk10, speelstuk11, speelstuk12, speelstuk13, speelstuk14, speelstuk15, speelstuk16;
	private Speelstukken stukken;	
	private MouseListener task;
	
	public SpeelStukkenContainer(MouseListener task) {
		stukken = new Speelstukken();
		setLayout(new GridLayout(8,2));
		this.task = task;
		
		speelstuk1 = new Speelstuk(false, true, true, false, 16, "images/RedLargeFilledSquare.png");
		speelstuk2 = new Speelstuk(true, true, true, false, 16, "images/BlackLargeFilledSquare.png");
		speelstuk3 = new Speelstuk(false, true, true, true, 16, "images/RedLargeFilledCircle.png");
		speelstuk4 = new Speelstuk(true, true, true, true, 16, "images/BlackLargeFilledCircle.png");
		speelstuk5 = new Speelstuk(false, true, false, false, 16, "images/RedLargeEmptySquare.png");
		speelstuk6 = new Speelstuk(true, true, false, false, 16, "images/BlackLargeEmptySquare.png");
		speelstuk7 = new Speelstuk(false, true, false, true, 16, "images/RedLargeEmptyCircle.png");
		speelstuk8 = new Speelstuk(true, true, false, true, 16, "images/BlackLargeEmptyCircle.png");

		speelstuk9 = new Speelstuk(false, false, true, false, 16, "images/RedSmallFilledSquare.png");
		speelstuk10 = new Speelstuk(true, false, true, false, 16, "images/BlackSmallFilledSquare.png");
		speelstuk11 = new Speelstuk(false, false, true, true, 16, "images/RedSmallFilledCircle.png");
		speelstuk12 = new Speelstuk(true, false, true, true, 16, "images/BlackSmallFilledCircle.png");
		speelstuk13 = new Speelstuk(false, false, false, false, 16, "images/RedSmallEmptySquare.png");
		speelstuk14 = new Speelstuk(true, false, false, false, 16, "images/BlackSmallEmptySquare.png");
		speelstuk15 = new Speelstuk(false, false, false, true, 16, "images/RedSmallEmptyCircle.png");
		speelstuk16 = new Speelstuk(true, false, false, true, 16, "images/BlackSmallEmptyCircle.png");
		
		stukken.add(speelstuk1);
		stukken.add(speelstuk2);
		stukken.add(speelstuk3);
		stukken.add(speelstuk4);
		stukken.add(speelstuk5);
		stukken.add(speelstuk6);
		stukken.add(speelstuk7);
		stukken.add(speelstuk8);
		stukken.add(speelstuk9);
		stukken.add(speelstuk10);
		stukken.add(speelstuk11);
		stukken.add(speelstuk12);
		stukken.add(speelstuk13);
		stukken.add(speelstuk14);
		stukken.add(speelstuk15);
		stukken.add(speelstuk16);
		
		speelstuk1.addMouseListener(task);
		speelstuk2.addMouseListener(task);
		speelstuk3.addMouseListener(task);
		speelstuk4.addMouseListener(task);
		speelstuk5.addMouseListener(task);
		speelstuk6.addMouseListener(task);
		speelstuk7.addMouseListener(task);
		speelstuk8.addMouseListener(task);
		speelstuk9.addMouseListener(task);
		speelstuk10.addMouseListener(task);
		speelstuk11.addMouseListener(task);
		speelstuk12.addMouseListener(task);
		speelstuk13.addMouseListener(task);
		speelstuk14.addMouseListener(task);
		speelstuk15.addMouseListener(task);
		speelstuk16.addMouseListener(task);
		
		add(speelstuk1);
		add(speelstuk2);
		add(speelstuk3);
		add(speelstuk4);
		add(speelstuk5);
		add(speelstuk6);
		add(speelstuk7);
		add(speelstuk8);
		add(speelstuk9);
		add(speelstuk10);
		add(speelstuk11);
		add(speelstuk12);
		add(speelstuk13);
		add(speelstuk14);
		add(speelstuk15);
		add(speelstuk16);
				
	}
	
	public void emptyContainer(){
		remove(speelstuk1);
		remove(speelstuk2);
		remove(speelstuk3);
		remove(speelstuk4);
		remove(speelstuk5);
		remove(speelstuk6);
		remove(speelstuk7);
		remove(speelstuk8);
		remove(speelstuk9);
		remove(speelstuk10);
		remove(speelstuk11);
		remove(speelstuk12);
		remove(speelstuk13);
		remove(speelstuk14);
		remove(speelstuk15);
		remove(speelstuk16);
		
		speelstuk1.removeSpeelstuk();
		speelstuk2.removeSpeelstuk();
		speelstuk3.removeSpeelstuk();
		speelstuk4.removeSpeelstuk();
		speelstuk5.removeSpeelstuk();
		speelstuk6.removeSpeelstuk();
		speelstuk7.removeSpeelstuk();
		speelstuk8.removeSpeelstuk();
		speelstuk9.removeSpeelstuk();
		speelstuk10.removeSpeelstuk();
		speelstuk11.removeSpeelstuk();
		speelstuk12.removeSpeelstuk();
		speelstuk13.removeSpeelstuk();
		speelstuk14.removeSpeelstuk();
		speelstuk15.removeSpeelstuk();
		speelstuk16.removeSpeelstuk();
		this.setVisible(false);
		
	}
	
	public SpeelStukkenContainer(GameScreen gs, MouseListener task, Speelstukken s, SpeelBord speelbord){
		setLayout(new GridLayout(8,2));
		this.task = task;
		this.stukken = s;
		for (Speelstuk speelstuk : s) {
			
			if(speelstuk.location == 16){
				speelstuk.addIcon(speelstuk.path);
				speelstuk.addMouseListener(task);
				
				this.add(speelstuk);
			}else{
				speelbord.fillBord(speelstuk);
				this.add(new JLabel());
			}
		}
		repaint();
	}
	
	public Speelstukken getStukken() {
		return stukken;
	}
}
