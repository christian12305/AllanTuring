
import java.util.*;

public class Palindrome {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		
		boolean result = isPalindrome(x);
		
		System.out.println(result);
		
		scan.close();
	}

	private static boolean isPalindrome(int x) {
		
	      StringBuilder num = new StringBuilder();
	      
	      num.append(x);

	      int length = num.length();

	      for(int i = 0; i < length/2; i++) {
	    	  if(num.charAt(i) != num.charAt(length - i)) 
	    		  return false;
	      }
	      
	      return true;
		
	}

}
