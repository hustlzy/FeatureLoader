package com.example.featureA;

import android.content.Context;
import android.widget.Toast;

import com.example.featureloader.feature.IFeatureA;

public class FeatureA implements IFeatureA {
    @Override
    public void functionOfFeatureA(Context context) {
        Toast.makeText(context, "functionOfFeatureA", Toast.LENGTH_SHORT).show();
    }
}
