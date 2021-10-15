public class Pets{
    public String name;
    public String type;
    public boolean fed;
    public static int numberOfPets;
    public static int numberOfPetFed;

    public Pets(String name){
        this.name = name;
        this.fed = false;
        numberOfPets++;
    }

    public Pets(String name,String type){
        this.name = name;
        this.type = type;
        this.fed = false;
        numberOfPets++;
    }

    public Pets(){
        this.fed = false;
        numberOfPets++;
    }

    public String callForPet(){
        return name;
    }


    public void feedPet(){
        numberOfPetFed++;
        this.fed = true;
        System.out.println(this.name + " has been fed");
    }

    public void namePet(String name){
        this.name = name;
    }

    public static void printNumOfPets(){
        System.out.println(numberOfPets);
        
    }

    public static void newDay(){
        numberOfPetFed = 0;
    }
}