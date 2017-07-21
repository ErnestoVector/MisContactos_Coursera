package ml.ernestovector.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.R;
import ml.ernestovector.miscontactos.pojo.Contacto;

public class ConstructorContactos {

//Atributos-------------------------------------------------------------------------------------------------------------
    private Context context;
    ArrayList<Contacto> contactos;

//Metodo constructor----------------------------------------------------------------------------------------------------
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){

        /*contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.six_flags_s_perman, "Ernesto Gálvez",  "55 3332 2391", "egm.vector@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.coleos1,            "Anahí Salgado",   "55 7777 9999", "anahi@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.snapdragon,         "Lori Martínez",   "55 2256 3487", "lori-carolina@hotmail.com", 8));
        contactos.add(new Contacto(R.drawable.fanny,              "Estefani Monroy", "55 1845 7222", "fanny.monroy2204@gmail.com", 9));
        contactos.add(new Contacto(R.drawable.dusty_miller,       "Carlos Guerrero", "55 2300 2300", "carlitos@outlook.com", 7));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NAME, "Ernesto Gálvez");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "55 3332 2391");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "egm.vector@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.six_flags_s_perman);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NAME, "Fanny Monroy");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "55 1845 7222");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "fanny.monroy2204@gmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.fanny);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_NAME, "Lori Martínez");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO, "55 2256 3487");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_EMAIL, "lori-carolina@hotmail.com");
        contentValues.put(ConstanteBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.coleos);

        db.insertarContacto(contentValues);
    }
}
