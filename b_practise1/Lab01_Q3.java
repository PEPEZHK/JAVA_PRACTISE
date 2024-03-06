import java.lang.Math;
import java.util.Scanner;
public class Lab01_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter kilograms to lose: ");
        final double kilo = sc.nextDouble();
        System.out.printf("Enter days to lose %.2f kilograms: " , kilo );
        final int days = sc.nextInt();
        final double CARBOHYDRATE = 50 ;
        final double FAT = 30 ;
        final double PROTEIN = 20 ;
        final int carCalPerGram = 4 ;
        final int fatCalPerGram = 9 ;
        final int proCalPerGram = 4 ;
        double recCarGrams  ; 
        double recFatGrams  ;
        double recProGrams  ;
        double recCarCal ;
        double recFatCal ;
        double recProCal ;
        

        final int dailyCalorieRequirement = 2000 ; // in order to lose 1 kilo necessary to burn 7700 calories
        double dailyDeficit ;
        
        
        System.out.println("\n*************************************************************************************************************************************************");
        dailyDeficit = (kilo * 7700) / days ;
        
        System.out.printf("To lose %.2f kilograms in %d days you will need a daily deficit of %.2f calories \n" , kilo , days , dailyDeficit);
        System.out.println("*************************************************************************************************************************************************");

        double recDailyDef = dailyCalorieRequirement - dailyDeficit ;
        System.out.printf("RECOMMENDED DAILY CALORIES TO LOSE IN %.2f IN %d DAYS: %.0f" , kilo , days , recDailyDef) ; 
        

        recCarCal = recDailyDef * CARBOHYDRATE/100  ;
        recFatCal = recDailyDef * FAT/100  ; 
        recProCal = recDailyDef * PROTEIN/100  ; 

        recCarGrams = recCarCal/ carCalPerGram ;
        recFatGrams = recFatCal/ fatCalPerGram ;
        recProGrams = recProCal/ proCalPerGram ; 
        System.out.println("\n*************************************************************************************************************************************************");
        System.out.println("MACRO                      RECOMMENDED PERCENT                   CALORIES PER GRAM                    RECOMMENDED CALORIES                  GRAMS");
        System.out.printf("CARBOHYDRATE                                %.0f                                   %d                                     %.0f                  %.1f%n" , CARBOHYDRATE , carCalPerGram , recCarCal , recCarGrams);
        System.out.printf("FAT                                         %.0f                                   %d                                     %.0f                   %.1f%n" , FAT , fatCalPerGram , recFatCal , recFatGrams);
        System.out.printf("PROTEIN                                     %.0f                                   %d                                     %.0f                  %.1f%n" ,  PROTEIN , proCalPerGram , recProCal , recCarGrams );
        System.out.println("*************************************************************************************************************************************************");
        sc.close();

    }
}
