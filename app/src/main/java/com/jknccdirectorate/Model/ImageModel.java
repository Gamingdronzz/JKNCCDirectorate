package com.jknccdirectorate.Model;

import android.graphics.Bitmap;

/**
 * Created by hp on 11-09-2017.
 */

public class ImageModel {
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public ImageModel(Bitmap bitmap) {

        this.bitmap = bitmap;
    }

}
