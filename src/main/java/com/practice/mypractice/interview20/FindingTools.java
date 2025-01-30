package com.practice.mypractice.interview20;

/*
Salesforce Hackerrank Question 1:


A milling machine in a manufacturing facility has a tool change system. The tool changer holds n tools and some duplicate tools may be included. The operator must move through the tools one at a time, either moving left or right. The tool changer is circular, so when the last tool in the tools array is reached in either direction, the next tool is at the other end of the array.
Given the name of the next tool needed, determine the minimum number of left or right moves to reach it.
Example:
tools = ['ballendmill', 'keywaycutter', 'slotdrill', 'facemill']
startindex = 1
target = 'ballendmill'

The tool currently in use is keywaycutter at index 1. The desired tool is ballendmill at index 0.
It can be reached by moving right 3 steps or left 1 step. The minimum number of moves is 1.

Function Description:
Complete the function toolchanger in the editor below.

toolchanger has the following parameter (S):
str tools[n]: an array of tool names arranged in the order they appear in the tool changer
int startindex: index of the tool currently in use
str target: name of the tool needed

Returns:
int: minimum number of moves required to reach the needed tool

Constraints
• 1 ≤n ≤ 100
• 0 ≤ startindex ≤ n-1
• 1 ≤ lengths of tools[il and target ≤ 100
• target is in tools

Sample Input 0 :
____________________________________________
STDIN                   Function
-----                   --------
4                   →   tools[] size n = 4
ballendmill         →   tools = ['ballendmill','facemill', 'keywaycutter', 'slotdrill']
facemill
keywaycutter
slotdrill
1                   →   startIndex = 1
slotdrill           →   target = 'slotdrill'


Output: 2

Explanation 0
The tool in use is tools[startindex] = tools[1] = 'facemill'.
Move right or left 2 times to reach target = tools[3] =
slotdrill'.
____________________________________________

Sample Input 1 :
____________________________________________
STDIN                   Function
-----                   --------
4                   →   tools[] size n = 4
facemill            →   tools = ['facemill', 'slotdrill', 'ballendmill', 'ballendmill']
slotdrill
ballendmill
ballendmill
0                   →   startIndex = 0
ballendmill         →   target = 'ballendmill'

Output: 1

Explanation 1
The tool in use is tools[startindex] = tools[0] = 'facemill'.
The target exists at two locations. Move left 1 step
to target = tools[3] = 'ballendmill. Moving right 2 steps to
tools[2] = 'ballendmill' is not minimal.
____________________________________________

*/

import com.google.common.collect.Lists;

import java.util.List;

public class FindingTools {


    public static int toolchanger(List<String> tools, int startIndex, String target) {
        int n = tools.size(), curr = (startIndex + 1) % n, output = Integer.MAX_VALUE;
        while (curr != startIndex) {
            String tool = tools.get(curr);
            if (tool.equals(target)) {
                output = Math.min(Math.abs(curr - startIndex), n - Math.abs(curr - startIndex));
            }
            curr = (curr + 1) % n;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(toolchanger(Lists.newArrayList("ballendmill", "facemill", "keywaycutter", "slotdrill"),1, "slotdrill" ));
        System.out.println(toolchanger(Lists.newArrayList("facemill", "slotdrill", "ballendmill", "ballendmill"),0, "ballendmill" ));
    }
}
