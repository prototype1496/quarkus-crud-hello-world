package org.alinuswe.exceptions;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.alinuswe.response.ErrorResponse;

import static io.vertx.core.http.impl.HttpClientConnection.log;

@Provider
public class GlobalExceptionHandler {

    public Response handleApplicationException(ApplicationException ex) {
        log.error("Exception occur ", ex);
        ErrorResponse error = ErrorResponse.builder()
                .success(false)
                .statusCode(ex.getHttpStatus().code())
                .message(ex.getMessage())
                .data(ex.getData())
                .build();
        return Response.status(ex.getHttpStatus().code()).entity(error).build();
    }

}
