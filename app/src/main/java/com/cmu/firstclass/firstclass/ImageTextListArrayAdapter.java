package com.cmu.firstclass.firstclass;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jialiangtan on 4/3/15.
 */
public class ImageTextListArrayAdapter extends ArrayAdapter{

    public ImageTextListArrayAdapter (Context context, String[] imageUrlArray, String[] textArray) {
        super(context, R.layout.image_text_list_row, textArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.image_text_list_row, parent, false);

        ImageView departmentImageView = (ImageView) view.findViewById(R.id.departmentImageView);
        TextView departmentTextView = (TextView) view.findViewById(R.id.deparmentTextView);

        // TODO get image from server
        // TODO get text from server

        // TODO DELETE the following demonstration code
        departmentTextView.setText((String) getItem(position));
        departmentImageView.setImageResource(R.drawable.ece);

        // getting phone size
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        // set height relative to window size
        view.getLayoutParams().height = (height/8);
        return view;
    }
}
