import javax.swing.*;
import java.awt.*;

/**
 * allows the user to change the font size
 * @author Valerie Klosky
 *
 */
public class FontSizePanel extends JPanel
{
	private JRadioButton radSmall;
	private JRadioButton radMed;
	private JRadioButton radLarge;
	private ButtonGroup bg;
	/**
	 * constructor
	 */
	public FontSizePanel()
	{
		//create grid layout 3 rows, 1 col
		setLayout(new GridLayout(3,1));
		setSize(350, 100);
		
		//create Radio buttons
		radSmall = new JRadioButton("Small");
		radMed = new JRadioButton("Medium");
		radLarge = new JRadioButton("Large");
		
		//set one radio button to be automatically selected
		radSmall.setSelected(true);
		
		
		//put radio buttons in button group
		bg = new ButtonGroup();
		bg.add(radSmall);
		bg.add(radMed);
		bg.add(radLarge);
		
		//put border on panel
		setBorder(BorderFactory.createTitledBorder("Choose a size of drink!"));
		
		//add buttons to panel
		add(radSmall);
		add(radMed);
		add(radLarge);
	}
	
	/**
	 * 
	 * @return font size selected by user
	 */
	public int getFontSize()
	{
		if(radSmall.isSelected())
		{
			return 24;
		}
		if(radMed.isSelected())
		{
			return 36;
		}
		return 48;
		
	}
}
