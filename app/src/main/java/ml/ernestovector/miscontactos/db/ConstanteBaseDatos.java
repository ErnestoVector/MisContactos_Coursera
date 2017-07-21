package ml.ernestovector.miscontactos.db;

public final class ConstanteBaseDatos {

//Atributos-------------------------------------------------------------------------------------------------------------
    //Declaramos las constantes
    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    //La tabla "contacto" incluye los siguientes campos:
    public static final String TABLE_CONTACTS           = "contacto";
    public static final String TABLE_CONTACTS_ID        = "id";
    public static final String TABLE_CONTACTS_NAME      = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO  = "telefono";
    public static final String TABLE_CONTACTS_EMAIL     = "email";
    public static final String TABLE_CONTACTS_FOTO      = "foto";

    //La tabla "contacto_likes" incluye los siguientes campos:
    public static final String TABLE_LIKES_CONTACT      = "contacto_likes";
    public static final String TABLE_LIKES_CONTACT_ID   = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES = "numero_likes";
}
