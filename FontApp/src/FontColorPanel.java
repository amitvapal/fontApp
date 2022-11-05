import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class FontColorPanel extends JPanel
{

	private JColorChooser colorChooser;
	private JButton btnBackground, btnForeground;
	
	
	public FontColorPanel()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Color"));
		
		colorChooser = new JColorChooser();
		//remove preview box
		colorChooser.remove(1);
		colorChooser.validate();
		
		btnBackground = new JButton("Set Background Color");
		btnForeground = new JButton("Set Foreground Color");
		
		btnBackground.addActionListener(new ColorListener());
		btnForeground.addActionListener(new ColorListener());
		
		add(colorChooser, BorderLayout.NORTH);
		add(btnForeground, BorderLayout.SOUTH);
		


		
	}
	
	public Color[] getFontColors()
	{
		Color colorList[] = {btnForeground.getForeground(), btnBackground.getBackground()};
		return colorList;
	}
	
	private class ColorListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnForeground)
			{
				btnForeground.setForeground(colorChooser.getColor());

			}
			else
			{
				btnBackground.setBackground(colorChooser.getColor());
				
			}
		}
		
	}

}
