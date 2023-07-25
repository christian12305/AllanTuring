/**
 * Leetcode: 435. Non-overlapping Intervals
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(intervals) {

    //for a greedy approach we want to get the most possible intervals
    // by getting the intervals with the minimum endpoints

    //if only one interval
    if(intervals.length < 2)
        return 0;

    //intervals[i] = [x,y]

    //O(nlogn)
    //first, sort based on the y of each interval
    intervals.sort((a,b) => a[1] - b[1])

    //pick intervals if the startpoint of curr interval is >= 
    //the last intervals endpoint
    //else
    //  increment the count of intervals not picked
    //
    //the first interval is picked always
    //and from there we compare

    let intervalsRemoved = 0;

    let lastEndpoint = intervals[0];

    //O(n)
    for(let i = 1; i < intervals.length; i++){
        //determine if we pick
        if(intervals[i][0] >= lastEndpoint[1]){
            //update the lastEndpoint
            lastEndpoint = intervals[i];
        //if not picked, increment the count of intervals removed.
        }else{
            intervalsRemoved++;
        }
    }

    return intervalsRemoved;
    
};