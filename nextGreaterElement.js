/**
 * Leetcode: 496. Next Greater Element I
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
    //iterating nums1
    //we determine the next greater element of nums2[j]
    //such that nums1[i] === nums2[j]
    //if no greater element, return -1

    //store nums1 in a map with its index
    //iterate nums2
    //if it exists in the map, find a greater element
    //store the greater element in the index given by the map of nums1

    // //ans
    // //default value -1
    // let ans = new Array(nums1.length).fill(-1);

    // //map of nums1
    // let map1 = new Map();

    // //store nums1
    // //[nums1[i], i]
    // for(let i = 0; i < nums1.length; i++){  
    //     map1.set(nums1[i], i);
    // }

    // //iterate nums2
    // for(let i = 0; i < nums2.length; i++){
    //     //exists in map?
    //     if(map1.has(nums2[i])){

    //         //starting on the next idx of current value in nums2
    //         for(let j = i + 1; j < nums2.length; j++){
    //             //greater elem found
    //             if(nums2[i] < nums2[j]){
    //                 let idx = map1.get(nums2[i]);
    //                 //store greater elem in the ans[idx]
    //                 ans[idx] = nums2[j];
    //                 break;
    //             }
    //         }
    //     }
    // }

    // return ans;

    //BRUTE FORCE SOLUTION O(n*m)//

    //MONOTONIC STACK SOLUTION//

    //ans
    //default value -1
    let ans = new Array(nums1.length).fill(-1);

    //map of nums1
    let map1 = new Map();

    //monotonic stack
    let stack = [];

    //store nums1
    //[nums1[i], i]
    for(let i = 0; i < nums1.length; i++){  
        map1.set(nums1[i], i);
    }

    //iterate nums2
    for(let i = 0; i < nums2.length; i++){

            //while stack not empty and curr element is greater than the top
            //  we found a greater element
            //insert current into stack

            //greater found
            while(stack.length !== 0 && stack[stack.length-1] < nums2[i]){

                let idx = map1.get(stack.pop());
                ans[idx] = nums2[i];
            }
            
            //exists in map?
            if(map1.has(nums2[i])){
                stack.push(nums2[i]);
            }
    }

    return ans;

    //O(n+m)//

    
};