public class SubsidiaryAdapter implements Employee {
    private Subsidiary subsidiary;

    public SubsidiaryAdapter(Subsidiary subsidiary) {
        this.subsidiary = subsidiary;
    }

    @Override
    public int getSalary() {
        return subsidiary.getBase() + subsidiary.getBonus();
    }
}
