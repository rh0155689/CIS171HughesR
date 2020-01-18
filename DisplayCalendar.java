/**
 * This assignment will print a calendar using the Calendar and the 
 * GregorianCalendar classes
 */
import java.util.*;

public class DisplayCalendar {
    /**
     * The main class
     * author: HughesR
     */
    public static void main(String[] args){
        //Created variable and set them to method output
        int year = getUserYear();
        int month = getUserMonth();                   
        int day = 1; 
        /**
         * Since Java is a 0 based language, I subtract one from the 
         * users input to display the correct month
         */
        month = month - 1;
        //Create an instance of the GC
        Calendar gregCal = new GregorianCalendar(year, month, day); 
        
        //Print month and year header and days of the week         
        String mm = gregCal.getDisplayName(Calendar.MONTH, 
        Calendar.LONG, Locale.getDefault()); 
        System.out.println(); 
        System.out.println("        " + mm + " " + year);        
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        
        //get start day of the week for the first date in the month
        int startDay = gregCal.get(Calendar.DAY_OF_WEEK);
    
        //get number of days in the month
        int numOfDaysInMonth = 
        gregCal.getActualMaximum(Calendar.DAY_OF_MONTH);

        //determine if the year entered is a leap year
        if(month == 1 && year % 4 != 0){ //Not a leap year
          numOfDaysInMonth = 28;
        }
        else if(month == 1 && year % 4 == 0){ //During a leap year
          numOfDaysInMonth = 29;
        }        

        //Set spacing of calendar display
        int i = 0;        
        for (i = 0; i < startDay - 1; i++)
          System.out.print("    ");
    
        for (i = 1; i <= numOfDaysInMonth; i++) {
          if (i < 10)
            System.out.print("   " + i);
          else
            System.out.print("  " + i);
        
          if ((i + startDay - 1) % 7 == 0)
            System.out.println();
        }
    
        System.out.println("");      

        // /**
        //  * Additional required output
        //  */        
        System.out.println("\n" +mm+ "," + gregCal.get(Calendar.YEAR)
         + " contains " + numOfDaysInMonth + " days");
        System.out.println(); 
    }
    //This method takes in user year and verifies that it's numeric
    public static int getUserYear(){
      int userYear = 0;
      Scanner input;
      while(true){
        try{
          input = new Scanner(System.in);
          System.out.print("Enter a numeric year.(eg.2012): ");
          userYear = input.nextInt();
          //input.close();
          return userYear;          
        }
        catch(Exception e){
          System.out.print("Numeric input only \n");
        }        
      }
    }
    //This method takes in user month and verifies it's numeric
    public static int getUserMonth(){
      int userMonth = 0;
      Scanner input;
      while(true){
        try{
          input = new Scanner(System.in);
          System.out.print("Enter a numeric month.(eg. 2 = Feb.): ");
          userMonth = input.nextInt();
          //input.close();
          return userMonth;
        }
        catch(Exception e){
          System.out.print("Numeric input only \n");
        }        
      }
    }
}