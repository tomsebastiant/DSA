package basics;

import java.util.Scanner;

public class InputMethod {

    public static void main(String[] args) {
        System.out.println("Enter first number");
        int a =getIntFromScanner();
        System.out.println("Enter second number");
        int b = getIntFromScanner();
        System.out.println("Sum is "+(a+b));
    }

    public static int getIntFromScanner(){
        Scanner scanner = new Scanner(System.in);
        boolean isValidData = false;
        int val=0;
        do{
            try{
                System.out.println("Enter a Number");
                String num = scanner.nextLine();
                val= Integer.parseInt(num);
                isValidData=true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Data, Try Again");
            }
        } while(!isValidData);
        return val;

    }
}
