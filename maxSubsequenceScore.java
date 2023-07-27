// Leetcode: 2542. Maximum Subsequence Score
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        // //merge nums1[i] and nums2[i] into pairs
        // //(nums1[i], nums2[i])

        // //sort pairs by nums2[i]

        // //having a min heap for top k elements of nums1

        // //iterate the pairs
        // //  add nums1[i] to sum of current nums1 s
        // //  add nums1[i] to  min heap
        // //
        // //  3 possibilities of min heap:
        // //      we reached k length
        // //          calculate multiplication (sum * nums2[i]) -> nums2[i] represents the smallest nums2 up to this iteration, this is because of the sort of pairs
        // //              and store the max
        // //      we are below k length
        // //          keep adding from nums1
        // //      we are above k length
        // //          remove the top from min heap (minimum number)
        // //          discount number from the sum
        // //
        // //return max

        // //resulting maximum score
        // long max = 0;

        // //pairs nums1[i], nums2[i]
        // int[][] pairs = new int[nums1.length][2];

        // for(int i = 0; i < nums1.length; i++){
        //     pairs[i] = new int[]{nums1[i], nums2[i]};
        // }

        // //sort pairs based on nums2 O(nlogn)
        // Arrays.sort(pairs, (a,b) -> b[1] - a[1]);

        // //Min Heap
        // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // //sum of k elements of nums1
        // long sum = 0;

        // //iterate pairs
        // for(int i = 0; i < pairs.length; i++){
        //     int num1 = pairs[i][0];
        //     int num2 = pairs[i][1];

        //     sum += num1;
        //     minHeap.offer(num1);

        //     //reached the neccesary length
        //     if(minHeap.size() == k){
        //         max = Math.max(max, (sum * num2));
        //     }

        //     //if above k length
        //     //remove the top from min heap (minimum number)
        //     //discount number from the sum
        //     if(minHeap.size() > k){
        //         int minimum = minHeap.poll();
        //         sum -= minimum;
        //     }

        //     //if below k length, keep iterating and adding to the heap
        //     System.out.println(minHeap.toString());
        // }

        // return max;
    //}


    //ABOVE APPROACH NOT WORKING//

        // Sort pair (nums1[i], nums2[i]) by nums2[i] in decreasing order.
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Use a min-heap to maintain the top k elements.
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        long topKSum = 0;
        for (int i = 0; i < k; ++i) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        
        // The score of the first k pairs.
        long answer = topKSum * pairs[k - 1][1];
        
        // Iterate over every nums2[i] as minimum from nums2.
        for (int i = k; i < n; ++i) {
            // Remove the smallest integer from the previous top k elements
            // then add nums1[i] to the top k elements.
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            
            // Update answer as the maximum score.
            answer = Math.max(answer, topKSum * pairs[i][1]);
        }
        
        return answer;
    
    }

}