package org.alinuswe.resorces;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.alinuswe.configuration.Routes;
import org.alinuswe.request.PersonDetailsRequest;
import org.alinuswe.service.PersonService;


@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @POST()
    @Path(Routes.PersonDetails.CREATE_PERSON_DETAILS)
    @Transactional
    public Response creat(PersonDetailsRequest personDetailsRequest) {
        var personResponse = personService.create(personDetailsRequest);
        return Response.status(personResponse.getStatusCode()).entity(personResponse).build();
    }

    @GET()
    @Path(Routes.PersonDetails.GET_PERSON_DETAILS)
    public Response get() {
        var personDetails = personService.getAll();
        return Response.status(personDetails.getStatusCode()).entity(personDetails).build();
    }

    @GET
    @Path("/{id}/get")
    public Response get(@PathParam("id") Long userId) {
        var personDetailsResponse = personService.getAll(userId);
        return Response.status(personDetailsResponse.getStatusCode()).entity(personDetailsResponse).build();
    }

    @PATCH
    @Path("/{id}/update")
    @Transactional
    public Response update(@PathParam("id") Long userId, PersonDetailsRequest personDetailsRequest) {
        var updatedPersonDetailsResponse = personService.update(userId, personDetailsRequest);
        return Response.status(updatedPersonDetailsResponse.getStatusCode()).entity(updatedPersonDetailsResponse).build();
    }

    @DELETE
    @Path("/{id}/delete")
    @Transactional
    public Response delete(@PathParam("id") Long userId) {
        var deletedPersonDetailsResponse = personService.delete(userId);
        return Response.status(deletedPersonDetailsResponse.getStatusCode()).entity(deletedPersonDetailsResponse).build();
    }


}
