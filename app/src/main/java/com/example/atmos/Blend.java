package com.example.atmos;

/**
 * Data model for each row of the RecyclerView
 */

public class Blend {

    // Member variables representing the title and further information about the blends.
    private String mName;
    private String mRecipe;
    private String mDescription;
    private String mDidYouKnow;

    // Constructor for the Blend data model.

    public Blend(String name, String recipe, String description, String didYouKnow) {
        mName = name;
        mRecipe = recipe;
        mDescription = description;
        mDidYouKnow = didYouKnow;
    }

    // Getters
    public String getName() {
        return mName;
    }

    public String getRecipe() {
        return mRecipe;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getDidYouKnow() {
        return mDidYouKnow;
    }
}
