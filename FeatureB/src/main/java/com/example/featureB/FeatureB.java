package com.example.featureB;

import android.content.Context;
import android.widget.Toast;

import com.example.featureloader.feature.IFeatureB;

public class FeatureB implements IFeatureB {
    @Override
    public void functionOfFeatureB(Context context) {
        Toast.makeText(context, "functionOfFeatureB", Toast.LENGTH_SHORT).show();
    }
}
