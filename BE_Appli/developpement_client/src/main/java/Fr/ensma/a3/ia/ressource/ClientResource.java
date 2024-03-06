package Fr.ensma.a3.ia.ressource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
public class ClientResource {

    private String loggedInUserPIN; // Pour stocker le PIN de l'utilisateur connecté

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("pin") String pin) {
        // Vérifiez le PIN dans la base de données ou autrement
        // Pour cet exemple, le PIN est simplement stocké en mémoire
        if (validatePIN(pin)) {
            loggedInUserPIN = pin;
            return Response.ok("Connexion réussie").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Échec de la connexion").build();
        }
    }

    @POST
    @Path("/submitAlert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response submitAlert(@FormParam("content") String content) {
        if (loggedInUserPIN != null) {
            // Envoyez le formulaire d'alerte au serveur
            // Vous devrez implémenter la communication avec le serveur
            String responseMessage = "Alert submitted: " + content;
            return Response.status(Response.Status.OK).entity(responseMessage).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Utilisateur non connecté").build();
        }
    }

    private boolean validatePIN(String enteredPIN) {
        // Vous devrez implémenter la validation du PIN, par exemple, en le comparant à un PIN stocké en base de données
        return "1234".equals(enteredPIN);
    }
}

