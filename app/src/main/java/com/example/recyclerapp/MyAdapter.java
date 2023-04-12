package com.example.recyclerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{

    //4- Hnadling the Click Events
    private ItemClickListener clickListener;
    //1-Data Source - La model Class creada para manejar la data
    private VaccineModel [] listData;

    //Para pasar la data de la model class al adapter que estaremos creando
    public MyAdapter(VaccineModel[] listData) {
        this.listData = listData;
    }



    //2- View Holder Class
    //Para acceder a los widgets del layout creado para el recycler view
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //creando los variables acorder al tipo widget
        public ImageView imageView;
        public TextView textView;

        //Asignando el valor de los widgets a las variables creadas anteriormente
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textview);
        }

        @Override
        public void onClick(View view) {

        }
    }

    //3- Implementing the methods
    //conectando el layout del recycler view con el main activity
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflator creado para asignarle la clase padre(Activity main)
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());

        //View creado para asignarle los widgets del layout de recycler a la clase padre (main activity)
        View listItem = inflator.inflate(R.layout.recyclerview_item, parent, false);

        //Asignacion al viewholder del nuevo view con los widgets del layout de recycler view asignados a la clase padre (activity main)
        MyViewHolder viewHolder = new MyViewHolder(listItem);

        //retorno del objeto de la clase Myviewholder creado con el nuevo View Creado
        return viewHolder;
    }

    //Asignacion de data a los widgets del lay out del recycler view usando el model class
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final VaccineModel myListData = listData[position];
        holder.textView.setText(listData[position].getTitle());
        holder.imageView.setImageResource(listData[position].getImage());

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}
