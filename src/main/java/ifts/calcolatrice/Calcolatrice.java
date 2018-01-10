package ifts.calcolatrice;

import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calcolatrice")
@Produces(MediaType.APPLICATION_JSON)
public class Calcolatrice {
        
    public Calcolatrice() { }
    
    @GET
    @Path("/somma")
    public Response somma(
        @QueryParam("n") Optional<Integer> n,
        @QueryParam("m") Optional<Integer>  m
    ) {
        if(!n.isPresent() || !m.isPresent())
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("'n' e 'm' devono essere entrambi indicati.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();

        int n1 = n.get();
        int n2 = m.get();

        return Response.ok().entity(new Somma(n1,n2,n1+n2)).build();
    }

    @GET
    @Path("/differenza")
    public Response differenza(
        @QueryParam("n") Optional<Integer> n,
        @QueryParam("m") Optional<Integer>  m
    ) {
        if(!n.isPresent() || !m.isPresent())
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("'n' e 'm' devono essere entrambi indicati.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        
        int n1 = n.get();
        int n2 = m.get();

        return Response.ok().entity(new Differenza(n1,n2,n1-n2)).build();
    }

    @GET
    @Path("/prodotto")
    public Response prodotto(
        @QueryParam("n") Optional<Integer> n,
        @QueryParam("m") Optional<Integer>  m
    ) {
        if(!n.isPresent() || !m.isPresent())
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("'n' e 'm' devono essere entrambi indicati.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        
        int n1 = n.get();
        int n2 = m.get();
        
        return Response.ok().entity(new Prodotto(n1,n2,n1*n2)).build();
    }

    @GET
    @Path("/divisione")
    public Response divisione(
        @QueryParam("n") Optional<Integer> n,
        @QueryParam("m") Optional<Integer>  m
    ) {
        if(!n.isPresent() || !m.isPresent())
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("'n' e 'm' devono essere entrambi indicati.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        
        int n1 = n.get();
        int n2 = m.get();
        
        if(n2 == 0)
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("'m' non può essere zero.")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        
        return Response.ok().entity(new Quoziente(n1,n2,n1/n2,n1%n2)).build();
    }
}
