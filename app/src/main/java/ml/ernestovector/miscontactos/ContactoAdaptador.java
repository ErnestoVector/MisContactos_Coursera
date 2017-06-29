package ml.ernestovector.miscontactos;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    //Lista contactos
    ArrayList<Contacto> contactos;

    //Método constructor
    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }


    //Le da vida al layout CardView
    //Infla el layout y lo pasa al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Asociamos el cardview_contacto con el main activity
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCv.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCv;
        private TextView tvTelefonoCV;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCv   = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView)  itemView.findViewById(R.id.tvTelefonoCV);
        }
    }
}
