public class StudentFactory {

    public static enum StudentType {
        BACHELOR_ARTS, BACHELOR_SCIENCE, MASTERS, PHD;
    }

    public static enum BachelorType {
        ARTS, SCIENCE;
    }

    public static enum GraduateType {
        MASTERS, PHD;
    }

    public static Student newStudent(StudentType type, int id, String name, Major major, Graduator graduator,
                                     boolean graduated, Object... other) {
        Student s = null;
        String error = "";

        if (type == StudentType.BACHELOR_ARTS || type == StudentType.BACHELOR_SCIENCE) {
            if (other[0] instanceof Double) {
                double gpa = (Double) other[0];

                if (type == StudentType.BACHELOR_ARTS) {
                    s = new BachArtsStudent(id, name, major, graduated, gpa);
                } else if (type == StudentType.BACHELOR_SCIENCE) {
                    s = new BachSciStudent(id, name, major, graduator, graduated, gpa);
                }
            } else {
                error = "BachelorStudent requires a double gpa in the constructor. Cannot process " + other[0];
            }
        } else if (type == StudentType.MASTERS || type == StudentType.PHD) {
            if (other[0] instanceof String) {
                String thesis = (String) other[0];

                if (type == StudentType.MASTERS) {
                    s = new MastersStudent(id, name, major, graduated, thesis);
                } else if (type == StudentType.PHD) {
                    s = new DocStudent(id, name, major, graduated, thesis);
                }
            } else {
                error = "GraduateStudent requires a String thesis in the constructor. Cannot process " + other[0];
            }
        }

        if (s == null) {
            throw new IllegalArgumentException("Student was not created. " + error);
        } else {
            return s;
        }
    }

    public static BachelorStudent newBachStudent(BachelorType type, int id, String name, Major major, Graduator graduator,
                                                 boolean graduated, double gpa) {
        BachelorStudent s = null;

        if (type == BachelorType.ARTS) {
            s = new BachArtsStudent(id, name, major, graduated, gpa);
        } else if (type == BachelorType.SCIENCE) {
            s = new BachSciStudent(id, name, major, graduator, graduated, gpa);
        }

        return s;
    }

    public static GraduateStudent newGradStudent(GraduateType type, int id, String name, Major major, boolean graduated, String thesis) {
        GraduateStudent s = null;

        if (type == GraduateType.MASTERS) {
            s = new MastersStudent(id, name, major, graduated, thesis);
        } else if (type == GraduateType.PHD) {
            s = new DocStudent(id, name, major, graduated, thesis);
        }

        return s;
    }
}
