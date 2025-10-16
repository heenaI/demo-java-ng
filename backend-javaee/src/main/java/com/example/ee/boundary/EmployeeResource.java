package com.example.ee.boundary;

import com.example.ee.control.EmployeeService;
import com.example.ee.entity.Employee;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    @Inject EmployeeService service;

    @GET public List<Employee> all(){ return service.all(); }
    @POST public Response create(@Valid Employee e){ return Response.ok(service.create(e)).build(); }
}
