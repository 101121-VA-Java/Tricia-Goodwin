public class Driver{

    public static void main(String[] args){

        Pets a = new Pets("Tiger","Cat");

        Pets b = new Pets("Charmander", "Lizard");

        b.namePet("Charizard");


        System.out.println("I have " + b.numberOfPets + " Pets.");

        System.out.println(a.numberOfPetFed + " Out of "+ a.numberOfPets + " Have been fed today.");

        System.out.println(a.callForPet());
        a.feedPet();

        System.out.println(a.numberOfPetFed + " Out of "+ a.numberOfPets + " Have been fed today.");

        Pets c = new Pets();

        c.namePet("Fish");

        c.type = "Fish";

        System.out.println("I have " + c.numberOfPets + " Pets.");


        System.out.println(b.callForPet());
        System.out.println(c.callForPet());

        b.feedPet();
        c.feedPet();
        System.out.println(c.numberOfPetFed + " Out of "+ a.numberOfPets + " Have been fed today.");

        Pets d = new Pets("Roxy", "Dog");

       
        d.newDay();

        System.out.println(c.numberOfPetFed + " Out of "+ a.numberOfPets + " Have been fed today.");

        System.out.println(a.callForPet());
        System.out.println(c.callForPet());
        System.out.println(b.callForPet());
        System.out.println(d.callForPet());

        a.feedPet();
        c.feedPet();
        b.feedPet();
        d.feedPet();

        System.out.println(c.numberOfPetFed + " Out of "+ a.numberOfPets + " Have been fed today.");

    }


}