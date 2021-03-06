import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BaseConverter extends JFrame
	implements ActionListener, KeyListener
{
	private JTextField inputText, outputText;
	private JComboBox<String> inputBases, outputBases;
	private JButton convertButton;
	
	private String[] bases = new String[35];
	
	private BaseXNumber in = new BaseXNumber("", 10);
	
	public BaseConverter()
	{
		super("Number Base Converter");
		
		fillBases();
		
		GridBagConstraints c = new GridBagConstraints();
		
		// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		
		
		// Input Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		
		JLabel inputLabel = new JLabel("Input number");
		inputText = new JTextField();
		inputText.addKeyListener(this);
		
		inputBases = new JComboBox<>(bases);
		inputBases.setSelectedIndex(8); // Base 10
		inputBases.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1/3f;
		inputPanel.add(inputLabel, c);
		c.gridy++;
		c.fill = GridBagConstraints.HORIZONTAL;
		inputPanel.add(inputText, c);
		c.gridy++;
		c.fill = 0;
		inputPanel.add(inputBases, c);
		// End Input Panel
		
		
		// Output Panel
		JPanel outputPanel = new JPanel();
		outputPanel.setLayout(new GridBagLayout());
		
		JLabel outputLabel = new JLabel("Output number");
		outputText = new JTextField();
		outputText.setEditable(false);
		
		outputBases = new JComboBox<>(bases);
		outputBases.setSelectedIndex(0); // Base 2
		outputBases.addActionListener(this);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1/3f;
		outputPanel.add(outputLabel, c);
		c.gridy++;
		c.fill = GridBagConstraints.HORIZONTAL;
		outputPanel.add(outputText, c);
		c.gridy++;
		c.fill = 0;
		outputPanel.add(outputBases, c);
		// End Output Panel
		
		
		// Convert Button
		convertButton = new JButton("Convert");
		convertButton.addActionListener(this);
		// End Convert Button
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 20, 0, 20);
		mainPanel.add(inputPanel, c);
		c.gridy++;
		mainPanel.add(outputPanel, c);
		c.gridy++;
		c.weighty = 0.25;
		c.fill = 0;
		mainPanel.add(convertButton, c);
		// End Main Panel
		
		
		getContentPane().add(mainPanel);
	}
	
	// Fill the bases array with 'Base (2-35)'
	private void fillBases()
	{
		for(int i = 2; i <= 36; i++)
		{
			bases[i-2] = "Base " + i;
		}
	}
	
	// Helper functions to get the bases
	private int getInputBase() { return inputBases.getSelectedIndex()+2; }
	private int getOutputBase() { return outputBases.getSelectedIndex()+2; }
	
	
	private String formatBin(String n)
	{
		if(n.length()%4 != 0)
		{
			// Append as many zeroes as needed
			StringBuilder sb = new StringBuilder();
			int zeroes = 4 - n.length() % 4;
			for (int i = 0; i < zeroes; i++)
			{
				sb.append("0");
			}
			n = sb + n;
		}
		// Fancy expression to add a space every 4 digits on the new string (sb + n)
		return String.join(" ", n.split("(?<=\\G.{4})"));
	}
	
	private String formatHex(String n)
	{
		if(n.length()%2 != 0)
		{
			// Append as many zeroes as needed
			StringBuilder sb = new StringBuilder();
			int zeroes = 2 - n.length() % 2;
			for (int i = 0; i < zeroes; i++)
			{
				sb.append("0");
			}
			n = sb + n;
		}
		// Fancy expression to add a space every 4 digits on the new string (sb + n)
		return String.join(" ", n.split("(?<=\\G.{2})"));
	}
	
	
	private void doConvert()
	{
		// Regex gets rid of all completely invalid character
		if(in.setNum(inputText.getText().toUpperCase().replaceAll("[^0-9A-Z]", "")))
		{
			String out;
			switch(getOutputBase())
			{
				case 2:
					out = formatBin(in.convert(2));
					break;
				case 16:
					out = formatHex(in.convert(16));
					break;
				default:
					out = in.convert(getOutputBase());
					break;
			}
			outputText.setText(out);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == inputBases)
		{
			in.setBase(getInputBase());
		}
		else if(e.getSource() == convertButton)
		{
			doConvert();
		}
	}
	
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar() == '\n')
		{
			doConvert();
		}
	}
	
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	
	public static void main(String[] args)
	{
		BaseConverter bc = new BaseConverter();
		bc.setBounds(200, 200, 400, 300);
		bc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		bc.setVisible(true);
	}
}
