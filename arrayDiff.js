/**
 * Leetcode: 2215. Find the Difference of Two Arrays
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[][]}
 */
var findDifference = function(nums1, nums2) {
    //store each value from nums1 into map1
    //do the same for nums2 to map2

    //loop nums1
    //  if nums1[i] does not exists in map2
    //      append to list1
    //loop nums2
    //  if nums2[i] does not exists in map1
    //      append to list2
    //append list1 and list2 to our result

    let map1 = new Map();
    let list1 = [];
    let map2 = new Map();
    let list2 = [];

    nums1.forEach(elem =>{
        map1.set(elem, 1)
    });

    nums2.forEach(elem =>{
        map2.set(elem, 1)
    });

    nums1.forEach(elem =>{
        if(!map2.has(elem) && map1.has(elem)){
            list1.push(elem);
            map1.delete(elem);
        }
    });

    nums2.forEach(elem =>{
        if(!map1.has(elem) && map2.has(elem)){
            list2.push(elem);
            map2.delete(elem);
        }
    });

    return [[...list1], [...list2]];
};