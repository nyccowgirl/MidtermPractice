public class DocStudent extends GraduateStudent {
    public DocStudent(int id, String name, Major major, boolean graduated, String thesis) {
        super(id, name, major, graduated, thesis);
    }

    @Override
    public void work() {
        System.out.println(super.getName() + " works in research and as a TA.");
    }

    @Override
    public void tuition() {
        System.out.println(super.getName() + " does not pay tuition.");
    }
}
