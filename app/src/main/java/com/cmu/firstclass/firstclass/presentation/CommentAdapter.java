package com.cmu.firstclass.firstclass.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmu.firstclass.firstclass.R;

import java.util.List;

/**
 * Created by tangnianzu on 4/11/15.
 */
public class CommentAdapter extends ArrayAdapter {

    public CommentAdapter(Context context, List<String> array) {
        super(context, R.layout.comment_list_row, array);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.comment_list_row, parent, false);


        ImageView ivComment=(ImageView)view.findViewById(R.id.ivComment);
        ivComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CommentAdapter.this.getContext(),UserProfile.class);
                CommentAdapter.this.getContext().startActivity(i);
            }
        });
        TextView tvComment = (TextView) view.findViewById(R.id.tvComment);

        // TODO get image from server
        // TODO get text from server

        // TODO DELETE the following demonstration code
        ivComment.setImageResource(R.drawable.user2);

        String comments = (String) getItem(position);
        tvComment.setText(comments);

        return view;
    }
}
