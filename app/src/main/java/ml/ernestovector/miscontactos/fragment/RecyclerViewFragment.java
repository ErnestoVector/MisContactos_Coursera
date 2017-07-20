package ml.ernestovector.miscontactos.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.R;
import ml.ernestovector.miscontactos.adapter.ContactoAdaptador;
import ml.ernestovector.miscontactos.pojo.Contacto;
import ml.ernestovector.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import ml.ernestovector.miscontactos.presentador.RecyclerViewFragmentPresenter;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

//Atributos-------------------------------------------------------------------------------------------------------------
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;

//Metodo onCreate-------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflando el Layout
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.six_flags_s_perman,   "Ernesto Gálvez",  "55 3332 2391", "egm.vector@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.coleos1,              "Anahí Salgado",   "55 7777 9999", "anahi@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.snapdragon,           "Lori Martínez",   "55 2256 3487", "lori-carolina@hotmail.com", likes));
        contactos.add(new Contacto(R.drawable.fanny,                "Estefani Monroy", "55 1845 7222", "fanny.monroy2204@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.dusty_miller,         "Carlos Guerrero", "55 2300 2300", "carlitos@outlook.com", likes));

    }
    */

//Metodos de la interface-----------------------------------------------------------------------------------------------
    @Override
    public void generarLinearLayoutVertical() {
        //Muestra los objetos en una lista scrolleable hacia abajo
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        //listaContactos.setLayoutManager(glm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }


    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }


}
