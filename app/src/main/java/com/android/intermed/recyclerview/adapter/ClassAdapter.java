package com.android.intermed.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.intermed.recyclerview.R;
import com.android.intermed.recyclerview.model.ListItem;

import java.util.ArrayList;
import java.util.List;



public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassHolder>

{

    private List<ListItem> listData;
    private LayoutInflater inflater;
    private ItemClickCallback itemClickCallback;

    public interface  ItemClickCallback{
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public ClassAdapter (List<ListItem> listData, Context c){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public ClassAdapter.ClassHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ClassHolder(view);
    }

    @Override
    public void onBindViewHolder(ClassHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.icon.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        if (item.isFavourite()){
            holder.secondaryIcon.setImageResource(R.drawable.staron);
        } else {
            holder.secondaryIcon.setImageResource(R.drawable.staroff);
        }
    }
    public void setListItemData(ArrayList<ListItem> exerciseListItem){
        this.listData.clear();
        this.listData.addAll(exerciseListItem);
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ClassHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView title;
        ImageView secondaryIcon;
        ImageView icon;
        View container;

        public ClassHolder(View itemView) {

            super(itemView);
            title = (TextView)itemView.findViewById(R.id.tv1);
            secondaryIcon = (ImageView)itemView.findViewById(R.id.star);
            icon = (ImageView)itemView.findViewById(R.id.iv1);
            container =itemView.findViewById(R.id.itemroot);
            container.setOnClickListener(this);
            secondaryIcon.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.itemroot)
            {
                itemClickCallback.onItemClick(getAdapterPosition());
            }
            else
            {
                itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }
        }
    }
}