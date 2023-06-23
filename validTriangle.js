/**
 * Leetcode: 611. Valid Triangle Number
 * @param {number[]} nums
 * @return {number}
 */
var triangleNumber = function(nums) {

    //Minimum of 3 elements (2 cathetus and hypothenuse to build triangle)
    if(nums.length < 3){
        return 0;
    }

    let count = 0;

    //sort is o(nlogn) descending
    nums.sort((a,b) => a-b);

    //i marks hypothenuse
    for(let i = 2; i < nums.length; i++){
        //j,k cathetus
        let j = 0, k = i - 1;
        //Traverse possibilities
        while(j < k){
            //3 elements found that achieve
            // nums[j] + nums[k] > nums[i]
            if(nums[j] + nums[k] > nums[i]){
                count += k - j;
                //This reduction helps count the possible pairs behind k
                k--;
            }else{
                //Moves the left pointer to search for more possible answers
                j++;
            }
        }
    }
    return count;

};