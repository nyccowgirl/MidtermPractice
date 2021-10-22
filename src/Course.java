public class Course implements Comparable<Course> {

    private String name, professor, location, textbook;
    private int max, enrollment, credits;

    public Course(Builder builder) {
        this.name = builder.name;
        this.professor = builder.professor;
        this.location = builder.location;
        this.textbook = builder.textbook;
        this.max = builder.max;
        this.enrollment = builder.enrollment;
        this.credits = builder.credits;
    }

    public static class Builder {
        private String name, professor, textbook;
        private int enrollment;

        private String location = "Main Campus";
        private int max = 25;
        private int credits = 4;

        public Builder(String name, String professor, String textbook, int enrollment) {
            this.name = name;
            this.professor = professor;
            this.textbook = textbook;
            if (enrollment <= max) {
                this.enrollment = enrollment;
            } else {
                System.out.println("The maximum number of students allowed for this course is " + max + ".");
                this.enrollment = max;
            }
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder max(int max) {
            if (max >= enrollment) {
                this.max = max;
            } else {
                System.out.println("The current enrollment in the course is " + enrollment + " which is greater than" +
                        "the change to the maximum class size.");
                this.max = enrollment;
            }
            return this;
        }

        public Builder credits(int credits) {
            this.credits = credits;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTextbook() {
        return textbook;
    }

    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course: " + name + "\tProfessor: " + professor + "\tLocation: " + location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course other = (Course) obj;
            return (name.equalsIgnoreCase(other.getName()) && professor.equalsIgnoreCase(other.getProfessor()) &&
                    location.equalsIgnoreCase(other.getLocation()) && textbook.equalsIgnoreCase(other.getTextbook()) &&
                    max == other.getMax() && enrollment == other.getEnrollment() && credits == other.getCredits());
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Course obj) {
        if (name.compareTo(obj.getName()) != 0) {
            return professor.compareTo(obj.getProfessor());
        } else {
            return name.compareTo(obj.getName());
        }
    }
}
