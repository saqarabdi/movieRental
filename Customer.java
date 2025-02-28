import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental(Rental newRental) {
        _rentals.addElement(newRental);
    }
    
    public String getName() {
        return _name;
    }
    
    public String xmlStatement() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Customer>\n");
        xml.append("  <Name>").append(_name).append("</Name>\n");
        xml.append("  <Rentals>\n");

        Enumeration rentals = _rentals.elements();
        float totalCost = 0;
        int frequentRenterPoints = 0;

        while (rentals.hasMoreElements()) {

            Rental eachRental = (Rental) rentals.nextElement();

            totalCost += eachRental.costOfRental();
            frequentRenterPoints += eachRental.frequentRenterPoints();
            
            xml.append(eachRental.xmlRentalStatement()); // rental satement is created in Rental
        }

        xml.append("  </Rentals>\n");
        xml.append("  <TotalAmount>").append(totalCost).append("</TotalAmount>\n");
        xml.append("  <FrequentRenterPoints>").append(frequentRenterPoints).append("</FrequentRenterPoints>\n");
        xml.append("</Customer>");

        return xml.toString();
    }
}