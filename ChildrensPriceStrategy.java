public class ChildrensPriceStrategy implements RentalPriceStrategy {
    public float calculatePrice(int daysRented) {
        float amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5f;
        }
        return amount;
    }
}
