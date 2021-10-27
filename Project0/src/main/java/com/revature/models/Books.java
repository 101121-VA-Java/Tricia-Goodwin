package com.revature.models;

public class Books{

    public String title;
    public String author;
    public long isbn;
    public boolean released;
    public int stock;
    public String genre;
    public double price;
    public boolean hardcover;
    public boolean nytbestseller;
    

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

	public String info(){
        return this.title + "\nby "+this.author;
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





