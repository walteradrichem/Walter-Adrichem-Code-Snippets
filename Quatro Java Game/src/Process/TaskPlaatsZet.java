package Process;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Business.Speelstuk;
import Business.Speelstukken;
import Business.Veld;
import Business.Velden;
import Presentation.SpeelStukkenContainer;
import Presentation.WinForm;
// Gerben
public class TaskPlaatsZet extends Task implements MouseListener, ActionListener{
	
	public boolean isActiveAvail;
	public Speelstuk s;
	public Veld veld;	
	public Velden velden = new Velden();
	public Speelstukken speelstukken = new Speelstukken();
	public Speelstuk currentPiece;
	
	public static String[][] values = new String[4][4];
	
	
	public TaskPlaatsZet() {

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();

		if (source instanceof Speelstuk) {
			if (this.isActiveAvail) {

			}else{
				
				this.isActiveAvail = true;
				this.s = (Speelstuk) source;
				this.s.setActive();

			}
		}
		
		if (source instanceof Veld) {
			
			if(this.isActiveAvail) 
			{
				this.veld = (Veld) source;
				ImageIcon i = new ImageIcon(this.s.getPath());
				if(this.veld.stuk == null){
					
					this.isActiveAvail = false;
					this.veld.setIcon(i);
					this.veld.addSpeelstukToVeld(this.s);
					
					this.addSpeelstuk(this.s);
					this.addVeld(this.veld);
			
					this.s.removeSpeelstuk();
					
					String type = this.s.getTypeOfStuk();
					int index = this.veld.index;
				
					this.s.setIndex(index);

					this.addToArray(type, index);

					boolean quarto = this.checkWincondition(values);
					
					if(quarto)
					{
							new WinForm("Speler");
					}
					
				}
				else
				{
					System.out.println("Dit veld is al bezet.");
				}
			}
		}
	}
	
	public void addVeld(Veld veld){
		this.velden.add(veld);
	}
	
	public void addSpeelstuk(Speelstuk speelstuk){
		this.currentPiece = speelstuk;
		this.speelstukken.add(currentPiece);
	}
		
	public boolean checkWincondition(String s[][]){
		// Gerben algorithme beschreven en gemaakt
		
		int quarto = 0;
		
		//row 1
		if(s[0][0] != null && s[0][1] != null && s[0][2] != null && s[0][3] != null)
		{
			System.out.println("Regel 1 is niet leeg");
			if(s[0][0].charAt(0) == '0' && s[0][1].charAt(0) == '0' && s[0][2].charAt(0) == '0' && s[0][3].charAt(0) == '0'){quarto++;}
			if(s[0][0].charAt(1) == '0' && s[0][1].charAt(1) == '0' && s[0][2].charAt(1) == '0' && s[0][3].charAt(1) == '0'){quarto++;}
			if(s[0][0].charAt(2) == '0' && s[0][1].charAt(2) == '0' && s[0][2].charAt(2) == '0' && s[0][3].charAt(2) == '0'){quarto++;}
			if(s[0][0].charAt(3) == '0' && s[0][1].charAt(3) == '0' && s[0][2].charAt(3) == '0' && s[0][3].charAt(3) == '0'){quarto++;}
			if(s[0][0].charAt(0) == '1' && s[0][1].charAt(0) == '1' && s[0][2].charAt(0) == '1' && s[0][3].charAt(0) == '1'){quarto++;}
			if(s[0][0].charAt(1) == '1' && s[0][1].charAt(1) == '1' && s[0][2].charAt(1) == '1' && s[0][3].charAt(1) == '1'){quarto++;}
			if(s[0][0].charAt(2) == '1' && s[0][1].charAt(2) == '1' && s[0][2].charAt(2) == '1' && s[0][3].charAt(2) == '1'){quarto++;}
			if(s[0][0].charAt(3) == '1' && s[0][1].charAt(3) == '1' && s[0][2].charAt(3) == '1' && s[0][3].charAt(3) == '1'){quarto++;}
		}
		//row 2
		if(s[1][0] != null && s[1][1] != null && s[1][2] != null && s[1][3] != null)
		{
			System.out.println("Regel 2 is niet leeg");
			if(s[1][0].charAt(0) == '0' && s[1][1].charAt(0) == '0' && s[1][2].charAt(0) == '0' && s[1][3].charAt(0) == '0'){quarto++;}
			if(s[1][0].charAt(1) == '0' && s[1][1].charAt(1) == '0' && s[1][2].charAt(1) == '0' && s[1][3].charAt(1) == '0'){quarto++;}
			if(s[1][0].charAt(2) == '0' && s[1][1].charAt(2) == '0' && s[1][2].charAt(2) == '0' && s[1][3].charAt(2) == '0'){quarto++;}
			if(s[1][0].charAt(3) == '0' && s[1][1].charAt(3) == '0' && s[1][2].charAt(3) == '0' && s[1][3].charAt(3) == '0'){quarto++;}
			if(s[1][0].charAt(0) == '1' && s[1][1].charAt(0) == '1' && s[1][2].charAt(0) == '1' && s[1][3].charAt(0) == '1'){quarto++;}
			if(s[1][0].charAt(1) == '1' && s[1][1].charAt(1) == '1' && s[1][2].charAt(1) == '1' && s[1][3].charAt(1) == '1'){quarto++;}
			if(s[1][0].charAt(2) == '1' && s[1][1].charAt(2) == '1' && s[1][2].charAt(2) == '1' && s[1][3].charAt(2) == '1'){quarto++;}
			if(s[1][0].charAt(3) == '1' && s[1][1].charAt(3) == '1' && s[1][2].charAt(3) == '1' && s[1][3].charAt(3) == '1'){quarto++;}
		}
		//row 3
		if(s[2][0] != null && s[2][1] != null && s[2][2] != null && s[2][3] != null)
		{
			System.out.println("Regel 3 is niet leeg");
			if(s[2][0].charAt(0) == '0' && s[2][1].charAt(0) == '0' && s[2][2].charAt(0) == '0' && s[2][3].charAt(0) == '0'){quarto++;}
			if(s[2][0].charAt(1) == '0' && s[2][1].charAt(1) == '0' && s[2][2].charAt(1) == '0' && s[2][3].charAt(1) == '0'){quarto++;}
			if(s[2][0].charAt(2) == '0' && s[2][1].charAt(2) == '0' && s[2][2].charAt(2) == '0' && s[2][3].charAt(2) == '0'){quarto++;}
			if(s[2][0].charAt(3) == '0' && s[2][1].charAt(3) == '0' && s[2][2].charAt(3) == '0' && s[2][3].charAt(3) == '0'){quarto++;}
			if(s[2][0].charAt(0) == '1' && s[2][1].charAt(0) == '1' && s[2][2].charAt(0) == '1' && s[2][3].charAt(0) == '1'){quarto++;}
			if(s[2][0].charAt(1) == '1' && s[2][1].charAt(1) == '1' && s[2][2].charAt(1) == '1' && s[2][3].charAt(1) == '1'){quarto++;}
			if(s[2][0].charAt(2) == '1' && s[2][1].charAt(2) == '1' && s[2][2].charAt(2) == '1' && s[2][3].charAt(2) == '1'){quarto++;}
			if(s[2][0].charAt(3) == '1' && s[2][1].charAt(3) == '1' && s[2][2].charAt(3) == '1' && s[2][3].charAt(3) == '1'){quarto++;}
		}
		//row 4
		if(s[3][0] != null && s[3][1] != null && s[3][2] != null && s[3][3] != null)
		{
			System.out.println("Regel 4 is niet leeg");
			if(s[3][0].charAt(0) == '0' && s[3][1].charAt(0) == '0' && s[3][2].charAt(0) == '0' && s[3][3].charAt(0) == '0'){quarto++;}
			if(s[3][0].charAt(1) == '0' && s[3][1].charAt(1) == '0' && s[3][2].charAt(1) == '0' && s[3][3].charAt(1) == '0'){quarto++;}
			if(s[3][0].charAt(2) == '0' && s[3][1].charAt(2) == '0' && s[3][2].charAt(2) == '0' && s[3][3].charAt(2) == '0'){quarto++;}
			if(s[3][0].charAt(3) == '0' && s[3][1].charAt(3) == '0' && s[3][2].charAt(3) == '0' && s[3][3].charAt(3) == '0'){quarto++;}
			if(s[3][0].charAt(0) == '1' && s[3][1].charAt(0) == '1' && s[3][2].charAt(0) == '1' && s[3][3].charAt(0) == '1'){quarto++;}
			if(s[3][0].charAt(1) == '1' && s[3][1].charAt(1) == '1' && s[3][2].charAt(1) == '1' && s[3][3].charAt(1) == '1'){quarto++;}
			if(s[3][0].charAt(2) == '1' && s[3][1].charAt(2) == '1' && s[3][2].charAt(2) == '1' && s[3][3].charAt(2) == '1'){quarto++;}
			if(s[3][0].charAt(3) == '1' && s[3][1].charAt(3) == '1' && s[3][2].charAt(3) == '1' && s[3][3].charAt(3) == '1'){quarto++;}
		}
		//row 5
		if(s[0][0] != null && s[1][0] != null && s[2][0] != null && s[3][0] != null)
		{
			System.out.println("Regel 5 is niet leeg");
			if(s[0][0].charAt(0) == '0' && s[1][0].charAt(0) == '0' && s[2][0].charAt(0) == '0' && s[3][0].charAt(0) == '0'){quarto++;}
			if(s[0][0].charAt(1) == '0' && s[1][0].charAt(1) == '0' && s[2][0].charAt(1) == '0' && s[3][0].charAt(1) == '0'){quarto++;}
			if(s[0][0].charAt(2) == '0' && s[1][0].charAt(2) == '0' && s[2][0].charAt(2) == '0' && s[3][0].charAt(2) == '0'){quarto++;}
			if(s[0][0].charAt(3) == '0' && s[1][0].charAt(3) == '0' && s[2][0].charAt(3) == '0' && s[3][0].charAt(3) == '0'){quarto++;}
			if(s[0][0].charAt(0) == '1' && s[1][0].charAt(0) == '1' && s[2][0].charAt(0) == '1' && s[3][0].charAt(0) == '1'){quarto++;}
			if(s[0][0].charAt(1) == '1' && s[1][0].charAt(1) == '1' && s[2][0].charAt(1) == '1' && s[3][0].charAt(1) == '1'){quarto++;}
			if(s[0][0].charAt(2) == '1' && s[1][0].charAt(2) == '1' && s[2][0].charAt(2) == '1' && s[3][0].charAt(2) == '1'){quarto++;}
			if(s[0][0].charAt(3) == '1' && s[1][0].charAt(3) == '1' && s[2][0].charAt(3) == '1' && s[3][0].charAt(3) == '1'){quarto++;}
		}
		//row 6
		if(s[0][1] != null && s[1][1] != null && s[2][1] != null && s[3][1] != null)
		{
			System.out.println("Regel 6 is niet leeg");
			if(s[0][1].charAt(0) == '0' && s[1][1].charAt(0) == '0' && s[2][1].charAt(0) == '0' && s[3][1].charAt(0) == '0'){quarto++;}
			if(s[0][1].charAt(1) == '0' && s[1][1].charAt(1) == '0' && s[2][1].charAt(1) == '0' && s[3][1].charAt(1) == '0'){quarto++;}
			if(s[0][1].charAt(2) == '0' && s[1][1].charAt(2) == '0' && s[2][1].charAt(2) == '0' && s[3][1].charAt(2) == '0'){quarto++;}
			if(s[0][1].charAt(3) == '0' && s[1][1].charAt(3) == '0' && s[2][1].charAt(3) == '0' && s[3][1].charAt(3) == '0'){quarto++;}
			if(s[0][1].charAt(0) == '1' && s[1][1].charAt(0) == '1' && s[2][1].charAt(0) == '1' && s[3][1].charAt(0) == '1'){quarto++;}
			if(s[0][1].charAt(1) == '1' && s[1][1].charAt(1) == '1' && s[2][1].charAt(1) == '1' && s[3][1].charAt(1) == '1'){quarto++;}
			if(s[0][1].charAt(2) == '1' && s[1][1].charAt(2) == '1' && s[2][1].charAt(2) == '1' && s[3][1].charAt(2) == '1'){quarto++;}
			if(s[0][1].charAt(3) == '1' && s[1][1].charAt(3) == '1' && s[2][1].charAt(3) == '1' && s[3][1].charAt(3) == '1'){quarto++;}
		}
		//row 7
		if(s[0][2] != null && s[1][2] != null && s[2][2] != null && s[3][2] != null)
		{
			System.out.println("Regel 7 is niet leeg");
			if(s[0][2].charAt(0) == '0' && s[1][2].charAt(0) == '0' && s[2][2].charAt(0) == '0' && s[3][2].charAt(0) == '0'){quarto++;}
			if(s[0][2].charAt(1) == '0' && s[1][2].charAt(1) == '0' && s[2][2].charAt(1) == '0' && s[3][2].charAt(1) == '0'){quarto++;}
			if(s[0][2].charAt(2) == '0' && s[1][2].charAt(2) == '0' && s[2][2].charAt(2) == '0' && s[3][2].charAt(2) == '0'){quarto++;}
			if(s[0][2].charAt(3) == '0' && s[1][2].charAt(3) == '0' && s[2][2].charAt(3) == '0' && s[3][2].charAt(3) == '0'){quarto++;}
			if(s[0][2].charAt(0) == '1' && s[1][2].charAt(0) == '1' && s[2][2].charAt(0) == '1' && s[3][2].charAt(0) == '1'){quarto++;}
			if(s[0][2].charAt(1) == '1' && s[1][2].charAt(1) == '1' && s[2][2].charAt(1) == '1' && s[3][2].charAt(1) == '1'){quarto++;}
			if(s[0][2].charAt(2) == '1' && s[1][2].charAt(2) == '1' && s[2][2].charAt(2) == '1' && s[3][2].charAt(2) == '1'){quarto++;}
			if(s[0][2].charAt(3) == '1' && s[1][2].charAt(3) == '1' && s[2][2].charAt(3) == '1' && s[3][2].charAt(3) == '1'){quarto++;}
		}
		//row 8
		if(s[0][3] != null && s[1][3] != null && s[2][3] != null && s[3][3] != null)
		{
			System.out.println("Regel 8 is niet leeg");
			if(s[0][3].charAt(0) == '0' && s[1][3].charAt(0) == '0' && s[2][3].charAt(0) == '0' && s[3][3].charAt(0) == '0'){quarto++;}
			if(s[0][3].charAt(1) == '0' && s[1][3].charAt(1) == '0' && s[2][3].charAt(1) == '0' && s[3][3].charAt(1) == '0'){quarto++;}
			if(s[0][3].charAt(2) == '0' && s[1][3].charAt(2) == '0' && s[2][3].charAt(2) == '0' && s[3][3].charAt(2) == '0'){quarto++;}
			if(s[0][3].charAt(3) == '0' && s[1][3].charAt(3) == '0' && s[2][3].charAt(3) == '0' && s[3][3].charAt(3) == '0'){quarto++;}
			if(s[0][3].charAt(0) == '1' && s[1][3].charAt(0) == '1' && s[2][3].charAt(0) == '1' && s[3][3].charAt(0) == '1'){quarto++;}
			if(s[0][3].charAt(1) == '1' && s[1][3].charAt(1) == '1' && s[2][3].charAt(1) == '1' && s[3][3].charAt(1) == '1'){quarto++;}
			if(s[0][3].charAt(2) == '1' && s[1][3].charAt(2) == '1' && s[2][3].charAt(2) == '1' && s[3][3].charAt(2) == '1'){quarto++;}
			if(s[0][3].charAt(3) == '1' && s[1][3].charAt(3) == '1' && s[2][3].charAt(3) == '1' && s[3][3].charAt(3) == '1'){quarto++;}
		}
		//row 9
		if(s[0][0] != null && s[1][1] != null && s[2][2] != null && s[3][3] != null)
		{
			System.out.println("Regel 9 is niet leeg");
			if(s[0][0].charAt(0) == '0' && s[1][1].charAt(0) == '0' && s[2][2].charAt(0) == '0' && s[3][3].charAt(0) == '0'){quarto++;}
			if(s[0][0].charAt(1) == '0' && s[1][1].charAt(1) == '0' && s[2][2].charAt(1) == '0' && s[3][3].charAt(1) == '0'){quarto++;}
			if(s[0][0].charAt(2) == '0' && s[1][1].charAt(2) == '0' && s[2][2].charAt(2) == '0' && s[3][3].charAt(2) == '0'){quarto++;}
			if(s[0][0].charAt(3) == '0' && s[1][1].charAt(3) == '0' && s[2][2].charAt(3) == '0' && s[3][3].charAt(3) == '0'){quarto++;}
			if(s[0][0].charAt(0) == '1' && s[1][1].charAt(0) == '1' && s[2][2].charAt(0) == '1' && s[3][3].charAt(0) == '1'){quarto++;}
			if(s[0][0].charAt(1) == '1' && s[1][1].charAt(1) == '1' && s[2][2].charAt(1) == '1' && s[3][3].charAt(1) == '1'){quarto++;}
			if(s[0][0].charAt(2) == '1' && s[1][1].charAt(2) == '1' && s[2][2].charAt(2) == '1' && s[3][3].charAt(2) == '1'){quarto++;}
			if(s[0][0].charAt(3) == '1' && s[1][1].charAt(3) == '1' && s[2][2].charAt(3) == '1' && s[3][3].charAt(3) == '1'){quarto++;}
		}
		//row 10
		if(s[3][0] != null && s[2][1] != null && s[1][2] != null && s[0][3] != null)
		{
			System.out.println("Regel 10 is niet leeg");
			if(s[3][0].charAt(0) == '0' && s[2][1].charAt(0) == '0' && s[1][2].charAt(0) == '0' && s[0][3].charAt(0) == '0'){quarto++;}
			if(s[3][0].charAt(1) == '0' && s[2][1].charAt(1) == '0' && s[1][2].charAt(1) == '0' && s[0][3].charAt(1) == '0'){quarto++;}
			if(s[3][0].charAt(2) == '0' && s[2][1].charAt(2) == '0' && s[1][2].charAt(2) == '0' && s[0][3].charAt(2) == '0'){quarto++;}
			if(s[3][0].charAt(3) == '0' && s[2][1].charAt(3) == '0' && s[1][2].charAt(3) == '0' && s[0][3].charAt(3) == '0'){quarto++;}
			if(s[3][0].charAt(0) == '1' && s[2][1].charAt(0) == '1' && s[1][2].charAt(0) == '1' && s[0][3].charAt(0) == '1'){quarto++;}
			if(s[3][0].charAt(1) == '1' && s[2][1].charAt(1) == '1' && s[1][2].charAt(1) == '1' && s[0][3].charAt(1) == '1'){quarto++;}
			if(s[3][0].charAt(2) == '1' && s[2][1].charAt(2) == '1' && s[1][2].charAt(2) == '1' && s[0][3].charAt(2) == '1'){quarto++;}
			if(s[3][0].charAt(3) == '1' && s[2][1].charAt(3) == '1' && s[1][2].charAt(3) == '1' && s[0][3].charAt(3) == '1'){quarto++;}
		}
		
		
		
		
		
		
		
		
		if(quarto >= 1){
			System.out.println("Je hebt op " + quarto + " manieren gewonnen.");
			return true;
			
		}
		else{
			return false;
		}
		
		
		
		
	
	}
	
	public void addToArray(String type, int index){
	
		switch (index) {
		case 0:  values[0][0] = type;
        break;
		case 1:  values[0][1] = type;
        break;
		case 2:  values[0][2] = type;
        break;
		case 3:  values[0][3] = type;
        break;
		case 4:  values[1][0] = type;
        break;
		case 5:  values[1][1] = type;
        break;
		case 6:  values[1][2] = type;
        break;
		case 7:  values[1][3] = type;
        break;
		case 8:  values[2][0] = type;
        break;
		case 9:  values[2][1] = type;
        break;
		case 10:  values[2][2] = type;
        break;
		case 11:  values[2][3] = type;
        break;
		case 12:  values[3][0] = type;
        break;
		case 13:  values[3][1] = type;
        break;
		case 14:  values[3][2] = type;
        break;
		case 15:  values[3][3] = type;
        break;
		default: ;
        break;
        
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	

	

}
