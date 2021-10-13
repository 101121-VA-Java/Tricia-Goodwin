/* Class declaration
        -[access modifier] clas [name of class]
        -Class files can only have one public class
        -name of the public class needs to match the name of the file
*/
public class calculator{
    public static void main(String[] args){
 
    int a = 4;
    int b = 17;
    double c = 3.1;
    double d = 10;
    String name = "Celeste";
    String day = "Friday";

    int sum = add(a,b);
    System.out.println(a +" + "+ b + " = " + sum);

    int dif = subtract(a,b);
    System.out.println(a +" - "+ b + " = " + dif);


    double product = multiply(c,d);
    System.out.println(c +" * "+ d + " = " + product);

    int rem = remainder(b,a);
    System.out.println("The remainder of " + b + " / " + a + " = " + rem);


    String message = weekday(day);
    System.out.println(message);


    String greet = greeting(name);
    System.out.println(greet);

    countdown(b);

}
/*
    Method declarations:
        -[access modifier] [nonaccess modifiers] [return type] [name of method] ([parameter 1], [parameter 2]){

        } 
    
*/


public static int add(int a, int b){
    return a + b;
}

public static int subtract(int a, int b){
    return a - b;
}

public static double multiply(double a, double b){
    return a *b;
}
public static int remainder(int a, int b){
    return a%b;
}

public static String weekday(String day){
    switch (day){
        case "Monday":
            return "Ugh, Monday";

        case "Tuesday":
            return "Taco Tuesday!";

        case "Wednesday":
            return "Hump day!";

        case "Thursday":
            return "Thirsty Thursday!";

        case "Friday":
            return "TGIF!";

        default: 
            return "Ahh the weekend!";
           
    }

}

public static void countdown(int num){
   if(num >= 0){
       do{
           System.out.println(num);
           num = num-1;
       }while(num>0);
   }
   else { System.out.println("input must be positive or 0");
   }
}

public static String greeting(String name){
    return "Hi "+ name + "! How are you today?";
}
}

