package com.revature.controllers;
import com.revature.services.AuthorizationService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthorizationController {

	private static AuthorizationService as = new AuthorizationService();
	
	public static void logIn(Context ctx) {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		String loggedInToken = null;
		if(username != null && password!= null) {
			loggedInToken = as.logIn(username, password);
		}
		
		if (loggedInToken != null){
			System.out.println(loggedInToken);
			ctx.header("Auth", loggedInToken);
			ctx.status(HttpCode.OK);
			
		} else {
			ctx.status(HttpCode.NOT_FOUND);
		}
	}
	
}
