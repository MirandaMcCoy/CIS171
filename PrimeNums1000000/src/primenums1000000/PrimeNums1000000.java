package primenums1000000;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// I don't get any of this??????????

public class PrimeNums1000000 {

    public static void main(String[] args) throws IOException {
        long[] primeNums = new long[1000];
        int count = 0;
        int number = 2;
        int squareRoot = 1;
        boolean isPrime = true;

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("PrimeNumbers.dat", true));) {

            while (number <= 100) { // This while loop SHOULD run through every number less than or equal to 100 and test if prime, then write it to output. But debugging shows it insists
                // on turning isPrime to true when it reaches the if statement. Uh????

                for (int i = 2; i < 10; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                    }
                }
                number++;

                if (isPrime == true) {
                    output.write(number);
                }
                
                isPrime = true;
            }

        }
        try (DataInputStream input = new DataInputStream(new FileInputStream("PrimeNumbers.dat"));) {
            int value;

            while ((value = input.read()) != -1) {
                System.out.print(value + " ");
                count++;

                if (count > 10) {
                    System.out.println();
                    count = 0;
                }
            }
        }

    }

}
