
import java.util.Scanner;

public class CollegeTester {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        College college = new College("This College");

        while (true) {
            System.out.println("\nCollege Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. Add International Student");
            System.out.println("4. Add Course to Student");
            System.out.println("5. Get Tuition Fee");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student address: ");
                    String address = scanner.nextLine();
                    college.addStudent(address, name);
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter student address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter research topic: ");
                    String researchTopic = scanner.nextLine();
                    System.out.print("Enter supervisor's name: ");
                    String supervisor = scanner.nextLine();
                    college.addGraduateStudent(address, name, researchTopic, supervisor);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter student address: ");
                    address = scanner.nextLine();
                    System.out.print("Enter country of origin: ");
                    String country = scanner.nextLine();
                    college.addInternationalStudent(address, name, country);
                    break;
                case 4:
                    System.out.print("Enter student number: ");
                    int studentNum = scanner.nextInt();
                    System.out.print("Enter grade points for the course: ");
                    double gradePts = scanner.nextDouble();
                    System.out.print("Enter credits for the course: ");
                    int credits = scanner.nextInt();
                    college.addCourseToStudent(studentNum, gradePts, credits);
                    break;
                case 5:
                    System.out.print("Enter student number: ");
                    studentNum = scanner.nextInt();
                    college.getTuitionFee(studentNum);
                    break;
                case 6:
                    college.displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
