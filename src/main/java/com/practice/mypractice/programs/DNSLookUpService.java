package com.practice.mypractice.programs;

import java.util.StringTokenizer;

public class DNSLookUpService {

    // psuedo code below:

    TreeNode root;

    class TreeNode {
        TreeNode[] children;
        String val;     // => digits or "."

        TreeNode(int v) {
            val = String.valueOf(v);
        }

        void init() {
            children = new TreeNode[2];
            // or children = new int[11];

        }
    }

    void init() {
        // populating root
    }

    boolean insert(String ip, String domainName) {

        if (getFromTree() != null) {
            // update the value
        } else {
            for (char ch : ip.toCharArray()) {
                StringTokenizer st = new StringTokenizer(domainName, ".");
                TreeNode temp = root;
                while (st.hasMoreTokens()) {
                    String segment = st.nextToken();
                    for (char ch2 : segment.toCharArray()) {
                        if (ch2 == '.') {
                            // create a TreeNode with Val "."
                        }
                        TreeNode child = temp.children[ch2 - '0'];
                        if (child == null) {
                            TreeNode newChild = new TreeNode(ch2 - '0');
                            temp.children[ch2 - '0'] = newChild;
                        }
                        temp = temp.children[ch2 - '0'];
                    }
                }
                temp.val = domainName;
            }
        }
        return true;
    }

    private String getFromTree() {
        return "";
    }
}


//      10.111.192.168
//      101.11.192.168


/*
Implement a reverse DNS lookup API service using tree structure

10.250.42.25 -> www.google.com
102.36.12.200 -> www.amazon.com


DNSLookUpService -
 - get (String ip)
 - insert (String ip, String domainName)
 - update (String ip, String domainName)
 - delete (String ip)


 0 - 255

1,2     = 9 pos                  1          1
0-9 + . = 11                     0          0
0-5 + . = 7 positions            .          2


              root
        10           102
      250  251      36  45
     42     42     12
     25           200


     trie


      root
    1       2
    0       1   2    3       4       5
  .   2
  2   .
  5   3
  0   6
  .




    */



/*


    StateMachineNode {
        String state;
        StateMachineNode[] outwardEdges;
        boolean hasSubStatemachine;
        StateMachineNode subNode;
        boolean isTerminal;
    }

    StateMachineHandler {

        + transitionStatus(order, inputVal);
        + rollUp();
        +

    }

    states = [{

    }]


*/