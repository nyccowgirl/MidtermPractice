public abstract class GraduateStudent extends Student {
    private String thesis;

    public GraduateStudent(int id, String name, Major major, boolean graduated, String thesis) {
        super(id, name, major, graduated);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() + "\tThesis: " + thesis;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GraduateStudent) {
            GraduateStudent other = (GraduateStudent) obj;
            return super.equals(other) && thesis.equalsIgnoreCase(other.getThesis());
        } else {
            return false;
        }
    }
}
