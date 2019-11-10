import java.util.InputMismatchException;
import java.util.Scanner;

public class userMenu {

    static Scanner scan = new Scanner(System.in); //User Input
    static LinkedList list = new LinkedList(); //LinkedList Class For Implementation
     
    public static void menu() {
        int a = 0;
        while(a < 1 || a > 5){
        try {
            System.out.println("         ***LinkedList***\n");
            System.out.println("1. Enter User Profile");
            System.out.println("2. Specify Position To Enter User Profile");
            System.out.println("3. Delete User Profile");
            System.out.println("4. Show All User Profile");
            System.out.println("5. Exit\n");
            System.out.print("Action: ");
            a = scan.nextInt();
            scan.nextLine();
        } catch (InputMismatchException E) {
            scan.nextLine();
            menu();
        }
    }
        System.out.println("\n\n");
        path(a);
    }

    public static void path(int a) {
        switch (a) {
        case 1:
            list.insert(addProfile()); menu();
            break;

        case 2:
            list.insertAt(index(), addProfile()); menu();
            break;

        case 3:
            list.delete(index()); menu();
            break;

        case 4:
            list.ShowAll(); scan.nextLine(); menu();
            break;

        case 5:
            System.out.println("\nGoodbye...");
            System.exit(0);

        default:
            menu();
            break;
        }
    }


  
    public static Peeps addProfile() {
        String name = "";
        int age = 0;
        String hobby = "";
        String petName = "";
        String petType = "";
        int a = 0;
        Peeps peepo = new Peeps();
        Animal petAnimal = new Animal();

        System.out.println("***Insert User Profile***\n");

        while (name.equals("")) {
            System.out.print("Enter Name: ");
            name = scan.nextLine();
            peepo.setName(name);
        }

        while (age == 0) {
            try {
                System.out.print("Enter Age: ");
                age = scan.nextInt();
                scan.nextLine();
                peepo.setAge(age);
            } catch (InputMismatchException E) {
                scan.nextLine();
                age = 0;
            }
        }

        while (hobby.equals("")) {
            System.out.print("Enter Hobby: ");
            hobby = scan.nextLine();
            peepo.setHobby(hobby);
        }

        while (petType.equals("")) {
            System.out.print("Type Of Animal Own: ");
            petType = scan.nextLine();
            petAnimal.setPetType(petType);
        }

        while (petName.equals("")) {
            System.out.print("Enter Animal Name: ");
            petName = scan.nextLine();
            petAnimal.setPetName(petName);
        }

        peepo.setPet(petAnimal);

        while (a != 1 && a != 2) {
            try {
                System.out.print("\nOption\n1. Save " + name + "'s Information\n2. Cancel\n\nAction: ");
                a = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException E) {
                scan.nextLine();
                a = 0;
            }
        }

        if (a == 2) {
            menu();
        }

        return peepo;
    }

    public static int index() {
        int a = -1;
        
        while(a < 0){
            try{
                System.out.print("Enter Position: "); a = scan.nextInt(); scan.nextLine();
            }catch(InputMismatchException E){
                scan.nextLine();
                menu();
            }
        }
        
        return a;
    }


}