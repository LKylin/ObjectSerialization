package com.qst.objectserialization.entry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.qst.objectserialization.activity.MainActivity.Gender;

/**
 * 用Externalizable实现实例化的实体类
 * @author Kylin_admin
 *
 */
public class PersonExternalizable implements Externalizable{

    /**
	 * 
	 */

	private String name = null;

//    transient private Integer age = null;
    private Integer age = null;

    private Gender gender = null;
    

    public PersonExternalizable() {
        System.out.println("none-arg constructor");
    }
    
    public PersonExternalizable(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }

	@Override
	public void readExternal(ObjectInput input) throws IOException,
			ClassNotFoundException {
		name = (String) input.readObject();
		age = (Integer) input.readObject();
		gender = (Gender) input.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput output) throws IOException {
		output.writeObject(name);
		output.writeObject(age);
		output.writeObject(gender);
	}
}
