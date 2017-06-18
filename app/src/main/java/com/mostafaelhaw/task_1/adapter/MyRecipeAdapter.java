package com.mostafaelhaw.task_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.mostafaelhaw.task_1.R;
import com.mostafaelhaw.task_1.model.recipe;

import java.util.List;

/**
 * Created by mostafa_elhaw on 6/18/2017.
 */
public class MyRecipeAdapter extends ArrayAdapter<recipe> {


    List<recipe> recipeList;
    Context context;
    private LayoutInflater mInflater;

    public MyRecipeAdapter(Context context, List<recipe>objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        recipeList = objects;
    }
    @Override
    public recipe getItem(int position) {
        return recipeList.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        recipe item = getItem(position);

// here are the data wanted to be viewed ***********
        vh.textViewName.setText(item.getTitle());
        vh.textViewCategory.setText(item.getCategory());
        Picasso.with(context).load(item.getPhotoUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView textViewCategory;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewCategory) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewCategory = textViewCategory;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewCategory = (TextView) rootView.findViewById(R.id.textViewCategory);
            return new ViewHolder(rootView, imageView, textViewName, textViewCategory);
        }
    }
}