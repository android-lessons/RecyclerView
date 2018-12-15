package com.kg.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button addBtn;

    private List<String> data;

    private List<String> selectedNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedNames = new ArrayList<>();
        data = new ArrayList<>();
        data.add("Karen");
        data.add("Babken");
        data.add("Lusine");
        data.add("Tatev");
        data.add("Eghishe");
        data.add("Varujan");
        data.add("Ruben");
        data.add("Karen");

        recyclerView = findViewById(R.id.recyclerView);
        addBtn = findViewById(R.id.addBtn);

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        final SimpleAdapter adapter = new SimpleAdapter(data);
        adapter.setOnItemSelectedListener(new SimpleAdapter.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index, boolean selected) {
                if(selected) {
                    selectedNames.add(data.get(index));
                } else {
                    selectedNames.remove(data.get(index));
                }
                Toast.makeText(MainActivity.this, "item clicked " + index , Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(0, "Karen");
                adapter.notifyItemInserted(0);
            }
        });
    }
}
