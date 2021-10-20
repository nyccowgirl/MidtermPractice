public class MastersStudent extends GraduateStudent {
    public MastersStudent(int id, String name, Major major, boolean graduated, String thesis) {
        super(id, name, major, graduated, thesis);
    }

    @Override
    public void work() {
        System.out.println(super.getName() + " works as a TA.");
    }

    @Override
    public void tuition() {
        System.out.println(super.getName() + " pays partial tuition.");
    }
}
