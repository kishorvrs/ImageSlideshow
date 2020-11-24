package com.example.imageslideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater inflator;
    public int[] images = {
                     R.drawable.img1,
                     R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9

    };

    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflator.inflate(R.layout.slideshow_layout,container,false);
        ImageView img=(ImageView) view.findViewById(R.id.imageView_id);
       // img.setImageResource(images[position]);

        Glide.with(context).load(images[position]).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Image"+( position + 1 ),Snackbar.LENGTH_LONG).show();

            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((LinearLayout)object);
    }
}
