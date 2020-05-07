package com.example.asignaturas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    List<String> asignaturas = new ArrayList<String>(Arrays.asList("Investigacion Aplicada", "Facultativa II", "Planificación TIC"));
    EditText editText_asignaturas;
    MyAdapterList Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_asignaturas= (EditText)findViewById(R.id.editText_asignatura);
        myList = (ListView) findViewById(R.id.list1);
        fillList();
    }
    void fillList() {
        Adapter = new MyAdapterList(this, R.layout.item_list, asignaturas);
        myList.setAdapter(Adapter);
    }


    void add(String asignatura1) {
        if(!asignatura1.isEmpty())
        {
            asignaturas.add(asignatura1);
            editText_asignaturas.setText("");
            fillList();
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Agregar la asignatura", Toast.LENGTH_SHORT).show();
        }
    }

    public void agregar(View v)
    {
        String asignatura1 = editText_asignaturas.getText().toString();
        add(asignatura1);
    }
}
