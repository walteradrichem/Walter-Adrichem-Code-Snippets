package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;





import Business.Speelstuk;
import Business.Veld;
import Process.TaskPlaatsZet;
// Gerben
public class SpeelBord extends JPanel  {
		
	public Veld veld1, veld2, veld3, veld4, veld5, veld6, veld7, veld8, veld9, veld10, veld11, veld12, veld13, veld14, veld15, veld16;
	
	public SpeelBord(MouseListener task){
		setLayout(new GridLayout(4,4));
		
		veld1 = new Veld(task, 0);
		veld2 = new Veld(task, 1);
		veld3 = new Veld(task, 2);
		veld4 = new Veld(task, 3);
		veld5 = new Veld(task, 4);
		veld6 = new Veld(task, 5);
		veld7 = new Veld(task, 6);
		veld8 = new Veld(task, 7);
		veld9 = new Veld(task, 8);
		veld10 = new Veld(task, 9);
		veld11 = new Veld(task, 10);
		veld12 = new Veld(task, 11);
		veld13 = new Veld(task, 12);
		veld14 = new Veld(task, 13);
		veld15 = new Veld(task, 14);
		veld16 = new Veld(task, 15);
		
		this.add(veld1);
		this.add(veld2);
		this.add(veld3);
		this.add(veld4);
		this.add(veld5);
		this.add(veld6);
		this.add(veld7);
		this.add(veld8);
		this.add(veld9);
		this.add(veld10);
		this.add(veld11);
		this.add(veld12);
		this.add(veld13);
		this.add(veld14);
		this.add(veld15);
		this.add(veld16);

		
		this.setVisible(true);
	}
	
	public void clearVeld(){
		this.veld1.removeSpeelstukFromVeld();
		this.veld2.removeSpeelstukFromVeld();
		this.veld3.removeSpeelstukFromVeld();
		this.veld4.removeSpeelstukFromVeld();
		this.veld5.removeSpeelstukFromVeld();
		this.veld6.removeSpeelstukFromVeld();
		this.veld7.removeSpeelstukFromVeld();
		this.veld8.removeSpeelstukFromVeld();
		this.veld9.removeSpeelstukFromVeld();
		this.veld10.removeSpeelstukFromVeld();
		this.veld11.removeSpeelstukFromVeld();
		this.veld12.removeSpeelstukFromVeld();
		this.veld13.removeSpeelstukFromVeld();
		this.veld14.removeSpeelstukFromVeld();
		this.veld15.removeSpeelstukFromVeld();
		this.veld16.removeSpeelstukFromVeld();
	}
	
	public void fillBord(Speelstuk s){
			if(s.location >= 0 && s.location <= 15){
				switch (s.location) 
				{
					case 0: 
						this.veld1.setIcon(new ImageIcon(s.path));
						this.veld1.addSpeelstukToVeld(s);
						this.veld1.setVisible(true);
						TaskPlaatsZet.values[0][0] = s.getTypeOfStuk();
			        break;
					
					case 1: 
						
						veld2.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[0][1] = s.getTypeOfStuk();
			        break;
					
					case 2: 		
						
						veld3.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[0][2] = s.getTypeOfStuk();
			        break;
					
					case 3:  
						
						veld4.addSpeelstukToVeld(s);	
						TaskPlaatsZet.values[0][3] = s.getTypeOfStuk();
			        break;
					
					case 4: 
						 
						veld5.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[1][0] = s.getTypeOfStuk();
			        break;
					
					case 5: 
						
						veld6.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[1][1] = s.getTypeOfStuk();
			        break;
					
					case 6:  
						
						veld7.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[1][2] = s.getTypeOfStuk();
			        break;
					
					case 7:  
						
						veld8.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[1][3] = s.getTypeOfStuk();
			        break;
					
					case 8:  
						
						veld9.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[2][0] = s.getTypeOfStuk();
			        break;
					
					case 9:  
						
						veld10.addSpeelstukToVeld(s);					
						TaskPlaatsZet.values[2][1] = s.getTypeOfStuk();
			        break;
					
					case 10:
						
						veld11.addSpeelstukToVeld(s);	
						TaskPlaatsZet.values[2][2] = s.getTypeOfStuk();
			        break;
					
					case 11: 
						
						veld12.addSpeelstukToVeld(s);		
						TaskPlaatsZet.values[2][3] = s.getTypeOfStuk();
			        break;
					
					case 12:  
						
						veld13.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[3][0] = s.getTypeOfStuk();
			        break;
					
					case 13:
						
						veld14.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[3][1] = s.getTypeOfStuk();
			        break;
					
					case 14:
						
						veld15.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[3][2] = s.getTypeOfStuk();
					break;
					
					case 15:
						
						veld16.addSpeelstukToVeld(s);
						TaskPlaatsZet.values[3][3] = s.getTypeOfStuk();
			        break;
					
					default: ;
			       
					break;
				}
			} 
			else 
			{
				System.out.println("DIT STUK IS NIET OP HET BORD GEPLAATST!");
				
			}
		}
}
