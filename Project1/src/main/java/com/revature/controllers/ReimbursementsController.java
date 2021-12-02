package com.revature.controllers;

import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.models.Users;
import com.revature.services.ReimbursementService;
import com.revature.services.UsersService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbursementsController {
	public static void getByUserId(Context ctx) {
	}
	
	public static void newReimbursement(Context ctx) {
	
	}
	public static void getAll(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		

		
		List<Reimbursements> reimbursements = rs.getAll();

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);

	}
	public static void getByPending(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		
		List<Reimbursements> reimbursements = rs.getPending();

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
	}
	public static void getByApproved(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		
		List<Reimbursements> reimbursements = rs.getApproved();

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
	}
	
	public static void getByDenied(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		
		List<Reimbursements> reimbursements = rs.getDenied();

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
	}
	
}
