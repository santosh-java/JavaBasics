package com.cisco.preparation.javabasics;

/**
 * Created by MSantoshGiriGovind on 12/15/2016.
 */
public class Employee {
    String name;
    String dept;

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    @Override
    public int hashCode() {
        return dept.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(!(obj instanceof Employee))
            return false;

        return this.name.equals(((Employee)obj).name);
//        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
