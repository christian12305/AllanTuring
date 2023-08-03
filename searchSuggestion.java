//Leetcode: 1268. Search Suggestions System
import java.util.*;
//////////////////////////////////////////////////////////////////////////////////////////

//This class represents each Node in the trie
class TrieNode{
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {
    public TrieNode root;
    //Stores 3 suggestions max
    List<String> preResult;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {

        TrieNode cur = root;

        //loop characters
        for(int i = 0; i < word.length(); i++){

            //gets the index for the character in children
            int idx = word.charAt(i) - 'a';

            //character is not available in children
            if(cur.children[idx] == null)
                cur.children[idx] = new TrieNode();
            
            //character is available in children

            //move to the next node
            cur = cur.children[idx];

        }
        //Mark the last character as the end of the string
        cur.endOfWord = true;

    }

    public void dfs(TrieNode cur, String prefix){

        //base case
        //when we reach 3 words completed
        //break the dfs
        if(preResult.size() == 3)
            return;
        
        //when word completed (in trie)
        if(cur.endOfWord == true)
            //add to preResult
            preResult.add(prefix);

        //DFS
        //iterate all 26 children to find a continuation from prefix
        for(Character c = 'a'; c <= 'z'; c++){
            //if cur has a children at this char
            //enter the DFS to the child
            //while adding the current child to the prefix for the next operation
            int idx = c-'a';
            if(cur.children[idx] != null){
                dfs(cur.children[idx], prefix + c);
            }
           
        }

    }

    public List<String> wordsStartingWith(String prefix){
        TrieNode cur = root;

        //initialize the preResult that will contain the 3 suggestions
        preResult = new ArrayList<String>();

        //loop to the last character of prefix
        //to know when we will start the dfs
        for(int i = 0; i < prefix.length(); i++){
            
            int idx = prefix.charAt(i) - 'a';

            if(cur.children[idx] == null){
                return preResult;
                
            }
            cur = cur.children[idx];
        }

        //send to the dfs the prefix and the last node in it
        dfs(cur, prefix);

        return preResult;
    }
    
}

 //////////////////////////////////////////////////////////////////////////////////////////

class Solution {
    Trie trie ;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        //construct a trie with the given strings in product
        trie = new Trie();
        for(String s : products){
            trie.insert(s);
        }

        //result
        List<List<String>> result = new ArrayList<>();

        //for each character of the searchWord string added
        //give 3 complete words suggestions
        String temp = "";
        for(int i = 0; i < searchWord.length(); i++){

            temp += searchWord.charAt(i);
            //in a DFS approach, find completed words from temp
            //and return only 3

            //we will enter the trie through temp
            //while storing the new suggestion string for each node
            //once we reach the last character of temp, we start the search
            //to search we want to enter to every available children
            //and iterate until endOfWord is true
            //when its true, return the word.
            //add all possible words until len is 3

            //add the three words for current prefix
            result.add(trie.wordsStartingWith(temp));


        }

        return result;
    }

    
}