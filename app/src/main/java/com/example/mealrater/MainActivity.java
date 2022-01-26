package com.example.mealrater;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView textView;
    private Button btnRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRating = (Button)findViewById(R.id.buttonRating2);
        textView = findViewById(R.id.textRating2);
        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View layout = null;
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    layout = inflater.inflate(R.layout.select_rating, null);
                    final RatingBar ratingBar = (RatingBar)layout.findViewById(R.id.ratingBar);
                    builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            Float value = ratingBar.getRating();
                            textView.setText(Float.toString(ratingBar.getRating()));
                            Toast.makeText(MainActivity.this, "Rating is : " + value, Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setCancelable(false);
                    builder.setView(layout);
                    builder.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}