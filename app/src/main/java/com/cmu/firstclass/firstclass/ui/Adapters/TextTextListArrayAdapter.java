package com.cmu.firstclass.firstclass.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cmu.firstclass.firstclass.R;

import java.util.List;

/**
 * Created by jialiangtan on 4/4/15.
 */
public class TextTextListArrayAdapter extends ArrayAdapter {
    public TextTextListArrayAdapter(Context context, List<String> array) {
        super(context, R.layout.text_text_list_row, array);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.text_text_list_row, parent, false);

        TextView scoreTextView = (TextView) view.findViewById(R.id.textTextListRowScoreTextView);
        TextView courseNameTextView = (TextView) view.findViewById(R.id.textTextListRowCourseNameTextView);

        // TODO DELETE this and put score retrieving from course object in the text view
        scoreTextView.setText("5.0");
        scoreTextView.setBackgroundColor(0xffff8f22);

        String courseName = (String) getItem(position);
        courseNameTextView.setText(courseName);

        return view;
    }
}
