package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursements;

public interface ReimbursementDao {

	List <Reimbursements> myPendingreimbursements(int ID);
	List <Reimbursements> myApprovedReimbursements(int ID);
	Reimbursements findRemibursement(int ID);
	Reimbursements alterReimbursement(int ID, boolean approve);
	List<Reimbursements> getAll();
	List<Reimbursements> getPending();
	List<Reimbursements> getApproved();
	List<Reimbursements> getDenied();

}
