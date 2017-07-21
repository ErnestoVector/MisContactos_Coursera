package ml.ernestovector.miscontactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import ml.ernestovector.miscontactos.pojo.Contacto;

public class BaseDatos extends SQLiteOpenHelper{

//Atributos-------------------------------------------------------------------------------------------------------------
    private Context context;

//Metodo Constructor----------------------------------------------------------------------------------------------------
    public BaseDatos(Context context) {
        super(context, ConstanteBaseDatos.DATABASE_NAME, null, ConstanteBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

//Metodos de la clase padre SQLiteOpenHelper----------------------------------------------------------------------------
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Aqui se crea la estructura de las bases de datos (las tablas, en terminos generales)

        //Tabla de contacto
        String queryCrearTablaContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_CONTACTS + "(" +
                    ConstanteBaseDatos.TABLE_CONTACTS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ConstanteBaseDatos.TABLE_CONTACTS_NAME     + " TEXT, " +
                    ConstanteBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                    ConstanteBaseDatos.TABLE_CONTACTS_EMAIL    + " TEXT, " +
                    ConstanteBaseDatos.TABLE_CONTACTS_FOTO     + " INTEGER" + ")";

        //Tabla de likes
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstanteBaseDatos.TABLE_LIKES_CONTACT + "(" +
                    ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO  + " INTEGER, " +
                    ConstanteBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER" +
                    "FOREIGN KEY(" + ConstanteBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ")" +
                    "REFERENCES " + ConstanteBaseDatos.TABLE_CONTACTS + "(" + ConstanteBaseDatos.TABLE_CONTACTS_ID + ")" +
                    ")";

        //Ejecutamos las tablas recien creadas
        db.execSQL(queryCrearTablaContacto);
//        db.execSQL(queryCrearTablaLikesContacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se ejecuta cuando necesitemos reestructurar la base de datos

        //Primero eliminamos las tablas (si existen)
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXIST " + ConstanteBaseDatos.TABLE_LIKES_CONTACT);

        //Creamos una nueva tabla reestructurada
        onCreate(db);
    }

//Metodos personales----------------------------------------------------------------------------------------------------
    public ArrayList<Contacto> obtenerTodosLosContactos(){
        //Declaramos el arreglo
        ArrayList<Contacto> contactos = new ArrayList<>();
        //
        String query = "SELECT * FROM " +ConstanteBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();

        //Ejecutar el query
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            //Llenado de contactos
            Contacto contactoActual = new Contacto();

            //Tabla de contacto
            //Dentro del getString va el valor entero del indice, iniciando por el cero
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            contactos.add(contactoActual);

            //Tabla de Likes
        }
        //Cerramos y bloqueamos las conexiones hechas
        db.close();

        //Devolvemos el arreglo
        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstanteBaseDatos.TABLE_CONTACTS, null, contentValues);
        db.close();
    }
}
