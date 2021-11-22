package com.revature.daos;

public class DaoFactory {
	private static DaoFactory df;
	private static UsersDao ud;
	private static ReimbursementDao rd;
	
	private DaoFactory() {}
	
	public static synchronized DaoFactory getDaoFactory() {
		if (df == null) {
			df = new DaoFactory();
		}
		return df;
	}
	
	public UsersDao getUsersDao() {
		if (ud == null) {
			ud = new UsersPostgres();
		}
		return ud;
	}
	
	public ReimbursementDao getReimbursementDao() {
		if (rd == null) {
			rd = new ReimbursementPostgres();
		}
		return rd;
	}

}
