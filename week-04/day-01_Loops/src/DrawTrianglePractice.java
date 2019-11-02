import java.util.Scanner;

public class DrawTrianglePractice {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("enter a number");

        int size = Scanner.nextInt();
        int NumberOfstars = size;

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < NumberOfstars; i++) {
                System.out.print("*");
            }
            NumberOfstars--;
            System.out.println();
        }
    }
}
//******
//*****
//****
//***
//**
//*