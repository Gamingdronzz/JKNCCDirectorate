package com.jknccdirectorate.Tools;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;


import com.jknccdirectorate.R;

import java.io.ByteArrayOutputStream;

import java.util.ArrayList;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Helper {
    public static final String ACTION = "action";
    public String FAILED = "failed";
    public String SUCCESS = "success";
    final String TAG = "Helper";
    public String baseURL = "http://www.jknccdirectorate.com/api/";
    private Context context;

    public Helper(Context context) {
        this.context = context;
    }

    public String getBaseURL() {
        return this.baseURL;
    }

    public JSONObject getJson(String input) {
        try {
            try {
                return new JSONObject(input.substring(input.indexOf("{"), input.indexOf("}") + 1));
            } catch (JSONException jse) {
                jse.printStackTrace();
                Log.v("Helper", "Error creating json");
                return null;
            }
        } catch (StringIndexOutOfBoundsException sioobe) {
            sioobe.printStackTrace();
            return null;
        }
    }

    public int getRandomMaterialColor(String typeColor) {
        int arrayId = this.context.getResources().getIdentifier("mdcolor_" + typeColor, "array", this.context.getPackageName());
        if (arrayId == 0) {
            return R.color.colorGray;
        }
        TypedArray colors = this.context.getResources().obtainTypedArray(arrayId);
        int returnColor = 0;

        returnColor = colors.getColor((int) (Math.random() * ((double) colors.length())), context.getResources().getColor(R.color.colorAccent));

        colors.recycle();
        return returnColor;
    }

    public String getStringFromList(List list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).toString().toLowerCase());
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        Log.v("Helper", "Final String : " + result.toString());
        return result.toString();
    }


    public List<String> getListFromString(String string) {
        String[] intermediate = string.split(",");
        List<String> result = new ArrayList();
        for (String toLowerCase : intermediate) {
            result.add(toLowerCase.toLowerCase());
        }
        Log.v("Helper", "List Result : " + result);
        return result;
    }


    public Intent getImageIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        return intent;
    }



    public byte[] getByteArrayFromBitmap(Bitmap image) {
        if (image == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }



    public Bitmap getBitmapFromString(String value) {
        byte[] inter = Base64.decode(value, 0);
        Log.d("Helper", "Byte Array = " + inter.toString());
        return BitmapFactory.decodeByteArray(inter, 0, inter.length);
    }



    public Bitmap getBitmapFromByteArray(byte[] value) {
        if (value != null) {
            return BitmapFactory.decodeByteArray(value, 0, value.length);
        }
        return null;
    }


    public Bitmap getBitmapFromResource(int res) {
        return BitmapFactory.decodeResource(this.context.getResources(), res);
    }


    public String checkForInput(String text) {
        if (text == null || text.length() == 0 || text.equals("")) {
            return null;
        }
        text = text.replaceAll("\\s+", "");
        if (text.length() == 0 || text.equals("")) {
            return null;
        }
        return text;
    }
}
