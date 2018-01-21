package com.nordstrom.endpoints;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nordstrom.customer.entities.Customer;
import com.nordstrom.siperian.operation.ProcessCustomerQuery;
import com.nordstrom.siperian.utilities.ConstantsUtility;

/**
 * author x75l
 */
@Component
@Path("customerdatas/") // localhost:8080/CustomerProgramServices/webapi/customerdatas
public class CustomerProgramDataResource {

	@Autowired
	ProcessCustomerQuery testBean;

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String getIt(@HeaderParam("firstName") String firstName, @HeaderParam("lastName") String lastName,
			@HeaderParam("dataSource") String dataSource) throws Exception {
		String msg = "hi there";

		return msg + "firstName:" + firstName + "lastName:" + lastName + "datasource:" + dataSource;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getIt() throws Exception {
		String msg = "hi there";
		return msg;

	}

	@GET
	@Path("mdm/data")
	@Produces("text/plain")
	public String getItbypath() throws Exception {
		// @HeaderParam("fname")String firstName,@HeaderParam("lname")String
		// lastName,@HeaderParam("datasource")String dataSource
		String msg = "hi there";
		// ProcessCustomerQuery searchQuery=new ProcessCustomerQuery();
		msg = testBean.getDetails("AMGELICA", "YTURRALDE", "WEB");

		return msg;

	}

	@PUT
	@Path("json")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putCustomer(@HeaderParam("firstName") String firstName, @HeaderParam("lastName") String lastName,
			@HeaderParam("dataSource") String dataSource, @Context final HttpServletResponse servletResponse) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		servletResponse.setHeader("dataSource", dataSource);
		return Response.status(Status.OK).entity(customer).build();
	}

	@PUT
	@Path("/{dataSource}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response putCustomerDetails(@HeaderParam("firstName") String firstName,
			@HeaderParam("lastName") String lastName, @PathParam("dataSource") String dataSource,
			@Context final HttpServletResponse servletResponse) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		servletResponse.setHeader("dataSource", dataSource);
		return Response.status(Status.OK).entity(customer).build();
	}

	@GET
	@Path("data/{dataSource}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerDetails(@HeaderParam("firstName") String firstName,
			@HeaderParam("lastName") String lastName, @PathParam("dataSource") String dataSource,
			@QueryParam("role") String role, @Context final HttpServletResponse servletResponse) {
		if (role.equals("admin")) {
			Customer customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			servletResponse.setHeader("dataSource", dataSource);
			return Response.status(Status.OK).entity(customer).build();
		} else {
			return Response.status(Status.FORBIDDEN).entity("").build();
		}

	}
	
	//additional example when you run the index.jsp file.
	
	 @POST
	 @Path("mdm/form")
     @Produces("text/plain")
     public String getFormDetails(@FormParam("firstName")String firstName,@FormParam("lastName")String lastName,@FormParam("dataSource")String dataSource,@FormParam("selection")String selectionType) throws Exception {
	     System.out.println("HI");
         //@HeaderParam("fname")String firstName,@HeaderParam("lname")String lastName,@HeaderParam("datasource")String dataSource
        String msg="hi there";
        //ProcessCustomerQuery processCustomerQuery=new ProcessCustomerQuery();
        if(selectionType.equals(ConstantsUtility.SELECTION_TYPE_FETCH)){
        msg=testBean.getDetails(firstName, lastName, dataSource);
         //msg=""+firstName+" "+lastName+" "+dataSource+" "+selectionType;
        }
        else if(selectionType.equals(ConstantsUtility.SELECTION_TYPE_PUT)){
            msg=testBean.putCustomerDetails(firstName, lastName,dataSource);
        }
        return msg;
	 }

}
