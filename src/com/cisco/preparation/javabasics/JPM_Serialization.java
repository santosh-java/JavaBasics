package com.cisco.preparation.javabasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JPM_Serialization {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("child.ser")));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("child.ser")));) {
			Child obj = new Child(10);
			System.out.println("Val before serialization :" + obj.getVal());
			oos.writeObject(obj);
			oos.flush();

			Child readObject = (Child) ois.readObject();
			System.out.println("Val after deserialization : " + readObject.getVal());

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Parent {
	private int val;

	Parent() {
		val = 100;
	}

	Parent(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}
}

class Child extends Parent implements Serializable {

	Child(int val) {
		super(val);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7686745662853310902L;

}