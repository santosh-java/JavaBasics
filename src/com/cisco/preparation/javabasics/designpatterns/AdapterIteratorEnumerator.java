package com.cisco.preparation.javabasics.designpatterns;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by MSantoshGiriGovind on 12/22/2016.
 */
public class AdapterIteratorEnumerator {
    public static void main(String args[]) {
        ArrayList<String> al = new ArrayList<>();
        al.add("a");
        al.add("b");
        al.add("c");
        IterationAdapter ia = new IterationAdapter(al.iterator());
        while(ia.hasMoreElements())
        {
            System.out.println(ia.nextElement() + " ");
        }
    }
}

class IterationAdapter implements Enumeration {
    Iterator iterator;

    public IterationAdapter(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}