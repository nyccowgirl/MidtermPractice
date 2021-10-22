public abstract class BachelorStudent extends Student {
    private double gpa;

    public BachelorStudent(int id, String name, Major major, Graduator graduator, boolean graduated, double gpa) {
        super(id, name, major, graduator, graduated);

        if (gpa >= 0 && gpa <= 4) {
            this.gpa = gpa;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() + "\tGPA: " + gpa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BachelorStudent) {
            BachelorStudent other = (BachelorStudent) obj;
            return super.equals(other) && (Math.abs(gpa - other.getGpa()) < 0.01);
        } else {
            return false;
        }
    }

    @Override
    public void tuition() {
        System.out.println(super.getName() + " pays full tuition.");
    }
}
