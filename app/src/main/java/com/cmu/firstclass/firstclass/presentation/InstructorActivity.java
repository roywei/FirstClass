package com.cmu.firstclass.firstclass.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.cmu.firstclass.firstclass.R;
import com.cmu.firstclass.firstclass.entities.IDNameDuple;

import java.util.ArrayList;
import java.util.List;


public class InstructorActivity extends Activity{

    TextView tvCourse;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_page);

        List<IDNameDuple> courseIdNameList = new ArrayList<>();
        courseIdNameList.add(new IDNameDuple("2", "baobi de ke"));
        TextArrowListArrayAdapter listArrayAdapter = new TextArrowListArrayAdapter(this, courseIdNameList);

        ListView listView = (ListView) findViewById(R.id.instructingCourseListView);
        listView.setAdapter(listArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instructor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
