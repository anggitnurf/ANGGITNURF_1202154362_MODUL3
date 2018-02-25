package com.anggit.android.anggitnurf_1202154362_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Anggit Nur on 2/24/2018.
 */

class drink {
    //Member variables representing the title, image and information about the drinks
    private final String title;
    private final String info;
    private final int imageResource;
    private final String detailDrink;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";
    static final String DETAIL_KEY = "Detail";

    //Constructor for the drink class data model
    drink(String title, String info, int imageResource, String detailDrink) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.detailDrink = detailDrink;
    }

    //Gets the title of the drinks
    String getTitle() { return title; }

    //Gets the info about the drinks
    String getInfo() {
            return info;
        }

    //Gets the resource for the image
    int getImageResource() {
            return imageResource;
        }

    //Gets the detail drinks
    String getDetail() {
        return detailDrink;
    }

    //Method for creating  the Detail Intent
    public static Intent starter(Context context, String title, @DrawableRes int imageResId,String detailDrink ) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        detailIntent.putExtra(DETAIL_KEY, detailDrink);
        return detailIntent;
    }
}
