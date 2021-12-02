package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.BYTE_ARRAY;

import com.revature.models.Reimbursements;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

public class ReimbursementPostgres implements ReimbursementDao {
private UsersDao ud =DaoFactory.getDaoFactory().getUsersDao();
	

	@Override
	public List<Reimbursements> getPending() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_REIMBURSEMENT inner join ERS_REIMBURSEMENT_STATUS on (ERS_REIMBURSEMENT.REIMB_STATUS_ID = "
					+ "ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID) inner join ERS_REIMBURSEMENT_TYPE on (ERS_REIMBURSEMENT.REIMB_TYPE_ID"
					+ " = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID) where REIMB_STATUS = 'PENDING'";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				int ID = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int authorID = rs.getInt("REIMB_RECEIPT");
				int resolverID = rs.getInt("REIMB_RESOLVER");
				Status status = Status.valueOf(rs.getString("REIMB_STATUS"));
				Type type = Type.valueOf(rs.getString("REIMB_TYPE"));
				
				Users author = ud.findUser(authorID);
				Users resolver = ud.findUser(resolverID);
				
				 Reimbursements r = new Reimbursements(amount,submitted,resolved,description,author,resolver,status,type);
				 reimbursements.add(r);
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
		return reimbursements;
	}
	@Override
	public List<Reimbursements> getApproved() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_REIMBURSEMENT inner join ERS_REIMBURSEMENT_STATUS on (ERS_REIMBURSEMENT.REIMB_STATUS_ID = "
					+ "ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID) inner join ERS_REIMBURSEMENT_TYPE on (ERS_REIMBURSEMENT.REIMB_TYPE_ID"
					+ " = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID) where REIMB_STATUS = 'APPROVED'";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				int ID = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int authorID = rs.getInt("REIMB_RECEIPT");
				int resolverID = rs.getInt("REIMB_RESOLVER");
				Status status = Status.valueOf(rs.getString("REIMB_STATUS"));
				Type type = Type.valueOf(rs.getString("REIMB_TYPE"));
				
				Users author = ud.findUser(authorID);
				Users resolver = ud.findUser(resolverID);
				
				 Reimbursements r = new Reimbursements(amount,submitted,resolved,description,author,resolver,status,type);
				 reimbursements.add(r);
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
		return reimbursements;
	}
	
	@Override
	public List<Reimbursements> getDenied() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_REIMBURSEMENT inner join ERS_REIMBURSEMENT_STATUS on (ERS_REIMBURSEMENT.REIMB_STATUS_ID = "
					+ "ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID) inner join ERS_REIMBURSEMENT_TYPE on (ERS_REIMBURSEMENT.REIMB_TYPE_ID"
					+ " = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID) where REIMB_STATUS = 'REJECTED'";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				int ID = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int authorID = rs.getInt("REIMB_RECEIPT");
				int resolverID = rs.getInt("REIMB_RESOLVER");
				Status status = Status.valueOf(rs.getString("REIMB_STATUS"));
				Type type = Type.valueOf(rs.getString("REIMB_TYPE"));
				
				Users author = ud.findUser(authorID);
				Users resolver = ud.findUser(resolverID);
				
				 Reimbursements r = new Reimbursements(amount,submitted,resolved,description,author,resolver,status,type);
				 reimbursements.add(r);
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
		return reimbursements;
	}

	@Override
	public List<Reimbursements> myPendingreimbursements(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursements> myApprovedReimbursements(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements findRemibursement(int ID) {
		Reimbursements r = new Reimbursements();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_REIMBURSEMENT inner join ERS_REIMBURSEMENT_STATUS on (ERS_REIMBURSEMENT.REIMB_STATUS_ID = "
					+ "ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID) inner join ERS_REIMBURSEMENT_TYPE on (ERS_REIMBURSEMENT.REIMB_TYPE_ID"
					+ " = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID) where REIMB_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int authorID = rs.getInt("REIMB_RECEIPT");
				int resolverID = rs.getInt("REIMB_RESOLVER");
				Status status = Status.valueOf(rs.getString("REIMB_STATUS"));
				Type type = Type.valueOf(rs.getString("REIMB_TYPE"));
				
				Users author = ud.findUser(authorID);
				Users resolver = ud.findUser(resolverID);
				
				  r = new Reimbursements(amount,submitted,resolved,description,author,resolver,status,type);
				 
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
		return r;
	}
	

	@Override
	public Reimbursements alterReimbursement(int ID, boolean approve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursements> getAll() {
		List<Reimbursements> reimbursements = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "select * from ERS_REIMBURSEMENT inner join ERS_REIMBURSEMENT_STATUS on (ERS_REIMBURSEMENT.REIMB_STATUS_ID = "
					+ "ERS_REIMBURSEMENT_STATUS.REIMB_STATUS_ID) inner join ERS_REIMBURSEMENT_TYPE on (ERS_REIMBURSEMENT.REIMB_TYPE_ID"
					+ " = ERS_REIMBURSEMENT_TYPE.REIMB_TYPE_ID)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				int ID = rs.getInt("REIMB_ID");
				double amount = rs.getDouble("REIMB_AMOUNT");
				Timestamp submitted = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp resolved = rs.getTimestamp("REIMB_RESOLVED");
				String description = rs.getString("REIMB_DESCRIPTION");
				int authorID = rs.getInt("REIMB_RECEIPT");
				int resolverID = rs.getInt("REIMB_RESOLVER");
				Status status = Status.valueOf(rs.getString("REIMB_STATUS"));
				Type type = Type.valueOf(rs.getString("REIMB_TYPE"));
				
				Users author = ud.findUser(authorID);
				Users resolver = ud.findUser(resolverID);
				
				 Reimbursements r = new Reimbursements(amount,submitted,resolved,description,author,resolver,status,type);
				 reimbursements.add(r);
			}
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		} 
		return reimbursements;
	}
	
}
