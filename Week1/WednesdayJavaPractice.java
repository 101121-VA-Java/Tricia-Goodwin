public class WednesdayJavaPractice{
	public static void main (String[] args){
	int miles = 200; //distance of road trip
	int kids = 3; //number of kids on trip
	int rem;
	int dist = 0;//distance traveled
	int annoyance = 0;
	do{
	dist = dist + 5;
	for(int i = 1;i<=kids;i++){
		System.out.println("Are we there yet?");
	}
	if (dist < miles){	
		rem = miles - dist;
		if (annoyance >= 10){
			System.out.println("STOP ASKING!!!");
			dist = dist + 10;
			annoyance = 0;}
		else{
			System.out.println("No, We still have " + rem + " miles to go.");
			annoyance = annoyance+1;
		}
	} else{
		System.out.println("Yes we are finally here");
		}
	}while(dist<miles);
	
	}
}

