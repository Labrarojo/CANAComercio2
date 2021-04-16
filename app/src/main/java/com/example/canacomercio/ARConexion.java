package com.example.canacomercio;

public class ARConexion {

    private static int id_comercio = 0;
    private static int id_empleado = 0;
    private static int id_gerente = 0;
    private static int id_admin = 0;
    private static int id_oferta = 0;

    //URL de conexión con el API REST
    private static String iniciar_sesion = "http://canaco.demos.mx/api/auth/login/comercios";
    private static String cerrar_sesion = "http://canaco.demos.mx/api/logout";
    private static String empleados_create_post = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/empleados";
    private static String empleados_index_get = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/empleados";
    private static String empleados_delete_delete = "http://canaco.demos.mx/api/empleados/"+id_empleado;
    private static String empleados_show_get = "http://canaco.demos.mx/api/empleados/"+id_empleado;
    private static String empleados_edit_path = "http://canaco.demos.mx/api/empleados/"+id_empleado;
    private static String gerentes_create_post = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/gerentes";
    private static String gerentes_index_get = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/gerentes";
    private static String gerentes_delete_delete = "http://canaco.demos.mx/api/gerentes/"+id_gerente;
    private static String gerentes_show_get = "http://canaco.demos.mx/api/gerentes/"+id_gerente;
    private static String gerentes_edit_path = "http://canaco.demos.mx/api/gerentes/"+id_gerente;
    private static String admin_create_post = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/admins";
    private static String admin_index_get = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/admins";
    private static String admin_delete_delete = "http://canaco.demos.mx/api/admins/"+id_admin;
    private static String admin_show_get = "http://canaco.demos.mx/api/admins/"+id_admin;
    private static String admin_edit_path = "http://canaco.demos.mx/api/admins/"+id_admin;
    private static String ofertas_create_post = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/ofertas";
    private static String ofertas_index_get = "http://canaco.demos.mx/api/comercios/"+id_comercio+"/ofertas";
    private static String ofertas_show_get = "http://canaco.demos.mx/api/ofertas/"+id_oferta;
    private static String ofertas_edit_path = "http://canaco.demos.mx/api/ofertas/"+id_oferta;
    //Fin de los URL

    
}
