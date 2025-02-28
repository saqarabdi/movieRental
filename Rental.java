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
        float amount = 0;
            switch (_movie.getPriceCode()) {
                case Movie.REGULAR:
                     amount += 2;
                    if (_daysRented > 2) {
                        amount += (_daysRented - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    amount += _daysRented * 3;
                    break;
                case Movie.CHILDRENS:
                    amount += 1.5;
                    if (_daysRented > 3) {
                        amount += (_daysRented - 3) * 1.5;
                    }
                    break;
            }
            if(_member.getIsMember()){
                if(_member.getTier() == 3){
                    return (float) (amount*.5);
                } else if(_member.getTier() == 2){
                    return (float) (amount*.6);
                } else if (_member.getTier() == 1){
                    return (float) (amount*.7);
                } else {
                    return amount;
                }
            }
        return amount;
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