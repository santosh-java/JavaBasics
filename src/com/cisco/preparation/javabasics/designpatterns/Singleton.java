package com.cisco.preparation.javabasics.designpatterns;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7571673327613282939L;

	private static volatile Singleton INSTANCE = null;

	private Singleton() {
		if (INSTANCE != null) {
			throw new RuntimeException("Singleton instance cannot be initialized via constructor");
		}
	}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}

		return INSTANCE;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning of Singleton is not supported.");
	}

	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}
}

class Test {
	public static void main(String args[]) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		print(s1);
		print(s2);

		try {
			Class<?> clazz = Class.forName("com.cisco.preparation.javabasics.designpatterns.Singleton");
			Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
			defaultConstructor.setAccessible(true);
			Singleton newInstance = (Singleton) defaultConstructor.newInstance(null);
			print(newInstance);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void print(Singleton instance) {
		System.out.println(String.format("Singleton %d", instance.hashCode()));
	}
}

class MyTask implements Runnable {

	@Override
	public void run() {
		print(Singleton.getInstance());
	}

	private void print(Singleton instance) {
		System.out.println(String.format("Singleton %d", instance.hashCode()));
	}

}