import java.util.Objects;

// I didn't add comments because this is a basic class
public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int studentId;
    private int yearOfBirth;

    public Student(String firstName, String lastName, int studentId, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentId, other.studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
