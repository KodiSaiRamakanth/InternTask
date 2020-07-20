package com.example.interntask;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Item> itemArrayList;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemArrayList = new ArrayList<>();
        recyclerView =  findViewById(R.id.r_view);
        button =  findViewById(R.id.badd);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this, itemArrayList);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(onAddingListener());

    }

    private View.OnClickListener onAddingListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.dialog_layout);
                dialog.setTitle("Register");
                dialog.setCancelable(false);
                EditText name = dialog.findViewById(R.id.ename);
                EditText age =  dialog.findViewById(R.id.eage);
                EditText roll =  dialog.findViewById(R.id.eroll);

                View btnAdd = dialog.findViewById(R.id.bt_ok);
                View btnCancel = dialog.findViewById(R.id.bt_cancel);

                btnAdd.setOnClickListener(onConfirmListener(name, age , roll, name,  dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));
                dialog.show();
            }
        };
    }

    private View.OnClickListener onConfirmListener(EditText editText, final EditText name, final EditText age, final EditText roll , final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item friend = new Item(name.getText().toString().trim(), age.getText().toString().trim(),roll.getText().toString().trim());

                itemArrayList.add(friend);

                adapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        };
    }
    private View.OnClickListener onCancelListener(final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }
}