package com.journaldev.listviewwithcheckboxes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> dataModels;
    ListView listView;
public  static     CustomAdapter adapter;
Button btngetdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        btngetdata = (Button) findViewById(R.id.btngetdata);
        dataModels = new ArrayList<>();

        dataModels.add(new DataModel("Apple Pie", false));
        dataModels.add(new DataModel("Banana Bread", false));
        dataModels.add(new DataModel("Cupcake", false));
        dataModels.add(new DataModel("Donut", true));
        dataModels.add(new DataModel("Eclair", true));
        dataModels.add(new DataModel("Froyo", true));
        dataModels.add(new DataModel("Gingerbread", true));
        dataModels.add(new DataModel("Honeycomb", false));
        dataModels.add(new DataModel("Ice Cream Sandwich", false));
        dataModels.add(new DataModel("Jelly Bean", false));
        dataModels.add(new DataModel("Kitkat", false));
        dataModels.add(new DataModel("Lollipop", false));
        dataModels.add(new DataModel("Marshmallow", false));
        dataModels.add(new DataModel("Nougat", false));

        adapter = new CustomAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
     /*   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();


            }
        });*/


        btngetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String totlaItem = "";
                for (int i = 0 ; i<dataModels.size() ; i++ )
                {
                    DataModel dataModel= dataModels.get(i);
                    if(dataModel.checked)
                    {
                        totlaItem = totlaItem+" , " +dataModel.name;
                    }
                }

                Toast.makeText(getApplicationContext() , totlaItem , Toast.LENGTH_LONG).show();
            }
        });
    }
}
