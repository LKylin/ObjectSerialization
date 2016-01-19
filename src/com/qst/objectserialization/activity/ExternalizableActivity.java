package com.qst.objectserialization.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.qst.objectserialization.R;
import com.qst.objectserialization.entry.PersonExternalizable;

public class ExternalizableActivity extends Activity {

	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_externalizable);
		tv = (TextView) findViewById(R.id.act_ext_tv);
		Intent intent = getIntent();
		PersonExternalizable person = (PersonExternalizable) intent.getSerializableExtra("person");
		StringBuffer sb = new StringBuffer().append("姓名：")
				.append(person.getName())
				.append("年龄：")
				.append(person.getAge())
				.append("性别：")
				.append(person.getGender());
		tv.setText(sb.toString());
	}
}
