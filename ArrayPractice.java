public class ArrayPractice{
	public static void main(String[] args){

       String[] s = {"First", "Second", "Middle", "Penultimate","Last"};
       System.out.println("First Array:\n");
       for(int i = 0; i<s.length;i++){
            System.out.println(s[i]);
       }

        System.out.println("\n\nReversed Array:\n");
       String[] s1 = reverse(s);
       for(int i = 0; i<s1.length;i++){
            System.out.println(s1[i]);
       }

    }
    public static String[] reverse(String[] stringArg){
        String[] stringReverse = new String[stringArg.length];
        for(int i = 0; i < stringArg.length; i++ ){
            stringReverse[i] = stringArg[(stringArg.length - i -1)];
        }
        return stringReverse;
    }
}