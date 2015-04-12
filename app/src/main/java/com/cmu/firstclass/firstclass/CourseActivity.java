package com.cmu.firstclass.firstclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class CourseActivity extends Activity implements View.OnClickListener {


    ImageView instructorImage;
    ImageView lisaImage;
    Intent i;
    ListView lvcomment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_page);

        instructorImage=(ImageView)findViewById(R.id.bob);
        lisaImage=(ImageView)findViewById(R.id.user2Img);


        Button submitReview = (Button)findViewById(R.id.SR);
        submitReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, SubmitReview.class);
                startActivity(intent);
            }
        });




        String[] listInfo={"this course is great!","This course freaking sucks!","I love this course!","I hate it!"};

        List<String> infoList = Arrays.asList(listInfo);

        ListAdapter listInfoAdapter=new CommentAdapter(this,infoList);
        ListView listView=(ListView)findViewById(R.id.lvComment);
        listView.setAdapter(listInfoAdapter);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.bob:
                i = new Intent(this, InstructorActivity.class);
                startActivity(i);
                break;

            case R.id.user2Img:
                i = new Intent(this, UserProfile.class);
                startActivity(i);
                break;
        }








    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
