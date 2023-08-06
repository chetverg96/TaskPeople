package org.example;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private boolean ageSet = false;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean hasAge() {
        return ageSet;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if(hasAge())
            return age;
        else
            throw new IllegalStateException("Age is not set");
    }

    public String getAddress() {
        if(hasAddress())
            return address;
        else
            throw new IllegalStateException("Address is not set");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (ageSet)
            age++;
        else
            throw new IllegalStateException("Can't have birthday without an age");
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address);
    }

    protected void setAge(int age){
        if(age < 0) throw new IllegalArgumentException("Age can't be negative");
        this.age = age;
        this.ageSet = true;
    }
}
