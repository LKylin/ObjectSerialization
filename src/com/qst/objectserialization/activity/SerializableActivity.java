package com.qst.objectserialization.activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.qst.objectserialization.R;
import com.qst.objectserialization.activity.MainActivity.Gender;
import com.qst.objectserialization.entry.PersonSerializable;

public class SerializableActivity extends Activity {

	TextView tv;
	TextView tvFromFile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_serializable);
		tv = (TextView) findViewById(R.id.act_ser_tv);
		tvFromFile = (TextView) findViewById(R.id.act_ser_tv_file);
		Intent intent = getIntent();
		PersonSerializable person = (PersonSerializable) intent.getSerializableExtra("person");
		StringBuffer sb = new StringBuffer().append("姓名：")
				.append(person.getName())
				.append("年龄：")
				.append(person.getAge())
				.append("性别：")
				.append(person.getGender());
		tv.setText(sb.toString());
	}
	
	public void onClickWriteToFile(View view){
		try {
			writeObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onClickReadFromFile(View view){
		try {
			readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 写对象到文件
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void writeObject() throws FileNotFoundException, IOException, ClassNotFoundException{
    	File file = new File(getFilesDir(),"person.ser");
    	//序列化对象写入到文件应该用ObjectOutputStream
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        PersonSerializable person = new PersonSerializable("John", 101, Gender.MALE);
        oout.writeObject(person);
        oout.close();
    }
	
	/**
	 * 从文件读数据
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject() throws FileNotFoundException, IOException, ClassNotFoundException{
    	File file = new File(getFilesDir(),"person.ser");
    	//读序列化文件应该用ObjectInputStream
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); 
        oin.close();
        tvFromFile.setText(newPerson.toString());
    }
}
