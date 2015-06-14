package Presentation;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Process.TaskInzienSpelregels;
import Process.TaskPauzeerSpel;
import Process.TaskPlaatsZet;
import Process.TaskSpelHerspelen;
import Process.TaskSpelLaden;
import Process.TaskSpelOpslaan;
import Process.TaskSpelVerlaten;
import Process.TaskStartHoofdmenu;
import Process.TaskStartSpel;
// Collin
public class GameMenu extends JPanel {
	
	private JButton spelRegels, spelVerlaten, spelHerspelen, spelOpslaan, spelPauzeren, spelLaden;
	public GameScreen gs;
	
	public GameMenu(GameScreen gs, SpeelStukkenContainer container, TaskPlaatsZet plaatsZet, SpeelBord speelbord) {
		this.gs = gs;
		
		TaskInzienSpelregels spelregelsInzien = new TaskInzienSpelregels();
		TaskPauzeerSpel pauzeerSpel = new TaskPauzeerSpel();
		TaskSpelLaden laadSpel = new TaskSpelLaden(container, speelbord, gs, plaatsZet);
		TaskSpelOpslaan opslaanSpel = new TaskSpelOpslaan(container.getStukken());
		TaskStartSpel startSpel = new TaskStartSpel();
		TaskStartHoofdmenu verlaatSpel = new TaskStartHoofdmenu();
		TaskPlaatsZet plaats = new TaskPlaatsZet();
		TaskSpelVerlaten verlaten = new TaskSpelVerlaten(this.gs);
		TaskSpelHerspelen herspelen = new TaskSpelHerspelen(gs, container, plaatsZet, speelbord);
		
		spelRegels = new JButton("Raadpleeg Spelregels");
		spelVerlaten = new JButton("Spel verlaten");
		spelHerspelen = new JButton("Herspelen");
		spelOpslaan = new JButton("Spel opslaan");
		spelPauzeren = new JButton("Pauzeren");
		spelLaden = new JButton("Spel laden");
		
		spelRegels.addActionListener(spelregelsInzien);
		spelVerlaten.addActionListener(verlaten);
		spelOpslaan.addActionListener(opslaanSpel);
		spelPauzeren.addActionListener(pauzeerSpel);
		spelHerspelen.addActionListener(herspelen);
		spelLaden.addActionListener(laadSpel);
		
		this.add(spelRegels);
		this.add(spelOpslaan);
		this.add(spelLaden);
		this.add(spelHerspelen);
		this.add(spelPauzeren);
		this.add(spelVerlaten);
		
	}


}
