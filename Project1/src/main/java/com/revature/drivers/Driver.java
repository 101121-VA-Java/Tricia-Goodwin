package com.revature.drivers;

import com.revature.controllers.AuthorizationController;
import com.revature.models.Users;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;
import io.javalin.Javalin;

public class Driver {
	public static void main(String[] args) {
	
		Javalin app = Javalin.create( config -> {
			config.enableCorsForAllOrigins();
			config.defaultContentType = "application/json";
		});
		app.start(8080);
//		app.get("indez", (ctx) ->{
//			ctx.result("username");
//		});
		
//		Users u = new Users();
//		u.setUsername("test");
//		
//		app.post("users", (ctx) -> {
//			ctx.json(u);
//		});
		app.before(ctx -> {
		    ctx.header("Access-Control-Allow-Headers", "Authorization");
		    ctx.header("Access-Control-Expose-Headers", "Authorization");
		});
		app.routes(() -> {
			path("auth", () ->{
				post(AuthorizationController::logIn);
			});
		});
	}
}
