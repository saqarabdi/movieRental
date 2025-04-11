public class Rental {
    private Movie _movie;
    private Membership _member;
    private int   _daysRented;
    private int _frequentRenterPoints;

    public Rental(Movie movie, int daysRented, Membership member) {
        _movie      = movie;
        _daysRented = daysRented;
        _member = member;   
    }
    
    public int getDaysRented() {
        return _daysRented;
    }
    
    public Movie getMovie() {
        return _movie;
    }

    public float costOfRental() {
        float basePrice = _movie.getPriceStrategy().calculatePrice(_daysRented);
        if (_member.getIsMember()) {
            switch (_member.getTier()) {
                case 3: return basePrice * 0.5f;
                case 2: return basePrice * 0.6f;
                case 1: return basePrice * 0.7f;
            }
        }
        return basePrice;
    }
    

    public int frequentRenterPoints(){
        _frequentRenterPoints++;
                if ((_movie.getPriceCode() == Movie.NEW_RELEASE) &&
                    (_daysRented > 1)) {
                    _frequentRenterPoints++;
                }
                if(_member.getIsMember()){
                    _frequentRenterPoints++;
                }
        return _frequentRenterPoints;
    }

    public String xmlRentalStatement(){
        StringBuilder xml = new StringBuilder();
        xml.append("    <Rental>\n");
        xml.append("      <Movie>").append(_movie.getTitle()).append("</Movie>\n");
        xml.append("      <DaysRented>").append(_daysRented).append("</DaysRented>\n");
        xml.append("      <Amount>").append(costOfRental()).append("</Amount>\n");
        xml.append("    </Rental>\n");

        return xml.toString(); 
    }
}