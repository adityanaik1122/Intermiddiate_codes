import java.text.NumberFormat;
import java.util.Scanner;

// मुख्य क्लास (फाइलचे नाव 'Main.java' असणे आवश्यक आहे)
public class Main {
    public static void main(String[] args) {
        // 1. युजरकडून व्हॅल्यूज इनपुट घेणे (Console युटिलिटी वापरून)
        double principal = Console.readDouble("Principal ($): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readDouble("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readDouble("Period (Years): ", 1, 30);

        // 2. कॅलक्युलेटर ऑब्जेक्ट तयार करणे
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);

        // 3. रिपोर्ट ऑब्जेक्ट तयार करून आऊटपुट प्रिंट करणे
        MortgageReport report = new MortgageReport(calculator);
        report.printMortgage();
    }
}

// ----------------- Mortgage Calculator Logic Class -----------------
class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private double principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(double principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal 
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) 
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}

// ----------------- Mortgage Report / Output Class -----------------
class MortgageReport {
    private MortgageCalculator calculator;
    private NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        this.currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double monthlyPayment = calculator.calculateMortgage();
        String resultFormatted = currency.format(monthlyPayment);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + resultFormatted);
    }
}

// ----------------- Console Utility Class for Inputs -----------------
class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readDouble(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}
