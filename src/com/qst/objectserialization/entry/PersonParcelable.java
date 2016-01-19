package com.qst.objectserialization.entry;

import android.os.Parcel;
import android.os.Parcelable;

import com.qst.objectserialization.activity.MainActivity.Gender;

/**
 * 用Parcelable实现实例化的实体类
 * @author Kylin_admin
 *
 */
public class PersonParcelable implements Parcelable {

    /**
	 * 
	 */

	private String name = null;

    private Integer age = null;

    private Gender gender = null;
    

    public PersonParcelable() {
        System.out.println("none-arg constructor");
    }
    
    public PersonParcelable(String name, Integer age, Gender gender) {
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

    /**
     * 实现describeContents方法，默认返回0即可
     */
    @Override
	public int describeContents() {
		return 0;
	}

    /**
     * 实现writeToParcel，写数据
     */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
        dest.writeInt(age);
        dest.writeInt(gender.ordinal());
	}
	
	/**
	 * 提供一个静态的实现Parcelable.Creator接口的对象常量引用且常量名为CREATOR，其中要重写两个方法：
	 *	<br/>- createFromParcel(Parcel in)  从Parcel容器中读取传递数据值，封装成Parcelable对象返回逻辑层。
	 *	<br/>- newArray(int size) 创建一个类型为T，长度为size的数组，一般是return new T[size]即可，该方法是供外部类反序列化本类数组使用。
	 */
	public static final Parcelable.Creator<PersonParcelable> CREATOR = new Creator<PersonParcelable>() {

        @Override
        public PersonParcelable createFromParcel(Parcel source) {
            PersonParcelable person = new PersonParcelable();
            person.name = source.readString();
            person.age = source.readInt();
            person.gender = Gender.values()[source.readInt()];
            return person;
        }

        //供反序列化本类数组时调用的
        @Override
        public PersonParcelable[] newArray(int size) {
            return new PersonParcelable[size];
        }
    };
}
