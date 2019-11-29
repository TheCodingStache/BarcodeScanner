package com.example.scanner.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scanner.Model.ListItem;
import com.example.scanner.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
    List<ListItem> listItemsArrayList;
    Context context;

    public MyAdapter(List<ListItem> listItemsArrayList, Context context) {
        this.listItemsArrayList = listItemsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new MyAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapterViewHolder holder, int position) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        ListItem listItem = listItemsArrayList.get(position);
        holder.code.setText("Barcode Type: " + listItem.getCode());
        holder.type.setText("Barcode: " + listItem.getType());
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(listItem.getType(), BarcodeFormat.CODE_128, 1000, 250);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            holder.barcode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        Linkify.addLinks(holder.code, Linkify.ALL);
    }

    @Override
    public int getItemCount() {
        return listItemsArrayList.size();
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView code;
        TextView type;
        ImageView barcode;
        CardView cardView;

        public MyAdapterViewHolder(final View itemView) {
            super(itemView);
            code = itemView.findViewById(R.id.code);
            type = itemView.findViewById(R.id.type);
            barcode = itemView.findViewById(R.id.barcode);
            cardView = itemView.findViewById(R.id.cardView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String type = listItemsArrayList.get(getAdapterPosition()).getType();
                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_SEND);
                    i.putExtra(Intent.EXTRA_TEXT, type);
                    i.setType("text/plain");
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}
