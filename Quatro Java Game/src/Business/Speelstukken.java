package Business;
// Walter
import Business.Speelstuk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Speelstukken extends ArrayList<Speelstuk> implements ActionListener {

	private int listSize = this.size();

	public Speelstukken() {
		
	}

	public void maakSpeelstukken() {
	
	}
	
	public void addSpeelstuk(Speelstuk s) {
		this.add(s);
	}
	
	protected int getLast() {
		return this.lastIndexOf(this);
	}

	protected int getFirst() {
		return this.indexOf(0);
	}

	protected int getSpecificIndex(int index) {
		return this.indexOf(index);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
