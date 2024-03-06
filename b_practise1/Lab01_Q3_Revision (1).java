import java.lang.Math;
import java.util.Scanner;
public class Lab01_Q3_Revision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        
        System.out.print("Enter kilograms to lose: ");
        final double kilo = sc.nextDouble();
        
        System.out.printf("Enter days to lose %.2f kilograms: " , kilo );
        final int days = sc.nextInt();
        
        System.out.print("Enter minimum calories for day: ");
        final int dailyCalReqForMin = sc.nextInt() ; 
        
        System.out.print("Enter maximum calories for day : ");
        final int dailyCalReqForMax = sc.nextInt() ;  
        
        final double CARBOHYDRATE = 50 ;
        final double FAT = 30 ;
        final double PROTEIN = 20 ;
        final int carCalPerGram = 4 ;
        final int fatCalPerGram = 9 ;
        final int proCalPerGram = 4 ;
        
        double recCarGramsForMin  ; 
        double recFatGramsForMin  ;
        double recProGramsFOrMin  ;
        double recCarCalForMin ;
        double recFatCalForMin ;
        double recProCalForMin ;
        double recCarGramsForMax  ; 
        double recFatGramsForMax  ;
        double recProGramsFOrMax  ;
        double recCarCalForMax ;
        double recFatCalForMax ;
        double recProCalForMax ;

        double dailyDeficit ;  

        System.out.println("\n*************************************************************************************************************************************************");
        dailyDeficit = (kilo * 7700) / days ;
        System.out.printf("To lose %.2f kilograms in %d days you will need a daily deficit of %.2f calories \n" , kilo , days , dailyDeficit);
        System.out.println("*************************************************************************************************************************************************");
        double recDailyDefForMin = dailyCalReqForMin - dailyDeficit ;
        System.out.printf("\nRECOMMENDED DAILY CALORIES TO LOSE IN %.2f IN %d DAYS(considering minimum amount of calories for day): %.0f\n" , kilo , days , recDailyDefForMin) ;

        recCarCalForMin = recDailyDefForMin * CARBOHYDRATE/100  ;
        recFatCalForMin = recDailyDefForMin * FAT/100  ; 
        recProCalForMin = recDailyDefForMin * PROTEIN/100  ; 

        recCarGramsForMin = recCarCalForMin/ carCalPerGram ;
        recFatGramsForMin = recFatCalForMin/ fatCalPerGram ;
        recProGramsFOrMin = recProCalForMin/ proCalPerGram ; 
        
        System.out.println("\n*************************************************************************************************************************************************");
        System.out.println("MACRO                      RECOMMENDED PERCENT                   CALORIES PER GRAM                    MINIMUM CALORIES              MINIMUM GRAMS");
        System.out.printf("CARBOHYDRATE                                %.0f                                   %d                                 %.0f                      %.1f%n" , CARBOHYDRATE , carCalPerGram , recCarCalForMin , recCarGramsForMin);
        System.out.printf("FAT                                         %.0f                                   %d                                 %.0f                      %.1f%n" , FAT , fatCalPerGram , recFatCalForMin , recFatGramsForMin);
        System.out.printf("PROTEIN                                     %.0f                                   %d                                 %.0f                      %.1f%n" ,  PROTEIN , proCalPerGram , recProCalForMin , recCarGramsForMin );
        System.out.println("*************************************************************************************************************************************************");
        double recDailyDefForMax = dailyCalReqForMax - dailyDeficit ;
        System.out.printf("\nRECOMMENDED DAILY CALORIES TO LOSE IN %.2f IN %d DAYS(considering maximum amount of calories for day): %.0f" , kilo , days , recDailyDefForMax) ;
        
        recCarCalForMax = recDailyDefForMax * CARBOHYDRATE/100  ;
        recFatCalForMax = recDailyDefForMax * FAT/100  ; 
        recProCalForMax = recDailyDefForMax * PROTEIN/100  ; 

        recCarGramsForMax = recCarCalForMax/ carCalPerGram ;
        recFatGramsForMax = recFatCalForMax/ fatCalPerGram ;
        recProGramsFOrMax = recProCalForMax/ proCalPerGram ; 
        
        System.out.println("\n*************************************************************************************************************************************************");
        System.out.println("MACRO                      RECOMMENDED PERCENT                   CALORIES PER GRAM                    MAXIMUM CALORIES              MAXIMUM GRAMS");
        System.out.printf("CARBOHYDRATE                                %.0f                                   %d                                 %.0f                      %.1f%n" , CARBOHYDRATE , carCalPerGram , recCarCalForMax , recCarGramsForMax);
        System.out.printf("FAT                                         %.0f                                   %d                                 %.0f                      %.1f%n" , FAT , fatCalPerGram , recFatCalForMax , recFatGramsForMax);
        System.out.printf("PROTEIN                                     %.0f                                   %d                                 %.0f                      %.1f%n" ,  PROTEIN , proCalPerGram , recProCalForMax , recCarGramsForMax );
        System.out.println("*************************************************************************************************************************************************");
        sc.close();

    }
}    
