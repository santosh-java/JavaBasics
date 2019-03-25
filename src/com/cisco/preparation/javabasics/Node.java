package com.cisco.preparation.javabasics;

/**
 * Created by MSantoshGiriGovind on 12/14/2016.
 */
/* Class containing left and right child of current
 node and key value*/
class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

