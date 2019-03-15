import javax.swing.*;

// Describes a number in any base
public class BaseXNumber
{
	public static char[] charMap = new char[26];
	
	private int base;
	private char[] num;
	
	public BaseXNumber(String n, int b)
	{
		base = b;
		if(charMap[0] == 0)
			fillCharMap();
		if(!checkNum(n))
			JOptionPane.showMessageDialog(null, String.format("Input number is incorrect. It must range from %s", range(base)));
		else
			num = n.toCharArray();
	}
	
	// Check if the number in the input text box is correctly formatted
	public boolean checkNum(char[] n)
	{
		for(char c : n)
		{
			if(reverseMap(c) > base || reverseMap(c) < 0)
				return false;
		}
		return true;
	}
	public boolean checkNum(String n) { return checkNum(n.toCharArray()); }
	
	public String range(int b)
	{
		if(b < 10)
			return "0-" + (b-1);
		else if(b == 10)
			return "0-9,A";
		else
			return "0-9,A-" + map(b-1);
	}
	
	private int reverseMap(char c)
	{
		if(c >= '0' && c <= '9')
			return (c - '0');
		else
			return c-'A' + 10;
	}
	
	private char map(int n)
	{
		if(n < 10)
			return (char)(n+'0');
		else
			return charMap[n-10];
	}
	
	// Fill the charMap array with the alphabet
	private void fillCharMap()
	{
		for(int i = 65; i <= 90; i++)
		{
			charMap[i-65] = (char)i;
		}
	}
}
