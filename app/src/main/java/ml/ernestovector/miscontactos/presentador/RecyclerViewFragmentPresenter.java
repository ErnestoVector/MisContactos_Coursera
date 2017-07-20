package ml.ernestovector.miscontactos.presentador;

import android.content.Context;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.adapter.ContactoAdaptador;
import ml.ernestovector.miscontactos.db.ConstructorContactos;
import ml.ernestovector.miscontactos.fragment.IRecyclerViewFragmentView;
import ml.ernestovector.miscontactos.pojo.Contacto;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

//Atributos-------------------------------------------------------------------------------------------------------------
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;


//MetodoConstructor-----------------------------------------------------------------------------------------------------
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }


//Metodos interface-----------------------------------------------------------------------------------------------------
    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
