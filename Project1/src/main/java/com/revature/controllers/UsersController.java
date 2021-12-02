package com.revature.controllers;

import java.util.List;

import com.revature.models.Users;
import com.revature.services.UsersService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class UsersController {
	public static void getAllUsers(Context ctx) {
		
		UsersService us = new UsersService();
		
		
//		String username = ctx.queryParam("username");
//		String man_id = ctx.queryParam("manager-id");
		
		List<Users> users = us.getAllUsers();

		ctx.json(users);

		ctx.status(HttpCode.OK);

	}
	public static void getUserById(Context ctx) {
		UsersService us = new UsersService();
		int id = Integer.parseInt(ctx.pathParam("id"));
		Users u = us.findUser(id);
		ctx.json(u);
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
