package Business;

import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
// Gerben
public class Veld extends JLabel {
	public Speelstuk stuk;
	public int index;
	public ImageIcon icon;
	
	public Veld(MouseListener task, int index) {
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY));	
		this.addMouseListener(task);
		this.index = index;
	}

	public void addSpeelstukToVeld(Speelstuk s) {
		this.stuk = s;
		this.icon = new ImageIcon(s.path);
		this.setIcon(this.icon);
	}
	
	public void removeSpeelstukFromVeld() {
		if (this.stuk != null) {
			this.stuk = null;
			this.setIcon(null);
		}
	}
}
