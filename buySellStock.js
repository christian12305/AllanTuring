/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    //buy or sell on each day
    //return the max profit in total

    //loop through prices
    // if prices[i] < prices[i+1] (profitable)
    //  profit += prices[i+1] - prices[i] //acumulates every profit
    //return profit

    let profit = 0;

    //loop to store only the profitable buy/sell
    for(let i = 0; i <prices.length; i++){
        if(prices[i] < prices[i+1]){
            profit += prices[i+1] - prices[i];
        }
    }

    return profit;

};