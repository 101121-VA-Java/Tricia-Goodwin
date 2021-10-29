public class Food {                             //This line opens the class declaration for the class Food.
                                                //It is a public class so it can be used outside of the package it is in.
	public String name;                         //This line declares a class variable name, of type String.
	public String type;                         //This line declares a class variable type, of type String.

	public Food(String name, String type) {     //This line begins a contructor, which requires two String arguments, as parameters.
                                                //which are initilized as local variables inside of the contructor, name, and type.  
		this.name = name;                       //This line assigns the class variable name associated with this object to be the local variable name.
		this.type = type;                       //This line assigns the class variable type associated with this object to be the local variable type.
	}                                           //This line closes this constructor.

	public void cook() {                        //This line begins the definition a public method cook with no arguements and no return type.
		if (!name.contains("cooked")) {         //This begins an if statement, if the name of the object on which this method is applied does not
                                                // contain the string "cooked" within the string name, the if statement will run.
			name = "cooked " + name;            //Inside of the if-statement, the string name, will be replaced with a string that is "cooked " + the prior
                                                //string name.
		}                                       //This closes the if statement. 
	}                                           //This closes the method definition.
}                                               //THis closes the class declaration.

public class Main {                             //This opens the 
	public static void main(String[] args) {
		Food myFood = new Food("potato", "vegetable");
		myFood.cook();

		System.out.println(myFood.name);
	}
}