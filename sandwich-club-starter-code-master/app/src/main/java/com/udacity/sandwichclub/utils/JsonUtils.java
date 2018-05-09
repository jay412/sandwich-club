package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        //JSON Objects
        JSONObject sandwich = new JSONObject(json);
        JSONObject name = sandwich.getJSONObject("name");

        JSONArray akaArray = name.getJSONArray("alsoKnownAs");
        JSONArray iArray = sandwich.getJSONArray("ingredients");

        //JSON attributes
        String mainName = name.getString("mainName");

        List<String> alsoKnownAs = new ArrayList<>();
        for(int i = 0; i < akaArray.length(); ++i){
            String e = akaArray.getString(i);
            alsoKnownAs.add(e);
        }

        String placeOfOrigin = sandwich.getString("placeOfOrigin");
        String description = sandwich.getString("description");
        String image = sandwich.getString("image");

        List<String> ingredients = new ArrayList<>();
        for(int j = 0; j < iArray.length(); ++j){
            String e = iArray.getString(j);
            ingredients.add(e);
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
