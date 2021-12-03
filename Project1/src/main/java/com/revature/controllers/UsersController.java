package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Users;
import com.revature.services.UsersService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UsersController {
	
	public static void getAllUsers(Context ctx) {
		
		UsersService us = new UsersService();

		List<Users> users = us.getAllUsers();

		ctx.json(users);

		ctx.status(HttpCode.OK);

	}
	
	public static void getUserById(Context ctx) {
//		String authtoken = ctx.header("Auth");
//		String[] autharr = authtoken.split(":");
//		if(autharr[1].equals("MANAGER")) {
			UsersService us = new UsersService();
			int id = Integer.parseInt(ctx.pathParam("id"));
			Users u = us.findUser(id);
			ctx.json(u);
			ctx.status(HttpCode.OK);
//		}else {
//			ctx.status(HttpCode.UNAUTHORIZED);
//		}
		
	}
	
	
	public static void updateUser(Context ctx) {
		System.out.println("made it here!");
		UsersService us = new UsersService();
		int id = Integer.parseInt(ctx.pathParam("id"));
		Users u = ctx.bodyAsClass(Users.class);

		String fname = u.getFname();
		String lname = u.getLname();
		String username = u.getUsername();
		String pass = u.getPassword();
		String email = u.getEmail();
		
		Users updated = us.updateUser(id, fname, lname, username, pass, email);
		ctx.json(updated);
		ctx.status(HttpCode.OK);
	}
	
//	public static void getUsersManId(Context ctx) {
//
//		UsersService us = new UsersService();
//		
//		
////		String username = ctx.queryParam("username");
////		String man_id = ctx.queryParam("manager-id");
//		
//		List<Users> users = us.getUsersManId();
//		ctx.json(users);
//		ctx.status(HttpCode.OK);
//		
//	}
}
