
import java.util.Scanner;
import java.text.NumberFormat;

class Main {
    public static void main(String[] args) {
        final Byte MONTHS_IN_YEAR = 12;
        final Byte PERCENT = 100;
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Principle amount of loan you are looking for : ");
        double principle = scanner.nextDouble();
        //System.out.println("You entered principle amount: " + principle);


        System.out.println("Enter the annual rate of intrest : ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        

        System.out.println("Enter the number of years you want for repayment : ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;


        double mortgage = principle 
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                        / Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Total monthly morgage would be : " + mortgageFormatted);
        
        scanner.close();
    }
}
