package com.nordstrom.endpoints;

import javax.ws.rs.Path;

@Path("programs") // localhost:8080/CustomerProgramServices/webapi/programs
public class ProgramDataResource {
	/*
	 * 
	 * private ProgramRepository repository = new ProgramRepositoryStub();
	 * 
	 *//**
		 * 
		 * @GET
		 * @Produces(MediaType.APPLICATION_JSON) public List
		 *                                       <Program> getAllPrograms(){
		 *                                       return
		 *                                       repository.findAllPrograms(); }
		 * 
		 * @GET @Path("{code}")
		 *      //localhost:8080/CustomerProgramServices/webapi/programs/123
		 * @Produces(MediaType.APPLICATION_JSON) public Program
		 *                                       getProgramDataById(@PathParam(
		 *                                       "code") String code){ return
		 *                                       repository.findProgramById(code
		 *                                       ); }
		 * 
		 * @GET @Path("{code}/status")
		 *      //localhost:8080/CustomerProgramServices/webapi/programs/123/
		 *      status
		 * @Produces(MediaType.APPLICATION_JSON) public ProgramStatus
		 *                                       getProgramStatusByProgramId(
		 *                                       @PathParam("code") String
		 *                                       code){ System.out.println(
		 *                                       "Search Program by code: " +
		 *                                       code); return
		 *                                       repository.findProgramById(code
		 *                                       ).getProgramStatus(); }
		 * 
		 */
	/*
	 * 
	 * //add Jersey response
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response getAllPrograms(){
	 * List<Program> programs = repository.findAllPrograms(); if(programs ==
	 * null || programs.isEmpty()){ return
	 * Response.status(Status.NOT_FOUND).build(); } GenericEntity<List<Program>>
	 * entity = new GenericEntity<List<Program>>(programs) {}; return
	 * Response.ok().entity(entity).build(); }
	 * 
	 * @GET
	 * 
	 * @Path("{code}")
	 * //localhost:8080/CustomerProgramServices/webapi/programs/123
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getProgramDataById(@PathParam("code") String code){ if (code == null ||
	 * code.length() < 4){ //don't know the actual req, assume return
	 * Response.status(Status.BAD_REQUEST).build(); }
	 * 
	 * Program program = repository.findProgramById(code);
	 * 
	 * if(program == null){ return Response.status(Status.NOT_FOUND).build(); }
	 * return Response.ok().entity(program).build(); }
	 * 
	 * @GET
	 * 
	 * @Path("{code}/status")
	 * //localhost:8080/CustomerProgramServices/webapi/programs/123/status
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getProgramStatusByProgramId(@PathParam("code") String code){ if (code ==
	 * null || code.length() < 4){ //don't know the actual req, assume return
	 * Response.status(Status.BAD_REQUEST).build(); }
	 * 
	 * Program program = repository.findProgramById(code);
	 * 
	 * if(program == null){ return Response.status(Status.NOT_FOUND).build(); }
	 * return Response.ok().entity(program.getProgramStatus()).build(); }
	 * 
	 * @GET
	 * 
	 * @Path("{code}/type")
	 * //localhost:8080/CustomerProgramServices/webapi/programs/123/type
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response
	 * getProgramTypeByProgramId(@PathParam("code") String code){ if (code ==
	 * null || code.length() < 4){ //don't know the actual req, assume return
	 * Response.status(Status.BAD_REQUEST).build(); }
	 * 
	 * Program program = repository.findProgramById(code);
	 * 
	 * if(program == null){ return Response.status(Status.NOT_FOUND).build(); }
	 * return Response.ok().entity(program.getProgramType()).build(); }
	 * 
	 *//**
		 * @Post will only create new data. return a message if data is already
		 *       in repository
		 * @param programData
		 * @return
		 */
	/*
	 * @POST
	 * 
	 * @Path("/data")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public Response createProgram(Program
	 * programData){ if(programData == null){ return
	 * Response.status(Status.BAD_REQUEST).build(); } return
	 * Response.ok().type(MediaType.TEXT_PLAIN).entity(repository.
	 * createProgramData(programData)).build(); }
	 * 
	 *//**
		 * @Put method to update data, client provides object Program if Program
		 *      is already in repository, update it. if Program is not in
		 *      repository, create it.
		 * @param code
		 * @return
		 */
	/*
	 * @PUT
	 * 
	 * @Path("/data")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public Response updateProgram(Program
	 * inputData){ if(inputData == null ||
	 * StringUtils.isBlank(inputData.getCode())){ return
	 * Response.status(Status.BAD_REQUEST).build(); } return
	 * Response.ok().type(MediaType.TEXT_PLAIN).entity(repository.
	 * updateProgramData(inputData)).build(); }
	 * 
	 * @DELETE
	 * 
	 * @Path("{code}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public Response
	 * deleteProgram(@PathParam("code") String code){ if(code == null ||
	 * code.isEmpty()){ return Response.status(Status.BAD_REQUEST).build(); }
	 * return Response.ok().type(MediaType.TEXT_PLAIN).entity(repository.
	 * deleteProgramById(code)).build(); }
	 * 
	 */}
