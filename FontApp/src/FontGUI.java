import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Puts everything together, border Layout panels, radio buttons, etc.
 * using aggregate classes
 * @author vorwig
 */
public class FontGUI extends JFrame implements ActionListener
{
	private JPanel wordsPanel, buttonPanel, middlePanel, txtBoxPanel, lblPanel;
	private JButton btnSetFont, btnExit;
	private JLabel lblWords;
	private JTextField txtWords;
	private FontSizePanel sizePanel;
	private FontStylePanel stylePanel;
	private FontFacePanel fontPanel;
	private FontColorPanel colorPanel;

	/**
	 * constructor
	 */
	public FontGUI()
	{
		setTitle("Font Sampler");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//user must click quit

		//set Layout manager for the JFrame
		setLayout(new BorderLayout());

		

		//create custom panels
		sizePanel = new FontSizePanel();
		stylePanel = new FontStylePanel();
		fontPanel = new FontFacePanel();
		colorPanel = new FontColorPanel();

		//create words panel
		makeWordsPanel();
		
		//create button panel;
		makeButtonPanel();

		//put style and font in the middle panel
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1, 2));
		middlePanel.add(stylePanel);
		middlePanel.add(fontPanel);

		//add all components to the frame in borderLayout
		
		add(wordsPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);
		add(middlePanel, BorderLayout.CENTER);
		add(colorPanel, BorderLayout.EAST);
		
		add(sizePanel, BorderLayout.WEST);



		
		
		
		
		
		pack(); //alternative to setting size
		setVisible(true);
	}

	private void makeButtonPanel()
	{
		buttonPanel = new JPanel();

		//create buttons
		btnSetFont = new JButton("Set Font");
		btnExit = new JButton("Exit");

		//register action listeners
		btnSetFont.addActionListener(this);
		btnExit.addActionListener(this);

		buttonPanel.add(btnSetFont);
		buttonPanel.add(btnExit);
	}
	
	private void makeWordsPanel()
	{
		//create wordsPanel
				wordsPanel =  new JPanel(new GridLayout(2,1));
			
				lblWords = new JLabel("Spring Break was Awesome!");
				

				lblPanel = new JPanel(new FlowLayout());
				lblPanel.add(lblWords);
				wordsPanel.add(lblPanel);

				txtBoxPanel = new JPanel(new FlowLayout());
				txtWords = new JTextField("Spring Break was awesome!");
				txtBoxPanel.add(txtWords);
				wordsPanel.add(txtBoxPanel);
	}
	
	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnExit)
			System.exit(0); // quit
		int size = sizePanel.getFontSize();
		lblWords.setText(txtWords.getText());
		lblWords.setFont(new Font(fontPanel.getFontFace(), stylePanel.getFontStyle(), size));
		
		Color colors[] = colorPanel.getFontColors();
		lblWords.setForeground(colors[0]);
		lblWords.setBackground(colors[1]);
		
		lblWords.setOpaque(true);
		
		pack();

		
	}
	
	public static void main(String[] args) 
	{
		 FontGUI font = new FontGUI();
	}
}
