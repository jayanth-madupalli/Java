import java.util.*;
public class Caesar {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        int ch = 0;
        do{
            System.out.print("\nMenu\n1. Encrypt\n2. Decrypt\n3. Exit\n");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1: caeSar();
                        break;
                case 2: decaeSar();
                        break;
                case 3: System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }while(true);
    }
    static void caeSar(){
        System.out.print("Enter Plaintext: ");
        String s = sc.nextLine ();
        System.out.print("Enter key: ");
        int k = (sc.nextInt() % 26);
        char x[] = s.toCharArray();
        for(int i=0;i<x.length;i++){
            int temp = x[i] + k;
            x[i] = (char) temp;
        }
        System.out.println("CT is: "+String.valueOf(x));
    }
    static void decaeSar(){
        System.out.print("Enter Ciphertext: ");
        String s = sc.nextLine ();
        System.out.print("Enter key: ");
        int k = (sc.nextInt() % 26);
        char x[] = s.toCharArray();
        for(int i=0;i<x.length;i++){
            int temp = x[i] - k;
            x[i] = (char) temp;
        }
        System.out.println("PT is: "+String.valueOf(x));      
    }
}

