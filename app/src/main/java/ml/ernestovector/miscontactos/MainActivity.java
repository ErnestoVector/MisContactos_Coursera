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

        //Agregamos los iconos a los Tabs
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_info);

    }
}
