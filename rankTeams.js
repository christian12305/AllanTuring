/**
 * Leetcode: 1366. Rank Teams by Votes
 * @param {string[]} votes
 * @return {string}
 */
var rankTeams = function(votes) {

    //Map
    let map1 = new Map();

    //Iterate through each of the voters vote
    //Map each team/vote with its index + 1
    //Repeat and accumulate for all voters in the map

    //O(n*m)
    //n = voters
    //m = votes
    //Each voters
    for(let i = 0; i< votes.length; i++){
        //Each vote
        for(let j = 0; j < votes[i].length; j++){
            //undefined value : list
            if(!map1.get(votes[i][j])){
                let list = new Array(votes[i].length).fill(0);
                list[j] = 1;
                map1.set(votes[i][j], list);
            //defined list
            }else{
                if(map1.get(votes[i][j])[j]){
                    map1.get(votes[i][j])[j]++;
                }else{
                    map1.get(votes[i][j])[j] = 1;
                }
            }   
        }
    }

    //Sort map by value[i]
    //if a.value[i] != b.value[i]
    //  return a.value[i] - b.value[i]
    //else 
    //  continue until comparable value[i]
    //O(map1.keys.length * votes[0].length)
    let sortMap = [...map1.keys()].sort( (a,b) => {
        
        for(let i = 0; i < votes[0].length; i++){
            //Check each item in the value list
            // if they are not equal, sort
            if(map1.get(a)[i] != map1.get(b)[i]){
                return map1.get(b)[i] - map1.get(a)[i];
            }
        }

        //if two or more teams are tied after all, rank alphabetically
        return a.charCodeAt(0)-b.charCodeAt(0);
    });

    //Return map values
    return  sortMap.join('')

};