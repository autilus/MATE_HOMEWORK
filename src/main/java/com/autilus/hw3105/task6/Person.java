package com.autilus.hw3105.task6;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder withName(String name) {
            person.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            person.age = age;
            return this;
        }

        public Builder withGender(String gender) {
            person.gender = gender;
            return this;
        }

        public Person build() {
            return person;
        }
    }
}
