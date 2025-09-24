public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person(30, "David Alaba");
        Person p3 = new Person(31, "Anna Gasser");

        p1.printPerson();
        System.out.println();
        p2.printPerson();
        System.out.println();
        p3.printPerson();

    }
}
