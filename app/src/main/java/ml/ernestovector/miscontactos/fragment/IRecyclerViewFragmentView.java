package ml.ernestovector.miscontactos.fragment;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.adapter.ContactoAdaptador;
import ml.ernestovector.miscontactos.pojo.Contacto;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
