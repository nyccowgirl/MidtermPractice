import java.util.Comparator;

public abstract class Student implements Comparable<Student> {
    private int id;
    private String name;
    private Major major;
    private Graduator graduator;
    private boolean graduated;

    public static final MajorIDComparator MAJOR_ID_COMPARATOR = new MajorIDComparator();

    private static int totalStudents = 0;

    public Student(int id, String name, Major major, Graduator graduator, boolean graduated) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.graduator = graduator;
        this.graduated = graduated;
        totalStudents++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\tName: " + name + "\tMajor: " + major.getAbbreviation() +
                "\tGraduated: " + (graduated ? "yes" : "no");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return id == other.getId() && name.equalsIgnoreCase(other.getName()) &&
                    major.equals(other.getMajor()) && graduated == other.isGraduated();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Student obj) {
        if (name.compareTo(obj.getName()) != 0) {
            return name.compareTo(obj.getName());
        } else {
            return (id > obj.getId() ? 1 : id < obj.getId() ? -1 : 0);
        }
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void register() {
        System.out.println(name + " is registered.");
    }

    public abstract void tuition();

    public static class MajorIDComparator implements Comparator<Student> {

        public int compare(Student s1, Student s2) {
            if (s1.getMajor().compareTo(s2.getMajor()) != 0) {
                return s1.getMajor().compareTo(s2.getMajor());
            } else {
                return (s1.getId() > s2.getId() ? 1: s1.getId() < s2.getId() ? -1 : 0);
            }
        }
    }
}
