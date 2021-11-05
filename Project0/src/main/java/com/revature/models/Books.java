package com.revature.models;

public class Books{

    private String title;
    private String author;
    private long isbn;
    private boolean released;
    private int stock;
    private String genre;
    private double price;
    private boolean hardcover;
    private boolean nytbestseller;
    

    public Books(String title, String author, long isbn, boolean released, int stock, String genre, double price,
			boolean hardcover, boolean nytbestseller) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.released = released;
		this.stock = stock;
		this.genre = genre;
		this.price = price;
		this.hardcover = hardcover;
		this.nytbestseller = nytbestseller;
	}
    public Books(String title, String author, long isbn, boolean released, int stock, String genre, double price,
			boolean hardcover) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.released = released;
		this.stock = stock;
		this.genre = genre;
		this.price = price;
		this.hardcover = hardcover;
		this.nytbestseller = false;
	}

	public Books(String title, String author){
        this.title = title;
        this.author = author;
        this.nytbestseller = false;
    }

    public Books(String title, String author, long l) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = l;
	}
    
    
    

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public boolean isReleased() {
		return released;
	}
	public void setReleased(boolean released) {
		this.released = released;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isHardcover() {
		return hardcover;
	}
	public void setHardcover(boolean hardcover) {
		this.hardcover = hardcover;
	}
	public boolean isNytbestseller() {
		return nytbestseller;
	}
	public void setNytbestseller(boolean nytbestseller) {
		this.nytbestseller = nytbestseller;
	}
	public String info(){
        return this.title + "\nby "+this.author +"\b"+this.genre;
    }

    public boolean canSell(){
        if( this.released && this.stock > 0){
            System.out.println("This book can be sold. \nIt costs $"+ this.price);
            return true;
        } else if(!this.released){
            System.out.println("This book has not been released yet.");
            return false;
        } else if(this.stock == 0){
            System.out.println("This book is out of stock.");
            return false;
        }
        else{
            return false;
        }
    }

    public String location(){
        if(this.stock == 0){
            return "not in stock";
        } else if(!this.released){
            return "back room - cannot be sold";
        } else if(this.nytbestseller){
            return "New York Times Bestseller Display";
        } else {
            return this.genre;
        }
    }

	@Override
	public String toString() {
		return "Books [title=" + title + ", author=" + author + ", price=" + price + "]";
	}


}





