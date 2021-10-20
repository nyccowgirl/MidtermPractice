import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new BachArtsStudent(123, "Edward Cullen", Major.DRAMA, false, 3.8));
        studentList.add(new MastersStudent(456, "James Bond", Major.ENGINEERING, false, "Quantum Physics"));
        studentList.add(new DocStudent(789, "Yosemite Sam", Major.PHILOSOPHY, false, "The Art of Dynamite"));
        studentList.add(new BachSciStudent(987, "Jane Doe", Major.FINANCE, false, 2.8));
        studentList.add(new MastersStudent(654, "Pepe LePeu", Major.SCIENCE, true, "Racy Spices"));

        System.out.println("Tuition:");

        for (Student student: studentList) {
            student.register();
            student.tuition();
        }

        System.out.println("\nWork:");

        for (Student student: studentList) {
            if (student instanceof GraduateStudent) {
                ((GraduateStudent) student).work();
            }
        }

        System.out.println("\nSort:");
        System.out.println("Before Sort:");
        System.out.println(studentList);
        System.out.println("After Sort - with Collections:");
        Collections.sort(studentList);
        System.out.println(studentList);
        System.out.println("After Sort - with Comparator:");
        Collections.sort(studentList, Student.MAJOR_ID_COMPARATOR);
        System.out.println(studentList);

    }
}
