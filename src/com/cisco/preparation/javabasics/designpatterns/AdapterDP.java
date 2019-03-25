package com.cisco.preparation.javabasics.designpatterns;

/**
 * Created by MSantoshGiriGovind on 12/22/2016.
 */
public class AdapterDP {
    public static void main(String[] args) {
        IDuck d = new Duck();
        ITurkey t = new Turkey();
        TurkeyAdapter ta = new TurkeyAdapter(t);
        DuckAdapter da = new DuckAdapter(d);
        displayMessages(d);
        displayMessages(ta);
        displayMessages(da);
    }
    private static void displayMessages(ITurkey t) {
        t.gobble();
        t.fly();
    }
    private static void displayMessages(IDuck d) {
        d.quack();
        d.fly();
    }
}

interface IDuck {
    public void quack();

    public void fly();
}

class Duck implements IDuck {
    @Override
    public void quack() {
        System.out.println("Duck quacks...");
    }

    @Override
    public void fly() {
        System.out.println("Duck is flying...");
    }
}

interface ITurkey {
    public void gobble();

    public void fly();
}

class Turkey implements ITurkey {

    @Override
    public void gobble() {
        System.out.println("Turkey gobbles...");
    }

    @Override
    public void fly() {
        System.out.println("Turkey only flies little distance...");
    }
}

class TurkeyAdapter implements IDuck {
    ITurkey turkey;

    public TurkeyAdapter(ITurkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}

class DuckAdapter implements ITurkey {
    IDuck duck;

    public DuckAdapter(IDuck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}

