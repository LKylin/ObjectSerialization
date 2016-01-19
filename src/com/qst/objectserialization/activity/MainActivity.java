package com.qst.objectserialization.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.qst.objectserialization.R;
import com.qst.objectserialization.entry.PersonExternalizable;
import com.qst.objectserialization.entry.PersonParcelable;
import com.qst.objectserialization.entry.PersonSerializable;

public class MainActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    /**
     * 跳转SerializableActivity的点击事件
     * @param view
     */
    public void onClickSer(View view){
    	PersonSerializable person = new PersonSerializable("张三",20,Gender.MALE);
    	Intent intent = new Intent(this,SerializableActivity.class);
    	intent.putExtra("person", person);
    	startActivity(intent);
    }
    /**
     * 跳转PersonExternalizable的点击事件
     * @param view
     */
    public void onClickExt(View view){
    	PersonExternalizable person = new PersonExternalizable("张三",20,Gender.MALE);
    	Intent intent = new Intent(this,ExternalizableActivity.class);
    	intent.putExtra("person", person);
    	startActivity(intent);
    }
    /**
     * 跳转PersonParcelable的点击事件
     * @param view
     */
    public void onClickPar(View view){
    	PersonParcelable person = new PersonParcelable("张三",20,Gender.MALE);
    	Intent intent = new Intent(this,ParcelableActivity.class);
    	intent.putExtra("person", person);
    	startActivity(intent);
    }
    
    public enum Gender {
        MALE, FEMALE;
    }
}
