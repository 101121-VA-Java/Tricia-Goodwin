package com.revature.drivers;

import com.revature.models.Users;

import io.javalin.Javalin;

public class Driver {
	public static void main(String[] args) {
	
		Javalin app = Javalin.create( config -> {});
		app.start(8080);
//		app.get("indez", (ctx) ->{
//			ctx.result("username");
//		});
		
		Users u = new Users();
		u.setUsername("test");
		
		app.post("users", (ctx) -> {
			ctx.json(u);
		});
	}
}
