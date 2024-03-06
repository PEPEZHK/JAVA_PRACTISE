import java.util.Scanner;
public class Lab01_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        
        System.out.print("Enter date and time: ");
        String dateTime = sc.nextLine() ;
        int spaceIndex ;
        int spaceIndex1 ;
        int spaceIndex2 ;

        spaceIndex = dateTime.indexOf('-' ) ; 
        spaceIndex1 = dateTime.indexOf('-' , spaceIndex+1) ; 
        spaceIndex2 = dateTime.indexOf(',' ) ;  

        System.out.printf(dateTime.substring(3, 5) + " minutes past " + dateTime.substring(0, 2) + " on " +dateTime.substring(spaceIndex1+1, spaceIndex2) + " " +dateTime.substring(spaceIndex+1, spaceIndex1) + " " + dateTime.substring(spaceIndex2+1) + " " + "(%s)" , dateTime.substring(6, spaceIndex) );
        sc.close(); 
    }
}
