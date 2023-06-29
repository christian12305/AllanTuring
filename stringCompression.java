/*
 * Leetcode: 443. String Compression
 *
 */
class Solution {
    public int compress(char[] chars) {

        //given an array
        //traverse the array with two pointers
        //pointer1 = 0
        //while pointer1 < length:
        //counter = 0
        //pointer2 = pointer1 + 1
        //
            //while pointer2 <length:
            //  if pointer1 != pointer2
            //      store char
            //      store count
            //      
            //      break;
            //  else 
            //      counter++
            //      pointer2++;
            //
        //pointer1 = pointer2

        int pointer1 =0;
        StringBuilder str = new StringBuilder();

        while(pointer1 < chars.length){
            int letterCount = 1;
            int pointer2 = pointer1+1;
            while(pointer2 < chars.length){
                if(chars[pointer1] != chars[pointer2]){
                    str.append(chars[pointer1]);
                    if(letterCount != 1){
                        str.append(letterCount);
                    }
                    break;
                }else{
                    letterCount++;
                    pointer2++;
                }
            }//loop2

            //To store the last value
            if(pointer2 >= chars.length){
                str.append(chars[pointer1]);
                if(letterCount != 1){
                    str.append(letterCount);
                }
            }

            pointer1 = pointer2;

        }//loop1

        for(int i = 0; i < str.length(); i++){
            chars[i] = str.charAt(i);
        }

        return str.length();
    }

}