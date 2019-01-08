package com.example.atmos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BlendRecyclerViewAdapter extends RecyclerView.Adapter<BlendRecyclerViewAdapter.ViewHolder> {

    // Member variables
    private ArrayList<Blend> mBlendData;
    private Context mContext;
    private int mExpandedPosition = -1;
    private int mPreviousExpandedPosition = -1;
    private RecyclerView mRecyclerView = null;

    BlendRecyclerViewAdapter(Context context, ArrayList<Blend> blendData) {
        mBlendData = blendData;
        mContext = context;
    }

    @NonNull
    @Override
    public BlendRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }
/*    final boolean isExpanded = position==mExpandedPosition;
holder.details.setVisibility(isExpanded?View.VISIBLE:View.GONE);
holder.itemView.setActivated(isExpanded);
holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mExpandedPosition = isExpanded ? -1:position;
            TransitionManager.beginDelayedTransition(recyclerView);
            notifyDataSetChanged();
        }
    });*/
    @Override
    public void onBindViewHolder(@NonNull BlendRecyclerViewAdapter.ViewHolder holder, int position) {

        // Get current Blend.
        Blend currentBlend = mBlendData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentBlend);

        final boolean isExpanded = position == mExpandedPosition;
        holder.mDescriptionText.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.mDidYouKnowText.setVisibility(isExpanded?View.VISIBLE:View.GONE);

        if (isExpanded)
            mPreviousExpandedPosition = position;


        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(view -> {
            final boolean visibility = holder.mDescriptionText.getVisibility()==View.VISIBLE;

            if (!visibility)
            {
                holder.itemView.setActivated(true);
                holder.mDescriptionText.setVisibility(View.VISIBLE);
                holder.mDidYouKnowText.setVisibility(View.VISIBLE);
                if (mPreviousExpandedPosition!=-1 && mPreviousExpandedPosition!=position)
                {
                   if (mRecyclerView.findViewHolderForLayoutPosition(mPreviousExpandedPosition) != null){
                    mRecyclerView.findViewHolderForLayoutPosition(mPreviousExpandedPosition).itemView.setActivated(false);
                    mRecyclerView.findViewHolderForLayoutPosition(mPreviousExpandedPosition).itemView.findViewById(R.id.description).setVisibility(View.GONE);
                    mRecyclerView.findViewHolderForLayoutPosition(mPreviousExpandedPosition).itemView.findViewById(R.id.didYouKnow).setVisibility(View.GONE);}

                }
                mPreviousExpandedPosition = position;
            }
            else
            {
                holder.itemView.setActivated(false);
                holder.mDescriptionText.setVisibility(View.GONE);
                holder.mDidYouKnowText.setVisibility(View.GONE);
            }
            TransitionManager.beginDelayedTransition(mRecyclerView);
        });
    }

    @Override
    public int getItemCount() {
        return mBlendData.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
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
