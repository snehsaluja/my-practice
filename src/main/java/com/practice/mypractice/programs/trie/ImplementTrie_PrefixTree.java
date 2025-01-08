package com.practice.mypractice.programs.trie;

import com.practice.mypractice.programs.trie.lowercaseonly.Trie_LowerCase;

public class ImplementTrie_PrefixTree {

    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
        System.out.println(param_2);
        System.out.println(param_3);


        //--------------------------------

        Trie_LowerCase obj2 = new Trie_LowerCase();
        obj2.insert("apple");
        boolean param_4 = obj2.search("apple");
        boolean param_5 = obj2.startsWith("app");
        System.out.println(param_4);
        System.out.println(param_5);
    }

}
