//Leetcode: 208. Implement Trie (Prefix Tree)
//This class represents each Node in the trie
class TrieNode{
    //the nodes that descend from this node
    TrieNode[] children;
    //marks the last character of a word
    boolean endOfWord;

    public TrieNode(){
        //making it of length 26 since it can be any char from 'a' to 'z'
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class Trie {
    //root is an empty string
    public TrieNode root;
    
    public Trie() {
        //initializing the Trie
        root = new TrieNode();
    }
    
    public void insert(String word) {
        //for each character
        //determine if the first char is a children of the root node
        //
        //if not, initialize a new node and add to children
        //if it is a children, dont add and move to the node that contains that character
        //and also the next character on the string
        //at the last character of the string, mark the node containing the character
        //as an end of word by changing value to true

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
    
    public boolean search(String word) {

        //loop through characters
        //first character must be a children of the root node
        //we then iterate to that node, and also the next character
        //for each character, we determine if its a child of current node
        //if it is not, return false
        //else if we iterate and reach the last node and last character and that node
        //has its boolean value as true, return true
        
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){

            //gets the index for the character in children
            int idx = word.charAt(i) - 'a';

            //doesnt exists
            if(cur.children[idx] == null)
                return false;
            
            //compatible character with children
            cur = cur.children[idx];

        }

        return cur.endOfWord;
    }
    
    public boolean startsWith(String prefix) {

        //similar to the search
        //we move through the Trie and if one character is not compatible
        //with the node's children, return false
        //if we iterate through all characters 
        //return true

        TrieNode cur = root;

        for(int i = 0; i < prefix.length(); i++){

            //gets the index for the character in children
            int idx = prefix.charAt(i) - 'a';

            //doesnt exists
            if(cur.children[idx] == null)
                return false;
            
            //compatible character with children
            cur = cur.children[idx];

        }

        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */