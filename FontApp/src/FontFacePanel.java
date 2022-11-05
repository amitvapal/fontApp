import java.awt.*;

import javax.swing.*;


public class FontFacePanel extends JPanel
{

	private JComboBox cboFontFace;
	private JLabel lblImage;
	
	public FontFacePanel()
	{
		setLayout(new GridLayout(2,1));
		setBorder(BorderFactory.createTitledBorder("Font"));
		
		// create array of fonts by reading system font list
		
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		cboFontFace = new JComboBox<Object>(fonts);
		add(cboFontFace);
		
		lblImage = new JLabel(new ImageIcon("font.jpg"));
		add(lblImage);
		
	}
	
	public String getFontFace()
	{
		return (String)cboFontFace.getSelectedItem();
	}

}
