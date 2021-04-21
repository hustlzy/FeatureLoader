package com.example.featureloader.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.featureloader.R;
import com.example.featureloader.feature.IFeature;
import com.example.featureloader.feature.IFeatureA;
import com.example.featureloader.feature.IFeatureB;

import java.util.Optional;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button featureAButton = findViewById(R.id.featureA);
        Button featureBButton = findViewById(R.id.featureB);

        Optional<IFeatureA> optionalIFeatureA = loadFeature(IFeatureA.CLASS_NAME);
        optionalIFeatureA.ifPresent(iFeatureA -> {
            featureAButton.setVisibility(View.VISIBLE);
            featureAButton.setOnClickListener(view -> iFeatureA.functionOfFeatureA(view.getContext()));
        });

        Optional<IFeatureB> optionalIFeatureB = loadFeature(IFeatureB.CLASS_NAME);
        optionalIFeatureB.ifPresent(iFeatureB -> {
            featureBButton.setVisibility(View.VISIBLE);
            featureBButton.setOnClickListener(view -> iFeatureB.functionOfFeatureB(view.getContext()));
        });
    }

    private <T extends IFeature> Optional<T> loadFeature(String className) {
        T feature = null;
        try {
            feature = (T) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(feature);
    }
}