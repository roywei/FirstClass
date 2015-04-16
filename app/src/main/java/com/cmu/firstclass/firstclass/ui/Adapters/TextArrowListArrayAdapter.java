package com.cmu.firstclass.firstclass.ui.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmu.firstclass.firstclass.R;
import com.cmu.firstclass.firstclass.entities.IDNameDuple;
import com.cmu.firstclass.firstclass.ui.CourseActivity;

import java.util.List;

/**
 * Created by jialiangtan on 4/11/15.
 */
public class TextArrowListArrayAdapter extends ArrayAdapter {

    public TextArrowListArrayAdapter(Context context, List<IDNameDuple> list) {
        super(context, R.layout.text_arrow_list_row, list);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.text_arrow_list_row, parent, false);
        ImageView arrowView = (ImageView) view.findViewById(R.id.textImageListarrowImageView);
        TextView textView = (TextView) view.findViewById(R.id.textImageListRowTextView);

        textView.setText((CharSequence) ((IDNameDuple) getItem(position)).getName());
        arrowView.setImageResource(R.drawable.ic_action_next_item_grey);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseID = ((IDNameDuple)TextArrowListArrayAdapter.this.getItem(position)).getId();
                Intent intent = new Intent(TextArrowListArrayAdapter.this.getContext(), CourseActivity.class);
                intent.putExtra("courseID", courseID);
                TextArrowListArrayAdapter.this.getContext().startActivity(intent);
            }
        });
        return view;
    }
}
