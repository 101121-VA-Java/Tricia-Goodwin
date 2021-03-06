package com.revature.drivers;

import com.revature.controllers.AuthorizationController;
import com.revature.controllers.ReimbursementsController;
import com.revature.controllers.UsersController;
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
		
		app.before(ctx -> {
		    ctx.header("Access-Control-Allow-Headers", "Auth");
		    ctx.header("Access-Control-Expose-Headers", "Auth");
		});
		app.routes(() -> {
			path("auth", () -> {
				post(AuthorizationController::logIn);
			});
			
			path("users", () -> {
				get(UsersController::getAllUsers);
				
				
				path("{id}", () -> {
					get(UsersController::getUserById);
					put(UsersController::updateUser);
					
					path("reimbursements", () -> {
						get(ReimbursementsController::getByUserId);
						post(ReimbursementsController::newReimbursement);
						
						path("pending", () -> {
							get(ReimbursementsController::getByUserIdPending);
						});
						path("approved", () -> {
							get(ReimbursementsController::getByUserIdApproved);
						});
						path("denied", () -> {
							get(ReimbursementsController::getByUserIdDenied);
						});
							
					});
					
				});
				
			});
			
			path("reimbursements", () -> {
					
					get(ReimbursementsController::getAll);
					
					path("pending", () -> {
						
						get(ReimbursementsController::getByPending);
					});
					path("approved", () -> {
						get(ReimbursementsController::getByApproved);
					});
					path("denied", () -> {
						get(ReimbursementsController::getByDenied);
					});
					path("{Manid}", () ->{
						path("{reID}", () ->{
							path("approve", () -> {
								put(ReimbursementsController::approveReimbursement);
								
							});
							path("reject", () -> {
								put(ReimbursementsController::rejectReimbursement);
							});
						});

					
						
					});
				});
			});
			

	}



}
