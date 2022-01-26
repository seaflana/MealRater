package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RatingDialog.SaveRatingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar ratingRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button saveButton = (Button) findViewById(R.id.buttonSave);
        final TextView ratingDisplayTextView = (TextView) findViewById(R.id.textRating2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingBar bar = (RatingBar) v;
                ratingDisplayTextView.setText("" + bar.getRating());
            }
        });
    }

    @Override
    public void didFinishRatingBar(RatingBar selectedRating) {

    }
}