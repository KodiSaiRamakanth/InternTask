package com.example.interntask;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Item> emp;
    private Activity activity;
    public Adapter(Activity activity, List<Item> friends) {
        this.emp = friends;
        this.activity = activity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater =activity.getLayoutInflater();
        View view =inflater.inflate(R.layout.display, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(Adapter.ViewHolder viewHolder, int position) {
        viewHolder.name.setText(emp.get(position).getName());
        viewHolder.age.setText(emp.get(position).getAge());
        viewHolder.roll.setText(emp.get(position).getRoll());

        viewHolder.container.setOnClickListener(onClickListener(position));
    }



    @Override
    public int getItemCount() {
        return (null !=emp?emp.size():0);
    }
    private View.OnClickListener onClickListener(final int position){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.display);
                dialog.setTitle("Position" + position);
                dialog.setCancelable(true);
                TextView name =(TextView)dialog.findViewById(R.id.tname);
                TextView age=(TextView)dialog.findViewById(R.id.tage);
                TextView roll = (TextView) dialog.findViewById(R.id.troll);

                dialog.show();
            }
        };
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView age;
        private  TextView roll;
        private   View container;
        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tname);
            age = (TextView) view.findViewById(R.id.tage);
            roll = (TextView) view.findViewById(R.id.troll);
            container = view.findViewById(R.id.card_view);
        }
    }
}