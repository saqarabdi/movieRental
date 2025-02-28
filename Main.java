import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Customer testCustomer = new Customer("Laurenne");
        Membership member = new Membership(testCustomer, 1);
        Movie nemoMovie = new Movie("Nemo", 0);
        Rental nemoRental = new Rental(nemoMovie, 3, member);
        Movie shrekMovie = new Movie("Shrek", 0);
        Rental shrekRental = new Rental(shrekMovie, 1, member);
        testCustomer.addRental(nemoRental);   
        testCustomer.addRental(shrekRental);
        System.out.println(testCustomer.xmlStatement());
      }
}
