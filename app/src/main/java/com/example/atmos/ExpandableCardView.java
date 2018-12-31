package com.example.atmos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.google.android.material.card.MaterialCardView;

public class ExpandableCardView extends MaterialCardView {

    public ExpandableCardView(Context context) {
        super(context);
    }

    public ExpandableCardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Get control after layout is complete.
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Remove listener so it won't be called again
                getViewTreeObserver().removeOnGlobalLayoutListener(this);

                // Get the view we want to insert into the LinearLayut called "card_body" and
                // remove it from the custom CardView.
                View childView = getChildAt(0);
                removeAllViews();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.expandable_card_view, ExpandableCardView.this, true);

                // Insert the view into the LinearLayout.
                ((LinearLayout) findViewById(R.id.card_body)).addView(childView);

                // And the rest of the stuff...
                TextView headingTextView = findViewById(R.id.card_heading);
                headingTextView.setText("THE HEADING");

                // set collapse/expand click listener
                ImageView collapseExpandButton = findViewById(R.id.collapse_expand_card_button);
                collapseExpandButton.setOnClickListener((View v) -> toggleCardBodyVisibility());
            }
        });
    }

    private void toggleCardBodyVisibility() {
        LinearLayout description = findViewById(R.id.card_body);
        ImageView imageButton = findViewById(R.id.collapse_expand_card_button);

        if (description.getVisibility() == View.GONE) {
            description.setVisibility(View.VISIBLE);
            imageButton.setImageResource(R.drawable.ic_arrow_up);
        } else {
            description.setVisibility(View.GONE);
            imageButton.setImageResource(R.drawable.ic_arrow_down);
        }
    }
}