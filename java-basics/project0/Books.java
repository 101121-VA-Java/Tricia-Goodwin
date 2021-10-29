public class Books{

    public String title;
    public String author;
    public boolean released;
    public int stock;
    public String genre;
    public double price;
    public boolean hardcover;
    public boolean nytbestseller;

    public Books(String title, String author){
        this.title = title;
        this.author = author;
        this.nytbestseller = false;
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


}





