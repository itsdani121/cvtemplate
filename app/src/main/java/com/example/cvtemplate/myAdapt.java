package com.example.cvtemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myAdapt extends RecyclerView.Adapter<myAdapt.myViewHolder> {

    private Context mContext;
    private List<details> mDetails;
    private recycleItemCLick clickItem;
    private popupAdapt mPopupAdapt;

    public myAdapt(Context mContext, List<details> mDetails, recycleItemCLick clickItem, popupAdapt mPopupAdapt) {
        this.mContext = mContext;
        this.mDetails = mDetails;
        this.clickItem = clickItem;
        this.mPopupAdapt = mPopupAdapt;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.logintext, parent, false);
        myViewHolder holder = new myViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
        final details detailsList = mDetails.get(position);
        holder.textViewTitle.setText(detailsList.getTitle());
        holder.textViewPath.setText(detailsList.getPath());
        holder.textViewSize.setText(String.valueOf(detailsList.getSizes()));
        holder.imageView.setImageResource(detailsList.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItem.onItemSingleClicked(detailsList, position);
            }
        });
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu= new PopupMenu(mContext,holder.more);
                    popupMenu.getMenuInflater().inflate(R.popupMenu.,popupMenu.getMenu());                }
            });
    }

    @Override
    public int getItemCount() {

        return mDetails.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewSize, textViewPath;
        ImageView imageView, more;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.titles);
            textViewSize = itemView.findViewById(R.id.sizes);
            textViewPath = itemView.findViewById(R.id.path);
            imageView = itemView.findViewById(R.id.myImage);
            more = itemView.findViewById(R.id.moree);

        }
    }
}
