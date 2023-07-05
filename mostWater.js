/**
 * Leetcode: 11. Container With Most Water
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    //having left and right pointer
    //left = 0, right = end
    //
    //loop
    //height = minimum between height[left] and height[right]
    //length = right - left
    //calculate area
    //get max between old area and new area
    //increment left if height[left] < height[right]
    //else decrement right to find the largest area
    //
    //return the max

    let left = 0, right = height.length-1, result = 0;

    while(left <= right){
        //no slant height
        let h = Math.min(height[left], height[right])
        let l = right - left;

        let area = h * l;

        result = Math.max(result, area);

        //moves always towards the largest height inwards
        if(height[left] < height[right]){
            left++;
        }else{
            right--;
        }
    }

    return result;
};