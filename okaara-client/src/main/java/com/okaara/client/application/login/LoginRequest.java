package com.okaara.client.application.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.okaara.shared.client.model.Authorized;
import com.okaara.shared.client.model.User;

@Path("login")
public interface LoginRequest extends RestService {
	
	@POST
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void authenticate(User user, MethodCallback<Authorized> callback);

}
