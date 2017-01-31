package com.cisco.preparation.javabasics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSantoshGiriGovind on 12/15/2016.
 */
public class HashTest {
    public static void main(String args[]){
        Map<Employee, Integer> employeMap = new HashMap<>();
        employeMap.put(new Employee("one", "D1"), 1);
        employeMap.put(new Employee("tow", "D2"), 2);
        employeMap.put(new Employee("thre", "D3"), 3);
        Employee e = new Employee("four", "D4");
        employeMap.put(e, 4);

        System.out.println(employeMap.size() + " " + employeMap.get(new Employee("fourfddfdd", "D4")));
    }
}
