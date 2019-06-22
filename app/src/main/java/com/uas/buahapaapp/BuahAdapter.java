package com.uas.buahapaapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by roningrum on 21/06/2019 2019.
 */
public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.BuahViewHolder> {

    private static final int LENGTH = 7;
    private String[] daftarNamaBuah;
    private Drawable[] daftarGambarBuah;
    private Context context;

    public BuahAdapter(Context context) {
        Resources resource = context.getResources();
        daftarNamaBuah = resource.getStringArray(R.array.fruits);
        TypedArray a = resource.obtainTypedArray(R.array.place_avator);
        daftarGambarBuah = new Drawable[a.length()];
        for (int i = 0; i < daftarGambarBuah.length; i++) {
            daftarGambarBuah[i] = a.getDrawable(i);
        }
        a.recycle();
        this.context = context;
    }


    @NonNull
    @Override
    public BuahViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BuahViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BuahViewHolder buahViewHolder, int position) {
        buahViewHolder.gambarBuah.setImageDrawable(daftarGambarBuah[position % daftarGambarBuah.length]);
        buahViewHolder.namaBuah.setText(daftarNamaBuah[position % daftarGambarBuah.length]);
    }

    @Override
    public int getItemCount() {
        return LENGTH ;
    }

    public class BuahViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambarBuah;
        public TextView namaBuah;

        public BuahViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarBuah = itemView.findViewById(R.id.list_avatar);
            namaBuah = itemView.findViewById(R.id.list_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BuahDetail.class);
                    intent.putExtra(BuahDetail.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
