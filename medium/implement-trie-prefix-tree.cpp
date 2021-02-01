#include <map>
class Node{
    public:
    char c; 
    map<char, Node*> next;
    
    Node(char c){
        this->c = c;
    }
};

class Trie {
public:
    
    
    map<string, bool> mymap;
    map<char, Node*> first;
    /** Initialize your data structure here. */
    Trie() {
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        mymap[word] = true;
        Node * current;

        if ( first[word[0]] == nullptr){
            current = new Node(word[0]);
            first[word[0]] = current;
        } else{
            current = first[word[0]];
        }
        
        int i = 1;
        while (i<word.size()){
            char c = word[i];
            
            if (current->next[c] == nullptr){
                Node * temp = new Node(c);
                current->next[c] = temp; 
                current = temp; 
            } else {
                current = current->next[c];
            }
            i++;
        }
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        if (mymap[word] == true)
            return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        int i=0;
        Node * current = first[prefix[0]];
        if (current == nullptr){
            return false;       
        }
        i ++;
        while( i < prefix.size()){
            char c = prefix[i];
            if (current == nullptr){
                cout << prefix[i];
                cout << i;
                cout << prefix;
                return false;
            }
            
            current = current->next[c];
            i++;
        }
        
        cout << prefix << endl;
        cout << i << endl;
        if (i != prefix.size() || current  == nullptr){
          return false;  
        } 
        
        return true; 
    }
    
    // void print(){
    //     for(map<char, Node*>::const_iterator it = myMap.begin();
    //             it != myMap.end(); ++it)
    //         {
    //             cout << it->first << endl;
    //         }
    // }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
