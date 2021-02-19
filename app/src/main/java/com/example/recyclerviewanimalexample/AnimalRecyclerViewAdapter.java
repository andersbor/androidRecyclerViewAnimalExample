package com.example.recyclerviewanimalexample;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

// https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
public class AnimalRecyclerViewAdapter extends RecyclerView.Adapter<AnimalRecyclerViewAdapter.ViewHolder> {
    private final List<Animal> data;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    AnimalRecyclerViewAdapter(Context context, List<Animal> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal animal = data.get(position);
        String idString = Integer.toString(animal.getId());
        holder.idTextView.setText(idString);
        holder.nameTextView.setText(animal.getName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return data.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView idTextView, nameTextView;

        ViewHolder(View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.recyclerViewRowAnimalIdTextView);
            nameTextView = itemView.findViewById(R.id.recyclerViewRowAnimalNameTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition(), data.get(getAdapterPosition()));
        }
    }

    // convenience method for getting data at click position
    Animal getItem(int id) {
        return data.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position, Animal animal);
    }
}