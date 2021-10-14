public class ArrayBasics{
	public static void main(String[] args){

        String[] names = {"Me", "You", "Them","Us"};

        String[] batch = new String[4];

        System.out.println(names[2]);

        System.out.println("Element at "+batch.length+" is "+batch[batch.length -1]);

        for(int i = 0; i < names.length; i++){
            switch(names[i]){
                case "Me":
                    System.out.println("Yay, It is "+ names[i]);
                    break;
                default:
                    System.out.println("This is "+ names[i]);
                    String s = names[i].equals("Them")? "They singular" : " ";
                    System.out.println(s);
                    break;
            }
        }

    }
}