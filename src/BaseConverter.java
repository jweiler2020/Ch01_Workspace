import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BaseConverter extends JFrame
	implements ActionListener
{
	private JTextField inputText, outputText;
	private JComboBox<String> inputBases, outputBases;
	private JButton convertButton;
	
	public BaseConverter()
	{
		super("Number Base Converter");
		
		GridBagConstraints c = new GridBagConstraints();
		
		// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		
		
		// Input Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		
		JLabel inputLabel = new JLabel("Input number");
		inputText = new JTextField();
		
		inputBases = new JComboBox<>();
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
		
		outputBases = new JComboBox<>();
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
		// End Convert Button
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(20, 20, 20, 20);
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
	
	public void actionPerformed(ActionEvent e)
	{
	
	}
	
	public static void main(String[] args)
	{
		BaseConverter bc = new BaseConverter();
		bc.setBounds(200, 200, 400, 300);
		bc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		bc.setVisible(true);
	}
}
