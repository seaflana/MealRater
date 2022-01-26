package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.fragment.app.DialogFragment;

public class RatingDialog extends DialogFragment {

    RatingBar selectedRating;

    public interface SaveRatingListener {
        void didFinishRatingBar(RatingBar selectedRating);
    }

    public RatingDialog() {
        //Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.select_rating, container, false);

        final RatingBar rb = view.findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                final int numStars = ratingBar.getNumStars();
                ratingBar.getRating();
            }
        });

        Button saveButton = view.findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                saveItem(selectedRating);
            }
        });
        return view;
    }

    private void saveItem(RatingBar selectedRating) {
        SaveRatingListener activity = (SaveRatingListener) getActivity();
        activity.didFinishRatingBar(selectedRating);
        getDialog().dismiss();
    }
}
