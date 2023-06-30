
import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {
		 int nums1[] = {0}, m = 0, nums2[] = {1}, n = 1;
		 
		 merge(nums1, m, nums2, n);
		 
		 System.out.println(Arrays.toString(nums1));
	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		//Pointers
		int i = m-1;
		int j = n-1;
		int k = nums1.length-1;
		
		while(j >= 0) {
			
			if(i >= 0 && nums1[i] > nums2[j]) {
				nums1[k] = nums1[i];
				i--;
				k--;
			}
			
			else {
				nums1[k] = nums2[j];
				j--;
				k--;
			}
				
			
		}

	}
}
