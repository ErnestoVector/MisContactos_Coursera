package ml.ernestovector.miscontactos;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactoAdaptador {

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
