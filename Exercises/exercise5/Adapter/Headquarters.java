public class Headquarters implements Employee {
    private int salary;

    public Headquarters(int salary) {
        this.salary = salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
