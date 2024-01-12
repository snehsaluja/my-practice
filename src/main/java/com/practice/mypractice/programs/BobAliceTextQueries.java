package com.practice.mypractice.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import com.google.common.collect.Lists;

public class BobAliceTextQueries {

    public static List<List<Integer>> textQueries(List<String> sentences, List<String> queries) {

        List<Set<String>> querySet = new ArrayList<>();
        for (String query : queries) {
            StringTokenizer tokenizer = new StringTokenizer(query, " ");
            Set<String> set = new HashSet<>();
            putInHashSet(tokenizer, set);
            querySet.add(set);
        }

        List<Set<String>> sentenceList = new ArrayList<>();
        for (int i = 0; i < sentences.size(); i++) {
            String sentence = sentences.get(i);
            StringTokenizer tokenizer = new StringTokenizer(sentence, " ");
            Set<String> sentenceSet = new HashSet<>();
            putInHashSet(tokenizer, sentenceSet);
            sentenceList.add(sentenceSet);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Set<String> queryInnerSet : querySet) {
            boolean presentAtLeastOnce = false;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sentenceList.size(); i++) {
                Set<String> innerSentenceSet = sentenceList.get(i);
                if (presentInSentence(queryInnerSet, innerSentenceSet, i)) {
                    presentAtLeastOnce = true;
                    list.add(i);
                }
            }
            if(presentAtLeastOnce)
                result.add(list);
            else
                result.add(Lists.newArrayList(-1));
        }

        return result;
    }

    private static boolean presentInSentence(Set<String> queryInnerSet, Set<String> innerSentenceSet, int sentenceNumber) {
        for (String q : queryInnerSet) {
            if (!innerSentenceSet.contains(q)) {
                return false;
            }
        }
        return true;
    }

    private static void putInHashSet(StringTokenizer tokenizer, Set<String> set) {
        while (tokenizer.hasMoreTokens()) {
            set.add(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        List<String> sentences = Lists.newArrayList("bob and alice like to text each other",
                "bob does not like to ski but does not like to fall",
                "Alice likes to ski");
        List<String> queries = Lists.newArrayList("bob alice", "alice", "like", "non occurrence");
        System.out.println(textQueries(sentences, queries));

        System.out.println(textQueries(Lists.newArrayList("jim likes mary",
                "kate likes tom",
                "tom does not like jim"),Lists.newArrayList("jim tom", "likes")));

    }
}
