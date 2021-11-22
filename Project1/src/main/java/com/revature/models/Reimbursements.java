package com.revature.models;

import java.sql.Timestamp;

import javax.print.DocFlavor.BYTE_ARRAY;

public class Reimbursements {
	private double amount;
	private Timestamp submitted; 
	private Timestamp resolved;
	private String description;
	private BYTE_ARRAY receipt;
	private Users author;
	private Users resolver;
	private Status status;
	private Type type;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BYTE_ARRAY getReceipt() {
		return receipt;
	}
	public void setReceipt(BYTE_ARRAY receipt) {
		this.receipt = receipt;
	}
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public Users getResolver() {
		return resolver;
	}
	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Reimbursements(double amount, Timestamp submitted, Users author, Status status, Type type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	public Reimbursements(double amount, Timestamp submitted, Timestamp resolved, String description,
			BYTE_ARRAY receipt, Users author, Users resolver, Status status, Type type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Reimbursements [amount=" + amount + ", submitted=" + submitted + ", description=" + description
				+ ", author=" + author + ", status=" + status + ", type=" + type + "]";
	}
	
	
	
}
