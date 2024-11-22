public class Main {
    public static void main(String[] args) {
        // Target
        Employee headquarters = new Headquarters(1500);
        // Adaptee
        Subsidiary subsidiary = new Subsidiary(1000, 500);
        // Adapter
        Employee subsidiaryAdapter = new SubsidiaryAdapter(subsidiary);

        System.out.println("Employee from headquarters got salary of: " + headquarters.getSalary());
        System.out.println("Employee from subsidiary got salary of: " + subsidiaryAdapter.getSalary());
    }
}
