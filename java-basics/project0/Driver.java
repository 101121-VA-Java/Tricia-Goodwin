public class Driver{

    public static void main(String[] args){

        Books b = new Books("Dictionary", "Webster");
        b.stock = 12;
        b.price = 19.99;
        b.genre = "reference";
        b.released = true;
        b.hardcover = true;


        Books b1 = new Books("Ninth House", "Bardugo");
        b1.stock = 0;
        b1.price = 21.99;
        b1.genre = "Young Adult";
        b1.released = true;
        b1.hardcover = false;
        b1.nytbestseller = true;

        Books b2 = new Books("Untitled - Alex Stern #2", "Bardugo");
        b2.stock = 0;
        b2.price = 29.99;
        b2.genre = "Young Adult";
        b2.released = false;
        b2.hardcover = true;

        Books b3 = new Books("The Martian", "Weir");
        b3.stock = 4;
        b3.price = 16.99;
        b3.genre = "Sci-Fi";
        b3.released = true;
        b3.hardcover = false;
        b3.nytbestseller = true;

        Books b4 = new Books("Hail Mary", "Weir");
        b4.stock = 10;
        b4.price = 24.99;
        b4.genre = "Sci-fi";
        b4.released = false;
        b4.hardcover = true;


        System.out.println(b.info()+"\n");
        if(b.sell()){
            System.out.println(b.location()+"\n");
        }
        
        System.out.println(b1.info()+"\n");
        if(b1.sell()){
            System.out.println(b1.location()+"\n");
        }

        System.out.println(b2.info()+"\n");
        if(b2.sell()){
            System.out.println(b2.location()+"\n");
        }


        System.out.println(b3.info()+"\n");
        if(b3.sell()){
            System.out.println(b3.location()+"\n");
        }


        System.out.println(b4.info()+"\n");
        if(b4.sell()){
            System.out.println(b4.location()+"\n");
        }








    }
}
