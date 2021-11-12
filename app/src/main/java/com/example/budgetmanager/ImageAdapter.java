package com.example.budgetmanager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return Cards.length; // return cars.length
    }
    @Override
    public Object getItem (int i) { return null;}
    @Override
    public  long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);

        }else{
            imageView = (ImageView) convertView;

        }
        imageView.setImageResource(Cards[position]);
        return imageView;
    }


    public Integer [] Cards ={ R.drawable.chase, R.drawable.discover, R.drawable.wells_fargo, R.drawable.citibank};
    public int Cards(int position) {
        return position;
    }

}
