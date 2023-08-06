package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private boolean ageSet = false;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if(age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
        this.ageSet = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if(name == null || surname == null)
            throw new IllegalStateException("Недостаточно данных");

        Person person = new Person(name, surname);

        if(ageSet) person.setAge(age);
        if(address != null) person.setAddress(address);

        return person;
    }
}
