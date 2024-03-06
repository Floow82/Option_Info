package Fr.ensma.a3.ia;

import Fr.ensma.a3.ia.ressource.ClientResource;

import javax.ws.rs.ApplicationPath;

public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        public MyApplication() {
        // Enregistrez les classes de ressource (endpoints)
        register(ClientResource.class);
    }
    }
}
