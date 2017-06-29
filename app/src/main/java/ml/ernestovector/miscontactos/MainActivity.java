package ml.ernestovector.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        GridLayoutManager glm = new GridLayoutManager(this, 2);
        listaContactos.setLayoutManager(glm);

        //Muestra los objetos en una lista scrolleable hacia abajo
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();

        /*
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
        }


        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Intent explicito
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
            }
        });*/
    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.six_flags_s_perman,   "Ernesto Gálvez",  "55 3332 2391", "egm.vector@gmail.com"));
        contactos.add(new Contacto(R.drawable.coleos1,              "Anahí Salgado",   "55 7777 9999", "anahi@gmail.com"));
        contactos.add(new Contacto(R.drawable.snapdragon,           "Lori Martínez",   "55 2256 3487", "lori-carolina@hotmail.com"));
        contactos.add(new Contacto(R.drawable.fanny,                "Estefani Monroy", "55 1845 7222", "fanny.monroy2204@gmail.com"));
        contactos.add(new Contacto(R.drawable.dusty_miller,         "Carlos Guerrero", "55 2300 2300", "carlitos@outlook.com"));

    }
}
