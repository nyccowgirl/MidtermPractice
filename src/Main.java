import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new BachArtsStudent(123, "Edward Cullen", Major.DRAMA, false, 3.8));
        studentList.add(new MastersStudent(456, "James Bond", Major.ENGINEERING, false, "Quantum Physics"));
        studentList.add(new DocStudent(789, "Yosemite Sam", Major.PHILOSOPHY, false, "The Art of Dynamite"));
        studentList.add(new BachSciStudent(987, "Jane Doe", Major.FINANCE, new ThesisGraduator(),false, 2.8));
        studentList.add(new MastersStudent(654, "Pepe LePeu", Major.SCIENCE, true, "Racy Spices"));
        studentList.add(StudentFactory.newStudent(StudentFactory.StudentType.BACHELOR_ARTS, 823, "Miss Piggy",
                Major.PHILOSOPHY, new CourseRequirementGraduator(), true, 3.7));
        studentList.add(StudentFactory.newGradStudent(StudentFactory.GraduateType.PHD, 999, "Albert Einstein",
                Major.SCIENCE, false, "Human Genome"));

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

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course.Builder("Intro to Japanese", "Inomotosan", "Japanese Workbook 1", 18)
                .build());
        courseList.add(new Course.Builder("Sexual Reproduction", "Maddie Minion", "Rebirth", 11)
                .location("online")
                .credits(3)
                .build());
        courseList.add(new Course.Builder("Masters of Modern Philosophy", "Carl Jung", "Enlightenment",
                21)
                .max(22)
                .build());

        System.out.println("\nCourses:");
        System.out.println(courseList);
    }
}
