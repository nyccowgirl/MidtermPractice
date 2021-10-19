public abstract class Student implements Comparable<Student> {
    int id;
    String name;
    Major major;
    boolean graduated;

    private static int totalStudents = 0;

    public Student(int id, String name, Major major, boolean graduated) {
        this.id = id;
        this.name = name;
        this.major = major;
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

    public void register() {
        System.out.println(name + " is registered.");
    }

    public abstract void tuition();
}
