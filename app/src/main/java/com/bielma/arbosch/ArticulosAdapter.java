package com.bielma.arbosch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bielma.arbosch.Modelos.Producto;

import java.util.ArrayList;

public class ArticulosAdapter extends RecyclerView.Adapter<ArticulosAdapter.ArticulosViewHolder> {
    private ArrayList<Producto> productos;
    private ItemClickListener itemClickListener;
    public ArticulosAdapter(ArrayList<Producto> productos){
        this.productos = productos;
    }

    @NonNull
    @Override
    public ArticulosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null, false);

        return new ArticulosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticulosViewHolder articulosViewHolder, int i) {
        articulosViewHolder.nombre.setText("Hola");
        articulosViewHolder.descripcion.setText("Pinche putita");
    }

    @Override
    public int getItemCount() {
        //return productos.size();
        return 1;
    }
    public void setClickClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    public interface ItemClickListener{
        void onItemClick(View view, int Position);
    }
    public class ArticulosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView nombre;
        private TextView descripcion;
    //  private TextView precio;//
        public ArticulosViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img);
            nombre = itemView.findViewById(R.id.titulo);
            descripcion = (TextView)itemView.findViewById(R.id.des);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener!=null){
                itemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

}
