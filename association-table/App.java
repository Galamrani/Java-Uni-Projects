import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Creating an AssociationTable with Student keys and Integer values
        AssociationTable<Student, Integer> studentTable = new AssociationTable<>();

        // Adding 3 students to the table
        Student student1 = new Student("John", "Doe", 101, 2000);
        Student student2 = new Student("Jane", "Smith", 102, 1999);
        Student student3 = new Student("Bob", "Johnson", 103, 2001); 
        
        studentTable.add(student1, 85);
        studentTable.add(student2, 92);
        studentTable.add(student3, 78);

        // Displaying the original list of students
        System.out.println("Original List of Students:");
        displayStudents(studentTable);

        // Adding a new student
        System.out.println("\nAfter Adding new student to the List of Students:");
        Student newStudent = new Student("Alice", "Williams", 104, 2002);
        studentTable.add(newStudent, 100);
        displayStudents(studentTable);


        // Updating the grade of an existing student
        System.out.println("\nUpdated List of Students:");
        studentTable.add(student2, 95);
        displayStudents(studentTable);

        // Removing an existing student
        System.out.println("\nAfter Removing a student from the List of Students:");
        studentTable.remove(student1);
        displayStudents(studentTable);

    }

    private static void displayStudents(AssociationTable<Student, Integer> studentTable) {
        // Dsiplaying the students from the students list
        Iterator<Student> iterator = studentTable.keyIterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student + ", Average Grade: " + studentTable.get(student));
        }
        System.out.println();
    }
}
