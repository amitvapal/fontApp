import java.awt.*;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;

public class Boxes extends JFrame implements ChangeListener
{
	private JSlider slider;
	private JPanel sliderPanel;
	private BoxesPanel boxesPanel;

	public Boxes() throws HeadlessException
	{
		setSize(300,150);
		setTitle("Boxes and a Slider");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		boxesPanel = new BoxesPanel(); // need to create
		add(boxesPanel, BorderLayout.NORTH);
		slider = new JSlider(0,10,0);
		slider.setMajorTickSpacing(2);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);//shows paint ticks
		slider.addChangeListener(this); /// activates the slider
		add(boxesPanel,BorderLayout.SOUTH); // show paint ticks
		
		setVisible(true);

	}

	public Boxes(GraphicsConfiguration gc)
	{
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Boxes(String title) throws HeadlessException
	{
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Boxes(String title, GraphicsConfiguration gc)
	{
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		repaint();

	}

	public static void main(String[] args)
	{
		Boxes b = new Boxes();

	}
	/*
	 * Panel for drawing shapes
	 * panel will be redrawn by the gui when the window resizes 
	 * or manually by calling the paintComponent method via repaint
	 */
	private class BoxesPanel extends JPanel
	{
		public BoxesPanel()
		{
			setPreferredSize(new Dimension(190,150));
			setBackground(Color.white);
		}
		
	}
	/*
	 * Painting on the panel
	 */
	public void paintComponent(Graphics g)
	{
		int x = 5;
		int numBoxes=slider.getValue();
		g.setColor(Color.blue); // set pen color
		
		for(int i=0; i<numBoxes;i++)
		{
			g.drawRect(x, 10, 20, 20);
			x+=28;
		}
	}

}
