package com.cmu.firstclass.firstclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class DepartmentListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        // TODO DELETE the demon array
        String[] array = {"pikachu", "super mario", "sonic", "micky", "bruno the dog", "donald duck"
                , "aladar", "aladdin", "bear", "hugo", "yo-yo", "conan", "winston", "winnie the pool"
                , "christopher robin"};

        ListAdapter departmentListAdapter = new ImageTextListArrayAdapter(this, null, array);
        ListView listView = (ListView) findViewById(R.id.departmentListView);
        listView.setAdapter(departmentListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO go to the department page
                Intent intent = new Intent(DepartmentListActivity.this, DepartmentCourseListActivity.class);
                startActivity(intent);
            }
        });
        // TODO DELETE the demon array

        // TODO setting up the navigation drawer based on whether it is an admin or normal user
        ImageView navigationPicImageView = (ImageView) findViewById(R.id.navigationPicImageView);
        navigationPicImageView.setImageResource(R.drawable.pikachu);
        TextView navigationUserNameTextView = (TextView) findViewById(R.id.navigationUserNameTextView);
        navigationUserNameTextView.setText("User Name");

        ListAdapter navigationListAdapter = new ImageTextListArrayAdapter(this, null, array);
        ListView navigationListView = (ListView) findViewById(R.id.navigationListView);
        navigationListView.setAdapter(navigationListAdapter);

        navigationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DepartmentListActivity.this, UserProfile.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_department_list, menu);
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
