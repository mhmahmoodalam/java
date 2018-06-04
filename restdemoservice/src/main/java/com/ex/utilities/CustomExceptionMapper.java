package com.ex.utilities;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.*;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {

	

	@Override
	public Response toResponse(Exception ex) {
		if(ex instanceof NotFoundException) {
			return Response.status(Status.OK).entity("OOps! You had a diversion. Where you heading Man!")
			.build();
		}
		return Response.status(Status.OK).entity("Hell Nooo! Sorry Our Bad we messed it up!")
				.build();
	}

}
