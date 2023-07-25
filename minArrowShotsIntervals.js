/**
 * Leetcode: 452. Minimum Number of Arrows to Burst Balloons
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {

    //we want to return the minimum number of arrows to burst all balloons
    //so we then eliminate the most balloons possible with each arrow,
    //this is a greedy approach
    
    //as every interval problem, we must first sort
    //O(nlogn)
    //sort based on the y of each interval
    points.sort((a,b) => a[1] - b[1])

    //then we iterate through points, keeping overlapping intervals as one arrowCount
    //then if current interval is not overlapping with 
    // the smallest end of the overlapping intervals
    //we start new overlapping interval 

    //first intervals endpoint
    let lastEndpoint = points[0];

    //arrow count, 1 for the first interval
    let arrowCount = 1;

    //iterate through points
    for(let i = 1; i < points.length; i++){

        //not overlapping
        if(points[i][0] > lastEndpoint[1]){
            //new arrow for this new overlapping interval
            arrowCount++;
            //update last minimum Endpoint
            lastEndpoint = points[i];
        }

        //if its overlapping it will still consume 1 arrow
        // making sure that when overlapping, the endpoint of current
        // is less than the minimum endpoint (which comes from the first baloon interval)
    }

    return arrowCount

};