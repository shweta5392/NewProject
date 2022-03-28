package com.example.newproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.newproject.R;

/**
 * Grocery App
 * https://github.com/quintuslabs/GroceryStore
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.pay, R.drawable.pay1, R.drawable.pay,R.drawable.pay1};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_slider, null);
        ImageView imageView = view.findViewById(R.id.imageView1);
        imageView.setImageResource(images[position]);
        TextView textView = view.findViewById(R.id.textView6);
        TextView textView1 = view.findViewById(R.id.textView7);
        switch (position){
            case 0:
                textView.setText(R.string.heading1);
                textView1.setText(R.string.data);
            case 1:
                textView.setText(R.string.heading2);
                textView1.setText(R.string.data1);

            case 2:
                textView.setText(R.string.heading3);
                textView1.setText(R.string.data2);

            case 3:
                textView.setText(R.string.heading4);
                textView1.setText(R.string.data1);

        }


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}