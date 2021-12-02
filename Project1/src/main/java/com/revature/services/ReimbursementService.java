package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.UsersDao;
import com.revature.models.Reimbursements;
import com.revature.models.Users;

public class ReimbursementService {

		private ReimbursementDao rd;
		
		public ReimbursementService() {
			super();
			rd = DaoFactory.getDaoFactory().getReimbursementDao();
			
		}
		public List<Reimbursements> getAll(){
		List<Reimbursements> reimbursements = rd.getAll();
		return reimbursements;
}
		public List<Reimbursements> getPending() {
			List<Reimbursements> reimbursements = rd.getPending();
			return reimbursements;
		}
		public List<Reimbursements> getApproved() {
			List<Reimbursements> reimbursements = rd.getApproved();
			return reimbursements;
		}
		public List<Reimbursements> getDenied() {
			List<Reimbursements> reimbursements = rd.getDenied();
			return reimbursements;
		}
}
