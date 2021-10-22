public class Course {

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
            this.enrollment = enrollment;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder max(int max) {
            this.max = max;
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


}
