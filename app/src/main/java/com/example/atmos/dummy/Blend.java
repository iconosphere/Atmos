package com.example.atmos.dummy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "blend_table")
public class Blend {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "blend_name")
    public String mBlendName;

    @ColumnInfo(name = "blend_recipe")
    public String mBlendRecipe;

    @ColumnInfo(name = "blend_furtherinfo")
    public String mBlendFurtherInfo;

    @ColumnInfo(name = "blend_didyouknow")
    public String mBlendDidYouKnow;

    public Blend(int uid, String blendName, String blendRecipe, String blendFurtherInfo, String blendDidYouKnow) {
        this.uid = uid;
        mBlendName = blendName;
        mBlendRecipe = blendRecipe;
        mBlendFurtherInfo = blendFurtherInfo;
        mBlendDidYouKnow = blendDidYouKnow;
    }

    public static Blend[] populateData() {
        return new Blend[] {
                new Blend(1, "a", "b", "c", "d"),
                new Blend(2, "a", "b", "c", "d")
                // And so on
        };
    }
    public int getUid() {
        return uid;
    }

    public String getBlendName() {
        return mBlendName;
    }

    public String getBlendRecipe() {
        return mBlendRecipe;
    }

    public String getBlendFurtherInfo() {
        return mBlendFurtherInfo;
    }

    public String getBlendDidYouKnow() {
        return mBlendDidYouKnow;
    }
}
