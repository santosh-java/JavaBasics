package com.cisco.preparation.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;

public class SerializationPractice {
  public static void main(String[] args) {
    System.out.println("Serialising");
    try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(System.getProperty("user.dir", "."), "sample.ser")))) {
      Ser3 s = new Ser3(1, "Serialization Test", "Before Serialisation");
      System.out.println(String.join(",", "Before Serialisation: ", Integer.toString(s.getId()), s.getName(), s.getLastName()));
      oos.writeObject(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("De-serialising");
    try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(System.getProperty("user.dir", "."), "sample.ser")))) {
      Ser3 readObject = (Ser3) ois.readObject();
      System.out.println(String.join(",", "After De-Serialisation: ", Integer.toString(readObject.getId()), readObject.getName(), readObject.getLastName()));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

class Ser1 implements Serializable {
  private int id;
  private String name;
  private transient String nonStored;

  public Ser1(int id, String name, String nonStored) {
    this.id = id;
    this.name = name;
    this.nonStored = nonStored;
  }

  public String getNonStored() {
    return nonStored;
  }

  public void setNonStored(String nonStored) {
    this.nonStored = nonStored;
  }

  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    this.nonStored = "after de-serialisation";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Ser1.class.getSimpleName() + "[", "]")
      .add("id=" + id)
      .add("name='" + name + "'")
      .add("nonStored='" + nonStored + "'")
      .toString();
  }
}

class Ser2 {
  private int id;
  private String name;

  public Ser2() {
    System.out.println("Default Constructor invoked");
  }

  public Ser2(int id, String name) {
    System.out.println("Constructor invoked");
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Ser2.class.getSimpleName() + "[", "]")
      .add("id=" + id)
      .add("name='" + name + "'")
      .toString();
  }
}

class Ser3 extends Ser2 implements Serializable {
  private String lastName;

  public Ser3(int id, String name, String lastName) {
    super(id, name);
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Ser3.class.getSimpleName() + "[", "]")
      .add("lastName='" + lastName + "'")
      .toString();
  }
}