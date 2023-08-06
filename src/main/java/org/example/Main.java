package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder()
                .setName("Антошка")
                .setSurname("Лопатов")
                .setAge(48)
                .build();

        //System.out.println(person.getName());

        PersonBuilder childBuilder = person.newChildBuilder()
                .setName("Филипп")
                .setAge(10);
        Person child = childBuilder.build();

        System.out.println(child.getName());
        System.out.println(child.getSurname());
        System.out.println(child.getAge());
    }
}