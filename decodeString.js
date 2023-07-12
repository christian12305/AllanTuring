/**
 * Leetcode: 394. Decode String
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    // [ -> opening
    // ] -> closing
    //
    //loop items of s
    //  if item != ]
    //      add item to stack
    //  else if item == ]
    //      pop from stack and store in substring until [
    //      pop the number and store in k
    //      repeat and store substring k
    //      add the repeated substring to stack
    //
    //return stack
    let stack = [];

    //looping s
    for(let i = 0; i < s.length; i++){
        
        if(s[i] !== ']'){
            stack.push(s[i]);
        }else{

            //substring
            let substring = '';
            while(stack[stack.length-1] !== '['){
                substring += stack.pop();
            }
            //reverse substring
            let revSub = ''
            for(let i = substring.length-1; i >= 0; i--){
                revSub += substring[i];
            }
            substring = revSub;

            //pop to skip the '['
            stack.pop();

            //k
            let k = [];
            while(/\d/.test(stack[stack.length-1]) ){
                k.push(stack.pop());
            }
            //reverse number
            let revK = [];
            for(let i = k.length-1; i >= 0; i--){
                revK.push(k[i]);
            }
            k = revK;

            k = Number.parseInt(k.join(""));

            let temp = '';
            //repeat substring k times
            for(let i = 0; i < k; i++){
                temp += substring;
            }

            //pushes repeated string back to stack character by character
            stack.push(...temp);


        }

    }//for

    return stack.join("");

};