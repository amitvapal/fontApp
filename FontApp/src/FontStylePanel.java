import java.awt.*;
import javax.swing.*;

/**
 * Allows the user to change the font style
 * @author Valerie Klosky
 *
 */

public class FontStylePanel extends JPanel
{
	private JCheckBox chkBold;
	private JCheckBox chkItalic;
	
	/**
	 * Constructor
	 */
	public FontStylePanel()
	{
		//create grid layout 3 rows, 1 col
		setLayout(new GridLayout(3,1));
		setSize(350, 100);
		
		//create check boxes
		chkBold = new JCheckBox("Bold");
		chkItalic = new JCheckBox("Italic");
		
		//put on border
		setBorder(BorderFactory.createTitledBorder("Style"));
		
		//add checkboxes to panel
		add(chkBold);
		add(chkItalic);
	}
	
	/**
	 * 
	 * @return style of font PLAIN, BOLD, ITALIC or BOLD+ITALIC
	 */
	public int getFontStyle()
	{
		int style = Font.PLAIN;
		if(chkBold.isSelected())
		{
			style += Font.BOLD;
		}
		if(chkItalic.isSelected())
		{
			style += Font.ITALIC;
		}
		return style;
	}                                  
}
