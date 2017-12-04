import java.util.Scanner;


//This is the introduction to the program. The user inputs their name and destination.
public class LearnScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name?");
        String name = input.nextLine();
        System.out.println("Nice to meet you " + name + ", where are you traveling to?");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip");
        time();
    }

    //This method discusses days traveled. It also discusses money spent.
    public static void time(){
        Scanner input = new Scanner(System.in);
        System.out.println("How many days are you going to spend traveling?");
        int days = input.nextInt();
        System.out.println("How much money, in USD, are you planning to spend on your next trip?");
        double dollars = input.nextDouble();
        System.out.println("What is the three letter currency system for your travel destination?");
        String symbol = input.next();
        System.out.println("How many " + symbol + " are there in 1 USD?");
        double valuable = input.nextDouble();

        //Make sure that money is truncated to 2 decimal points.
        double dailyvalue = dollars/days;
        dailyvalue *= 100;
        dailyvalue = (int)dailyvalue;
        dailyvalue = (double)dailyvalue;
        dailyvalue /= 100.00;

        //Tell me, how much money did I spend and how long my trip was.
        System.out.println("If you are traveling for " + days + " days that is the same as " + days*24 + " hours");
        System.out.println("or " + days*24*60 + " minutes");
        System.out.println("If you are going to spend $" + dollars + " USD");
        System.out.println("that means per day you can spend up to $" + dollars/days + " USD");

        timedifference();
    }

    //Knowing what time it is is a very good thing when traveling.
    public static void timedifference(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the time difference between your home and where you are going?");
        int difference = input.nextInt();
        int correctional = difference % 24;
        System.out.println("That means that when it is midnight at home, it will be " + correctional + ":00");
        System.out.println("in your travel destination and when it is noon at home it will ");
        System.out.println("be " + ((12 + correctional) % 24) + ":00");
        countryarea();
    }

    //Doesnt hurt to know the size of the country you visit
    public static void countryarea(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is the area of your country in square kilometers?");
        double kiloarea = input.nextDouble();

        //Convert miles, so you only round to 2 decimal places.
        double miles = kiloarea*0.386102;
        miles *= 100;
        miles = (int)miles;
        miles = (double)miles;
        miles /= 100;

        //Print out the results.
        System.out.println("In miles2, that is " + kiloarea*0.386102);
        totaldistance();
    }


    //Tell me the total distance using Haversine's formula
    public static void totaldistance(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the latitude and longitude of your home");
        double homelong = input.nextDouble();
        double homelat = input.nextDouble();
        System.out.println("Enter the latitude and longitude of your destination");
        double destlong = input.nextDouble();
        double destlat = input.nextDouble();
        double radius = 6372.8;

        double Latdifference = Math.toRadians(destlat-homelat);
        double Longdifference = Math.toRadians(destlong-homelong);

        double one = Math.pow(Math.sin(Latdifference/2),2);
        double two = one + Math.cos(homelat)*Math.cos(destlat)*Math.pow(Math.sin(Longdifference/2),2);
        double three = 2*Math.asin(Math.sqrt(two));
        System.out.println(radius*three);
    }

}
