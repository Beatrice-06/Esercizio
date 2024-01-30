import java.util.*;

class Student {
    String firstName;
    String lastName;
    String id;
    double gradeAverage;

    Student(String firstName, String lastName, String id, double gradeAverage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gradeAverage = gradeAverage;
    }
}

public class Infouser {
    private static Scanner scanner = new Scanner(System.in);

    public static void Infouser(String[] args) {
        List<Student> students = getStudentDetails();
        Student topStudent = getTopStudent(students);
        double totalAverage = getTotalAverage(students);

        System.out.println("The student with the highest average is " + topStudent.firstName + " " + topStudent.lastName + " with an average of " + topStudent.gradeAverage);
        System.out.println("The average of all students' averages is " + totalAverage);
    }

    private static List<Student> getStudentDetails() {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the details of student " + (i + 1) + ":");
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last name: ");
            String lastName = scanner.nextLine();
            System.out.print("ID: ");
            String id = scanner.nextLine();
            while (!isValidId(id)) {
                System.out.println("Invalid ID. Please enter a valid ID: ");
                id = scanner.nextLine();
            }
            System.out.print("Grade average: ");
            double gradeAverage = scanner.nextDouble();
            scanner.nextLine(); // consume newline left-over
            students.add(new Student(firstName, lastName, id, gradeAverage));
        }

        return students;
    }

    private static boolean isValidId(String id) {
        // Add your validation logic here. For example, check if the ID is a number and has a certain length.
        return id.matches("\\d+") && id.length() == 3;
    }

    private static Student getTopStudent(List<Student> students) {
        Student topStudent = students.get(0);

        for (Student student : students) {
            if (student.gradeAverage > topStudent.gradeAverage) {
                topStudent = student;
            }
        }

        return topStudent;
    }

    private static double getTotalAverage(List<Student> students) {
        double totalAverage = 0;

        for (Student student : students) {
            totalAverage += student.gradeAverage;
        }

        return totalAverage / students.size();
    }
}

