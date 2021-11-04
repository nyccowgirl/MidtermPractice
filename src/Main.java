import java.io.*;
import java.util.*;

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

        System.out.println("Total number of students: " + Student.getTotalStudents());

        System.out.println("\nTuition:");

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
//        Collections.sort(studentList, Student.MAJOR_ID_COMPARATOR);
        // Using anonymous class
//        Collections.sort(studentList, new Comparator<Student>() {
//                    @Override
//                    public int compare(Student s1, Student s2) {
//                        if (s1.getMajor().equals(s2.getMajor()))
//                            return (Integer.compare(s1.getId(), s2.getId()));
//                        } else {
//                            return s1.getMajor().compareTo(s2.getMajor());
//                        }
//                    }
//                }
//        );
        // Using lambda
        Collections.sort(studentList,
                (s1, s2) -> (s1.getMajor().equals(s2.getMajor()) ? Integer.compare(s1.getId(), s2.getId()) :
                        s1.getMajor().compareTo(s2.getMajor())));
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

        System.out.println("\nReading and Writing Files:");
        try (Scanner fileScan = new Scanner(new FileReader(new File("test.txt")))) {
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();

                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");
                int id = Integer.parseInt(lineScan.next());
                String name = lineScan.next();
                Major major = Major.valueOf(lineScan.next());
                boolean graduated = Boolean.parseBoolean(lineScan.next());
                String thesis = lineScan.next();
                studentList.add(new DocStudent(id, name, major, graduated, thesis));
            }
            System.out.println("Reading file is complete.");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {
            for (Student s : studentList) {
                fileOut.println(s);
            }
            System.out.println("Writing to file is complete.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nMap:");
        System.out.println("\nBy Major:");
        Map<Major, List<Student>> majorMap = (Map<Major, List<Student>>) createMap("major", studentList);
        for (Map.Entry<Major, List<Student>> entry : majorMap.entrySet()) {
            System.out.println(entry.getKey() + " has " + entry.getValue().size()+ " student(s):");
            for (Student s : entry.getValue()) {
                System.out.println("\t" + s);
            }
        }

        System.out.println("\nBy ID:");
        Map<Integer, Student> studentMap = (Map<Integer, Student>) createMap("ID", studentList);
        for (Student s : studentMap.values()) {
            System.out.println("\t" + s);
        }

        System.out.println("All philosophy majors graduated!");
        List<Student> graduatedList = new ArrayList<Student>();
        for(Student s : studentList) {
            if(s.getMajor()==Major.PHILOSOPHY) {
                s.setGraduated(true);
                System.out.println("\t" + s);
                graduatedList.add(s);
            }
        }

        updateMap(studentMap, graduatedList);
        for (Student s : studentMap.values()) {
            System.out.println("\t" + s);
        }
    }

    public static Map<?, ?> createMap(String category, List<Student> studentList) {

        if (category.equalsIgnoreCase("major")) {
            Map<Major, List<Student>> majorMap = new HashMap<>();

            for (Student s : studentList) {
                Major studentMajor = s.getMajor();

                List<Student> majorList = majorMap.get(studentMajor);

                if (majorList == null) {
                    majorList = new ArrayList<Student>();
                    majorList.add(s);
                    majorMap.put(studentMajor, majorList);
                } else {
                    majorList.add(s);
                }
            }

            return majorMap;
        } else {
            Map<Integer, Student> idMap = new HashMap<>();

            for (Student s : studentList) {
                int id = s.getId();
                idMap.put(id, s);
            }

            return idMap;
        }
    }

    public static void updateMap(Map<Integer, Student> studentMap, List<Student> graduatedList) {
        for (Student s: graduatedList) {
            Student student = studentMap.get(s.getId());

            if (student != null) {
                student.setGraduated(true);
            } else {
                s.setGraduated(true);
                studentMap.put(s.getId(), s);
            }
        }
    }
}
