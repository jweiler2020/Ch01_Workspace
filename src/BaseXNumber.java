// Describes a number in any base
public class BaseXNumber
{
	public static char[] charMap = new char[36];
	
	private int base;
	private char[] num;
	
	public BaseXNumber(String n, int b)
	{
		base = b;
		if(charMap[0] == 0)
			fillCharMap();
		if(!checkNum(n))
		{
			// TODO: do things here
		}
	}
	
	// Check if the number in the input text box is correctly formatted
	private boolean checkNum(char[] n)
	{
		for(char c : n)
		{
			if(reverseMap(c) > base || reverseMap(c) < 0)
				return false;
		}
		return true;
	}
	private boolean checkNum(String n)
	{
		return checkNum(n.toCharArray());
	}
	
	private int reverseMap(char c)
	{
		// TODO: do the mapping thing
	}
	
	private char map(int n)
	{
		// TODO: also do the mapping thing
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
