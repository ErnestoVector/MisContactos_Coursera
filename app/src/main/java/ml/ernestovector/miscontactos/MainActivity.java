package ml.ernestovector.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.adapter.ContactoAdaptador;
import ml.ernestovector.miscontactos.adapter.PageAdapter;
import ml.ernestovector.miscontactos.fragment.Perfil;
import ml.ernestovector.miscontactos.fragment.RecyclerViewFragment;
import ml.ernestovector.miscontactos.pojo.Contacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    public ContactoAdaptador adaptador;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectamos el codigo con los elementos de la actividad
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        /*
        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        //listaContactos.setLayoutManager(glm);

        //Muestra los objetos en una lista scrolleable hacia abajo
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();
        */

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        //Creamos una lista de Fragments
        ArrayList<Fragment> fragments = new ArrayList<>();

        //Inicializamos los fragments en la lista
        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());

        //regresamos la lista con los fragments
        return fragments;
    }

    private void setUpViewPager(){
        //Obtenemos el soporte y la lista de fragments en el view pager
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

        //Agregamos los fragments al tabLayout
        tabLayout.setupWithViewPager(viewPager);

    }

    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        rvContactos.setAdapter(adaptador);
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
