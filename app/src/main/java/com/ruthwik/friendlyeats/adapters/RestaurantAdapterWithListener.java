/*
package com.ruthwik.friendlyeats.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.ruthwik.friendlyeats.R;
import com.ruthwik.friendlyeats.model.Restaurant;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class RestaurantAdapterWithListener extends RecyclerView.Adapter<RestaurantAdapterWithListener.RestaurantViewHolder>
        implements EventListener<QuerySnapshot> {

    private Context context;
    private Query mQuery;

    private ArrayList<DocumentSnapshot> mSnapshots = new ArrayList<>();

    public RestaurantAdapterWithListener(Query query, Context con) {
        this.mQuery = query;
        this.context = con;
    }

    @NonNull
    @Override
    public RestaurantAdapterWithListener.RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_list_row,viewGroup,false );
        return new RestaurantAdapterWithListener.RestaurantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantAdapterWithListener.RestaurantViewHolder restaurantViewHolder, final int i) {
        restaurantViewHolder.bind(getSnapshot(i));
        restaurantViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantDetailActivity.class);
                intent.putExtra("id", getSnapshot(i).getId());
                context.startActivity(intent);
            }
        });
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public void bind(final DocumentSnapshot snapshot) {

            Restaurant restaurant = snapshot.toObject(Restaurant.class);

            title.setText(restaurant.getName());
        }

        public RestaurantViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.text_title);

        }
    }

    protected void onDataChanged() {}

    protected void onDocumentAdded(DocumentChange change) {
        mSnapshots.add(change.getNewIndex(), change.getDocument());
        notifyItemInserted(change.getNewIndex());
    }

    protected void onDocumentModified(DocumentChange change) {
        if (change.getOldIndex() == change.getNewIndex()) {
            // Item changed but remained in same position
            mSnapshots.set(change.getOldIndex(), change.getDocument());
            notifyItemChanged(change.getOldIndex());
        } else {
            // Item changed and changed position
            mSnapshots.remove(change.getOldIndex());
            mSnapshots.add(change.getNewIndex(), change.getDocument());
            notifyItemMoved(change.getOldIndex(), change.getNewIndex());
        }
    }

    protected void onDocumentRemoved(DocumentChange change) {
        mSnapshots.remove(change.getOldIndex());
        notifyItemRemoved(change.getOldIndex());
    }

    @Override
    public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {

        // Dispatch the event
        for (DocumentChange change : documentSnapshots.getDocumentChanges()) {
            // Snapshot of the changed document
            DocumentSnapshot snapshot = change.getDocument();

            switch (change.getType()) {
                case ADDED:
                    onDocumentAdded(change);
                    break;
                case MODIFIED:
                    onDocumentModified(change);
                    break;
                case REMOVED:
                    onDocumentRemoved(change);
                    break;
            }
        }

        onDataChanged();
    }

    public void startListening() {
        mQuery.addSnapshotListener(this);
    }

    public void stopListening() {
        mSnapshots.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mSnapshots.size();
    }

    protected DocumentSnapshot getSnapshot(int index) {
        return mSnapshots.get(index);
    }
}
*/
