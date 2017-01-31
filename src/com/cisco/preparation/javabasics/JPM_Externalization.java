package com.cisco.preparation.javabasics;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class JPM_Externalization {
	public static void main(String[] args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("child.ser")));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("child.ser")));) {
			ChildExt obj = new ChildExt(100);
			System.out.println("Val before serialization :" + obj.getVal());
			oos.writeObject(obj);
			oos.flush();

			ChildExt readObject = (ChildExt) ois.readObject();
			System.out.println("Val after deserialization : " + readObject.getVal());

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ParentExt {
	private int val;

	public ParentExt(int val) {
		System.out.println("ParentExt non-default constructor");
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}

class ChildExt extends ParentExt implements Externalizable {
	public ChildExt() {
		this(10);
		System.out.println("ChildExt default constructor");
	}

	public ChildExt(int val) {
		super(val);
		System.out.println("ChildExt non-default constructor");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getVal());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		setVal(in.readInt());
	}

}