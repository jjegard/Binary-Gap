/**
 * 
 * @author John Jegard
 *
 *The goal is to take in an integer and convert that integer into its binary
 *representation. Then return the longest sequence of zeroes in between two 1's.
 *This is known as the binary gap. For example, Integer 9 has a binary representation
 *of 1001 which has a binary gap of 2. Integer 32 has a binary representation of
 *100000 which has a binary gap of 0.
 */
public class BinaryGap
{
	public static int solution(int N)
	{
		String binary = Integer.toBinaryString(N);//convert int to binary string
		//print out what the integer is and what its binary representation is
		System.out.println(String.format("int: %d, binary: %s", N, binary));
		
		int longestBinaryGap = 0;
		int indexOfFirstOne = 0;
		int indexOfNextOne = 0;
		int gap;
		
		while(indexOfNextOne >= 0 && indexOfNextOne < binary.length())
		{	
			//finds index of the next '1' in the binary string starting at the index
			//of the first '1' plus 1. If there are no more 1's in the binary string,
			//indexOfNextOne will be assigned a value of -1 which will cause the
			//exit of the loop
			indexOfNextOne = binary.indexOf('1', indexOfFirstOne + 1);
			gap = indexOfNextOne - indexOfFirstOne - 1;
			if(gap > longestBinaryGap)
			{
				longestBinaryGap = gap;
			}
			indexOfFirstOne = indexOfNextOne;
		}
		
		return longestBinaryGap;
	}
	
	
	public static void main(String[] args)
	{
		for(int i = -9; i < 10; i++)
		{
			System.out.println(solution(i));
		}
		System.out.println(solution(32));
		System.out.println(solution(33));
		System.out.println(solution(562));
		System.out.println(solution(4534));
		System.out.println(solution(243525));
		System.out.println(solution(2147483647));
		System.out.println(solution(-2147483648));
	}
}
