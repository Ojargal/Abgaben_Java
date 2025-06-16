import java.util.Scanner;
public class Main_Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student st2 = new Student();
        st2.print();
        System.out.println("Geben Sie bitte Name von Student: ");
        String nameInput = sc.nextLine();
//        sc.skip("\n");
        System.out.println("Geben Sie bitte Alter von Student: ");
        int alterInput = sc.nextInt();
        sc.skip("\n");
        System.out.println("Geben Sie bitte Fach von Student: ");
        String fachInput = sc.nextLine();

        Student st1 = new Student(nameInput, alterInput, fachInput);

        st1.print();


        sc.close();
    }
}
