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
		ReimbursementService rs = new ReimbursementService();
		int id = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursements> reimbursements = rs.getAllID(id);

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
	}
	public static void getByUserIdPending(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		int id = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursements> reimbursements = rs.getPendingID(id);

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
	}
	
	public static void getByUserIdApproved(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		int id = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursements> reimbursements = rs.getApprovedID(id);

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
	}
	
	public static void getByUserIdDenied(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		int id = Integer.parseInt(ctx.pathParam("id"));
		List<Reimbursements> reimbursements = rs.getDeniedID(id);

		ctx.json(reimbursements);

		ctx.status(HttpCode.OK);
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
	public static void approveReimbursement(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		int userID = Integer.parseInt(ctx.pathParam("Manid"));
		int ID = Integer.parseInt(ctx.pathParam("reID"));
		boolean completed = rs.approveRequest(userID, ID);

		ctx.json(completed);

		ctx.status(HttpCode.OK);
	}
	public static void rejectReimbursement(Context ctx) {
		ReimbursementService rs = new ReimbursementService();
		int userID = Integer.parseInt(ctx.pathParam("Manid"));
		int ID = Integer.parseInt(ctx.pathParam("reID"));
		boolean completed = rs.rejectRequest(userID, ID);

		ctx.json(completed);

		ctx.status(HttpCode.OK);
	}
}
