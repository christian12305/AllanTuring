/**
 * Leetcode: 735. Asteroid Collision
 * @param {number[]} asteroids
 * @return {number[]}
 */
var asteroidCollision = function(asteroids) {
    //have a auxiliary stack
    //loop asteroids
    //      collision
    //      while stack.peek > 0 && asteroids[i] < 0
    //          asteroid[i] stays
    //          if math.abs(stack.peek) < math.abs(asteroids[i])
    //              stack.pop
    //              continue
    //
    //          both explode
    //          else if math.abs(stack.peek) === math.abs(asteroids[i])
    //              stack.pop
    //              (removes asteroid)
    //
    //          (hidden case)
    //          math.abs stack.peek() > math.abs asteroids[i]
    //          dont add asteroids[i]
    //
    //      add asteroid to stack if possible
    //
    //      
    //return our stack

    let stack = [];

    for(let i = 0; i < asteroids.length; i++){
            let explode = false;
        
            while(stack.length !== 0 && stack[stack.length-1] > 0 && asteroids[i] < 0){

                if(Math.abs(stack[stack.length-1]) < Math.abs(asteroids[i]) ){
                    stack.pop();
                    continue;
                }else if(Math.abs(stack[stack.length-1]) == Math.abs(asteroids[i])){
                    stack.pop();
                    //explode asteroids[i]
                    explode = true;
                }
                
                //explode asteroids[i] when Math.abs(stack[stack.length-1]) > Math.abs(asteroids[i])
                explode = true;
                break;
            }

            if(!explode){
                stack.push(asteroids[i]);
            }

        }
    

    return stack;
};