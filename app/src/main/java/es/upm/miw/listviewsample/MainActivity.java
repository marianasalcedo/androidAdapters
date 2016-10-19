package es.upm.miw.listviewsample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import logic.CustomAdapter;

public class MainActivity extends Activity {

    ListView listView ;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.nameList);

        String[] values = getResources().getStringArray(R.array.data);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_2, android.R.id.text1, values);
        context = getApplicationContext();

        ArrayAdapter adapter = new CustomAdapter(this, R.layout.custom_linear, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                // Text on the list item
                String itemValue = (String) listView.getItemAtPosition(position);
                StringBuilder text = new StringBuilder("Position: " + position + "\nValue: " + itemValue);
                Toast.makeText(getApplicationContext(),
                               text ,
                               Toast.LENGTH_SHORT).show();

            }

        });
    }


}
