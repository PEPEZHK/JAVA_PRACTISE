import java.util.Scanner;
import java.lang.Math;
public class Lab01_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter:"); 
        double x = sc.nextDouble() ;  
        double y ;
        y= ( Math.pow( x , 3) + 3*Math.abs(x) + 9 )/ (Math.pow(x, 2)) ;
        System.out.println("y="+Math.round(y));
        System.out.printf(" %.2f is beteween  %.0f and " + Math.round(y) , y , x);
        sc.close();
    }
}
