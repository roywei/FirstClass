package com.cmu.firstclass.firstclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by jialiangtan on 4/11/15.
 */
public class TextArrowListArrayAdapter extends ArrayAdapter {

    public TextArrowListArrayAdapter(Context context, List<String> list) {
        super(context, R.layout.text_arrow_list_row, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.text_arrow_list_row, parent, false);
        ImageView arrowView = (ImageView) view.findViewById(R.id.textImageListarrowImageView);
        TextView textView = (TextView) view.findViewById(R.id.textImageListRowTextView);

        arrowView.setImageResource(R.drawable.ic_action_next_item_grey);
        textView.setText((CharSequence) getItem(position));

        return view;
    }
}
