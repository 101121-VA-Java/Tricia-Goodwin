package com.revature.daos;

import java.sql.Timestamp;
import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.Users;

public interface ReimbursementDao {


	//Reimbursements findRemibursement(int ID);
	boolean alterReimbursement(int UserID, int ID, boolean approve);
	List<Reimbursements> getAll();
	List<Reimbursements> getPending();
	List<Reimbursements> getApproved();
	List<Reimbursements> getDenied();
	List<Reimbursements> getAll(int ID);
	List<Reimbursements> getPending(int ID);
	List<Reimbursements> getApproved(int ID);
	List<Reimbursements> getDenied(int ID);
	boolean newReimbursement(double amount, String description, Users author, String type);
}
