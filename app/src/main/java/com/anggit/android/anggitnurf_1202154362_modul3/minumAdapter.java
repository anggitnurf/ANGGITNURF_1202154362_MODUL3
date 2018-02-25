package com.anggit.android.anggitnurf_1202154362_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Anggit Nur on 2/24/2018.
 */

class minumAdapter extends RecyclerView.Adapter<minumAdapter.minumanViewHolder> {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<drink> mMinumData;
    private Context mContext;

    minumAdapter(Context context, ArrayList<drink> sportsData) {
        this.mMinumData = sportsData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext, R.drawable.aqua);
        if (drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public minumAdapter.minumanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new minumanViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(minumanViewHolder holder, int position) {
        //Get the current minum
        drink currentDrink = mMinumData.get(position);

        //Bind the data to the views
        holder.bindTo(currentDrink);

    }

    @Override
    public int getItemCount() {
        return mMinumData.size();
    }

    static class minumanViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mMinumImage;
        private Context mContext;
        private drink mCurrentDrink;
        private GradientDrawable mGradientDrawable;
        private TextView mDetailDrink;

        minumanViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView) itemView.findViewById(R.id.merk);
            mInfoText = (TextView) itemView.findViewById(R.id.keterangan);
            mMinumImage = (ImageView)itemView.findViewById(R.id.drinksImage);
            mDetailDrink = (TextView)itemView.findViewById(R.id.detailDrink);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(drink currentDrink) {
            //Populate the textviews with data
            mTitleText.setText(currentDrink.getTitle());
            mInfoText.setText(currentDrink.getInfo());
            mDetailDrink.setText(currentDrink.getDetail());

            //Get the current sport
            mCurrentDrink = currentDrink;


            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentDrink.
                    getImageResource()).placeholder(mGradientDrawable).into(mMinumImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = drink.starter(mContext, mCurrentDrink.getTitle(),
                    mCurrentDrink.getImageResource(),mCurrentDrink.getDetail());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}

