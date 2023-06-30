
public class UncrossedLines {

	public static void main(String[] args) {
		int nums1[] = {3,1,2,1,4,1,2,2,5,3,2,1,1,4,5,2,3,2,5,5};
		int nums2[] = {2,4,1,2,3,4,2,4,5,5,1,1,2,1,1,1,5,4,1,4,2,1,5,4,2,3,1,5,2,1};

		System.out.println(maxUncrossedLines(nums1, nums2));

	}

	public static int maxUncrossedLines(int[] nums1, int[] nums2) {

		//BOTTOM UP
		//Tabulation
		int m = nums1.length, 
				n = nums2.length;

		int table[][] = new int[m + 1][n + 1];

		//starting from second idx
		// which contains the first number
		for (int i = 1; i <= m; ++i) {

			for (int j = 1; j <= n; ++j) {

				//Paired Case
				if (nums1[i - 1] == nums2[j - 1])
					table[i][j] = 1 + table[i - 1][j - 1];

				//Return max of left or up
				else
					table[i][j] = Math.max(table[i][j - 1], 
							table[i - 1][j]);
			}
		}

		//Result on the (m,n) of table
		return table[m][n];

	}

}
