package com.example.recyclevapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public CustomeAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewName;
        TextView textViewDesc;
        TextView textViewQuote;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textViewName = itemView.findViewById(R.id.name);
            textViewQuote = itemView.findViewById(R.id.quote);
            textViewDesc = itemView.findViewById(R.id.desc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textViewName.setText(dataSet.get(position).getName());
        holder.textViewQuote.setText(dataSet.get(position).getQuote());
        holder.textViewDesc.setText(dataSet.get(position).getDescription());
        holder.imageView.setImageResource(dataSet.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v.getContext(), dataSet.get(position));
            }
        });
    }

    private void showPopup(Context context, DataModel data) {
        View popupView = LayoutInflater.from(context).inflate(R.layout.popup_layout, null);
        View blurred_background = LayoutInflater.from(context).inflate(R.layout.blurred_background, null);

        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        PopupWindow blurred_popup = new PopupWindow((blurred_background));

        TextView popupName = popupView.findViewById(R.id.popupName);
        TextView popupDesc = popupView.findViewById(R.id.popupDesc);
        ImageView popupImage = popupView.findViewById(R.id.popupImage);
        TextView popupQuote = popupView.findViewById(R.id.popupQuote);
        Button closeButton = popupView.findViewById(R.id.closeButton);

        popupName.setText(data.getName());
        popupDesc.setText(data.getDescription());
        popupImage.setImageResource(data.getImage());
        popupQuote.setText(data.getQuote());

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blurred_popup.dismiss();
                popupWindow.dismiss();

            }
        });

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}