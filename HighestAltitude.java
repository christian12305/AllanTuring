package codenights;

import java.util.*;

public class HighestAltitude {

	public static void main(String[] args) {
		int gain[] = {-4,-3,-2,-1,4,3,2};
		System.out.println(largestAltitude(gain));
	}
	public static int largestAltitude(int[] gain) {

		int max = gain[0], pos = 0;

		for( int x : gain) {

			if( (pos + x) > max)
				max = pos + x;

			pos += x;   
		}

		if(max < 0)
			return 0;
		else
			return max;
	}

}
