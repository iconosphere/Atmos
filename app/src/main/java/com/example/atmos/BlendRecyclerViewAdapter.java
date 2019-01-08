package com.example.atmos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atmos.Blend;
import com.example.atmos.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BlendRecyclerViewAdapter extends RecyclerView.Adapter<BlendRecyclerViewAdapter.ViewHolder> {

    // Member variables
    private ArrayList<Blend> mBlendData;
    private Context mContext;

    BlendRecyclerViewAdapter(Context context, ArrayList<Blend> blendData) {
        mBlendData = blendData;
        mContext = context;
    }

    @NonNull
    @Override
    public BlendRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BlendRecyclerViewAdapter.ViewHolder holder, int position) {

        // Get current Blend.
        Blend currentBlend = mBlendData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentBlend);
    }

    @Override
    public int getItemCount() {
        return mBlendData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameText;
        private TextView mRecipeText;
        private TextView mDescriptionText;
        private TextView mDidYouKnowText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialise the views
            mNameText = itemView.findViewById(R.id.name);
            mRecipeText = itemView.findViewById(R.id.recipe);
            mDescriptionText = itemView.findViewById(R.id.description);
            mDidYouKnowText = itemView.findViewById(R.id.didYouKnow);
        }

        void bindTo(Blend currentBlend) {

            // Populate the textviews with data
            mNameText.setText(currentBlend.getName());
            mRecipeText.setText(currentBlend.getRecipe());
            mDescriptionText.setText(currentBlend.getDescription());
            mDidYouKnowText.setText(currentBlend.getDidYouKnow());
        }
    }
}
