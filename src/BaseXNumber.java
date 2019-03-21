import javax.swing.*;

// Describes a number in any base
public class BaseXNumber
{
	private static char[] charMap = new char[26];
	
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
			if(reverseMap(c) >= base || reverseMap(c) < 0)
				return false;
		}
		return true;
	}
	public boolean checkNum(String n) { return checkNum(n.toCharArray()); }
	
	public String range(int b)
	{
		if(b <= 10)
			return "0-" + (b-1);
		else if(b == 11)
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
	
	private char map(long n)
	{
		if(n < 10)
			return (char)(n+'0');
		else
			return charMap[(int)n-10];
	}
	
	public long decConvert()
	{
		long sum = 0;
		
		for(int i = 0; i < num.length; i++)
		{
			sum += reverseMap(num[i])*Math.pow(base, num.length-i-1);
		}
		
		return sum;
	}
	
	public String convert(int b) { return convert(decConvert(), b); }
	
	private String convert(long n, int b)
	{
		if(n%b == n)
			return Character.toString(map(n));
		return convert(n/b, b) + convert(n%b, b);
	}
	
	// Fill the charMap array with the alphabet
	private void fillCharMap()
	{
		for(int i = 65; i <= 90; i++)
		{
			charMap[i-65] = (char)i;
		}
	}
	
	public String getNum() { return String.valueOf(num); }
	public int betBase() { return base; }
	
	public boolean setNum(String n)
	{
		if(!checkNum(n))
		{
			JOptionPane.showMessageDialog(null, String.format("Input number is incorrect. It must range from %s", range(base)));
			return false;
		}
		else
			num = n.toCharArray();
		return true;
	}
	
	public void setBase(int b)
	{
		if(2 <= b && b <= 36)
			base = b;
	}
}
