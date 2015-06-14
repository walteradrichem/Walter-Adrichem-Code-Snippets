package Process;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Presentation.GameScreen;
import Presentation.SpeelBord;
import Presentation.SpeelStukkenContainer;
// Frank
public class TaskSpelHerspelen extends Task implements ActionListener, MouseListener  {

	public SpeelStukkenContainer container;
	private GameScreen gs;
	private TaskPlaatsZet plaatszet;
	private SpeelBord speelbord;
	
	public TaskSpelHerspelen(GameScreen gs, SpeelStukkenContainer container, TaskPlaatsZet plaatszet, SpeelBord speelbord){
		this.container = container;
		this.gs = gs;
		this.plaatszet = plaatszet;
		this.speelbord = speelbord;
	}
	
	@Override
	public boolean validate() {
		return false;
	}

	@Override
	public void execute() {
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.container.emptyContainer();
		this.speelbord.clearVeld();
		this.container.setVisible(false);
		SpeelStukkenContainer newContainer = new SpeelStukkenContainer(this.plaatszet);
		this.gs.add(newContainer, BorderLayout.EAST);
		TaskPlaatsZet.values = new String[4][4];
		newContainer.repaint();
		newContainer.revalidate();
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
