package com.qst.objectserialization.entry;

import java.io.Serializable;

import com.qst.objectserialization.activity.MainActivity.Gender;

/**
 * 用Serializable实现实例化的实体类
 * @author Kylin_admin
 *
 */
public class PersonSerializable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name = null;

    private Integer age = null;

    private Gender gender = null;
    

    public PersonSerializable() {
    }
    
    public PersonSerializable(String name, Integer age, Gender gender) {
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
    
}
