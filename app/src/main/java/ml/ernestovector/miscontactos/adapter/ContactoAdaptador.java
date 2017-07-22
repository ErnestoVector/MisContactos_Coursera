package ml.ernestovector.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.db.ConstructorContactos;
import ml.ernestovector.miscontactos.pojo.Contacto;
import ml.ernestovector.miscontactos.DetalleContacto;
import ml.ernestovector.miscontactos.R;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    //Lista contactos
    ArrayList<Contacto> contactos;
    Activity activity;

    //Método constructor
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity  = activity;
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
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCv.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " Likes");

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {

            //Manda mensaje Toast cuando le das clic al "Like" de algun contacto
            @Override
            public void onClick(View v) {
                //Mensaje Toast para notificar un like a un contacto
                Toast.makeText(activity, "Diste like a: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
                //Actualizamos el valor de likes
                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);
                contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto));
            }
        });

        //Manda mensake Toast con el nombre del contacto seleccionado
        // y abre la segunda actividad con los datos del contacto inicializados
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Manda el mensaje toast con el nombre del contacto
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();

                //Inicia la segunda actividad con los datos del contacto
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                intent.putExtra("Email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });
    }

    //Cantidad de elementos que contiene mi lista
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    //Subclase ContactoViewHolder
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCv;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvNombreCv   = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView)    itemView.findViewById(R.id.tvTelefonoCV);
            btnLike      = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes      = (TextView)    itemView.findViewById(R.id.tvLikes);
        }
    }
}
