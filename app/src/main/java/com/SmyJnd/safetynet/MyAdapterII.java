package com.SmyJnd.safetynet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterII extends RecyclerView.Adapter<MyViewHolderII> {

    private Context context;
    private List<DataClassFirstAid> dataList;

    public void setSearchList(List<DataClassFirstAid> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public MyAdapterII(Context context, List<DataClassFirstAid> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolderII onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_firstaid, parent, false);
        return new MyViewHolderII(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderII holder, int position) {

        holder.recImageII.setImageResource(dataList.get(position).getDataImage());
        holder.recTitleII.setText(dataList.get(position).getDataTitle());
        holder.recDescII.setText(dataList.get(position).getDataDesc());

        holder.recCardII.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivityFirstAid.class);
            intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
            intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
            intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolderII extends RecyclerView.ViewHolder{

    ImageView recImageII;
    TextView recTitleII, recDescII;
    CardView recCardII;

    public MyViewHolderII(@NonNull View itemView) {
        super(itemView);

        recImageII = itemView.findViewById(R.id.recImageII);
        recTitleII = itemView.findViewById(R.id.recTitleII);
        recDescII = itemView.findViewById(R.id.recDescII);
        recCardII = itemView.findViewById(R.id.recCardII);
    }
}