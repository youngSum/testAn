package com.lms.test;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lms.test.Students.Student;

public class MainActivity extends Activity {

    private ContentResolver resolver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button)findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
            	query();  
            }  
        });
	}
	
	public void query()
    {
        Uri uri=Student.CONTENT_URI;
        String[] PROJECTION=new String[]{
                Student._ID,
                Student.NMAE,
                Student.GENDER,
                Student.AGE
        };
        resolver=this.getContentResolver();
        Cursor cursor=resolver.query(uri, PROJECTION, null, null, null);
        //判断游标是否为空
        if(cursor.moveToFirst())
        {
            for(int i=0;i<cursor.getCount();)
            {
                cursor.moveToPosition(i);
                int id=cursor.getInt(0);//获得id
                String name=cursor.getString(1);//取得姓名
                String gender=cursor.getString(2);//取得性别
                int age=cursor.getInt(3);//取得年龄
                //输出日记
                TextView tv=(TextView)findViewById(R.id.textView1);
                tv.setText("id:"+id+" name:"+name+" gender:"+gender+" age:"+age);
                break;
            }
        }
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
