package Presentation;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Walter
public class SpelregelForm extends JFrame {
	int option;
	public void compilePopup(String title, String message, String button1) {
		Object[] buttons = { button1 };
		option = JOptionPane.showOptionDialog(this, message, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,  // do not use a custom Icon
				buttons, // the titles of buttons
				buttons[0]); // default button title
	}
	
	public SpelregelForm() {
		compilePopup("Spelregels",
				"Spelregels Quarto:\n"
						+ "\n"
						+ "Quarto wordt met 16 speelstukken met de volgende kenmerken gespeeld:\n"
						+ "-Oranje of Zwart\n"
						+ "-Vol of Hol\n"
						+ "-Groot of klein\n"
						+ "-Rond of vierkant\n"
						+ "\n"
						+ "Het spel begint met speler 1 die een spelstuk geeft aan speler 2.\n"
						+ "Speler 2 zet dit stuk op 1 van de 16 vakjes van het spelbord.\n"
						+ "Hierna geeft speler 2 een stuk aan speler 1 en die op zijn beurt deze\n"
						+ "plaatst, dit proces herhaald zich.\n"
						+ "\n"
						+ "Om Quarto te winnen moet je de speler zijn die een gegeven stuk\n"
						+ "plaatst om 4 op een rij (Horizontaal, verticaal of diagonaal) te maken\n"
						+ "van 4 stukken die een van de bovenstaande kenmerken delen. Succes!",
				// Button
				"Spel Hervatten");	
	}

	
}
