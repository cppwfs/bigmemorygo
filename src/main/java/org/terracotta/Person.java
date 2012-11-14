package org.terracotta;

import java.io.Serializable;


public class Person implements Serializable{
    private final String name;
    private final Integer age;
    private final String gender;

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}

	public Integer getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}



}
