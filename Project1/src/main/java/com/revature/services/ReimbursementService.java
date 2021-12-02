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
		public List<Reimbursements> getAllID(int ID){
			List<Reimbursements> reimbursements = rd.getAll(ID);
			return reimbursements;
	}
			public List<Reimbursements> getPendingID(int ID) {
				List<Reimbursements> reimbursements = rd.getPending(ID);
				return reimbursements;
			}
			public List<Reimbursements> getApprovedID(int ID) {
				List<Reimbursements> reimbursements = rd.getApproved(ID);
				return reimbursements;
			}
			public List<Reimbursements> getDeniedID(int ID) {
				List<Reimbursements> reimbursements = rd.getDenied(ID);
				return reimbursements;
			}
			
			public boolean approveRequest(int UserId, int ID) {
				return rd.alterReimbursement(UserId, ID, true); 
			}
			public boolean rejectRequest(int UserID, int ID) {
				return rd.alterReimbursement(UserID, ID, false); 
			}
}
