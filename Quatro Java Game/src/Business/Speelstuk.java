package Business;
// Frank
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Speelstuk extends JPanel {

	private boolean isRound;
	private boolean isLarge;
	private boolean isFilled;
	private boolean isBlack;
	
	public int location = 16;

	private JLabel label;

	public String path;
	public String ActiveStuk = "leeg";
	public String BoolString = "leeg";
	
	public boolean hasBackground = false;
	public boolean isActive = false;

	//private ImageIcon plaatje;
	private ImageIcon plaatje;

	//private BufferedImage image;

	public Speelstuk(boolean isBlack, boolean isLarge, boolean isFilled, boolean isRound, int location, String path) {
		this.isBlack = isBlack;
		this.isLarge = isLarge;
		this.isFilled = isFilled;
		this.isRound = isRound;
		this.location = location;
		this.path = path;
		this.setSize(200, 200);
		label = new JLabel();		
		plaatje = new ImageIcon(path);	
		label.setIcon(plaatje);
		this.add(label);

	}
	public void addIcon(String path){
		this.plaatje = new ImageIcon(path);	
		this.label.setIcon(this.plaatje);
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String getTypeOfStuk() {
		String type = "";
		if (isBlack) {
			type += "1";
		} else {
			type += "0";
		}
		
		if (isLarge) {
			type += "1";
		} else {
			type += "0";
		}
		
		if (isFilled) {
			type += "1";
		} else {
			type += "0";
		}
		
		if (isRound) {
			type += "1";
		} else {
			type += "0";
		}
				
		return type;
	}
	
	public void setActive() {
		this.setBackground(Color.gray);
	}
	
	public JLabel getLabel() {
		return this.label;
	}
	
	public void removeSpeelstuk() {	
		this.label.setIcon(null);
		this.setBackground(null);
		this.setVisible(false);
		this.plaatje = null;
		this.path = "";
		this.remove(this);
		
	}
	
	public void setIndex(int index) {
		this.location = index;
	}
}
