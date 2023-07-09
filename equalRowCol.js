/**
 * Leetcode: 2352. Equal Row and Column Pairs
 * @param {number[][]} grid
 * @return {number}
 */
var equalPairs = function(grid) {
    //store in a map each row with its frequency
    //  row would be converted to a string for comparison purposes
    //
    //loop columns
    //  if column is in the map
    //      increment counter by its frequency

    let counter = 0;
    let map = new Map();

    //rows
    for(let i = 0; i < grid.length; i++){
        let rowStr = grid[i].toString();
        map.has(rowStr) ? map.set(rowStr, map.get(rowStr) + 1 ) : map.set(rowStr, 1);
    }

    //col
    for(let col = 0; col < grid[0].length; col++){

        let column = [];
        //row
        for(let row = 0; row < grid.length; row++){
            column.push(grid[row][col]);
        }

        let columnStr = column.toString();

        if(map.has(columnStr)){
            counter += map.get(columnStr);
        }
    }

    return counter;
};