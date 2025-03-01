public class Main {
    public static void main(String[] args) {
        // Create genre instances for different genres
        Genre comedyGenre = new Genre("Comedy");
        Genre actionGenre = new Genre("Action");

        // Create customer and membership
        Customer testCustomer = new Customer("Laurenne");  // create a customer
        Membership member = new Membership(testCustomer, 1); // create a membership for the customer

        // Create movies and assign them to genres
        Movie nemoMovie = new Movie("Nemo", 0, comedyGenre);  // Movie (Nemo) in Comedy genre
        Movie shrekMovie = new Movie("Shrek", 0, comedyGenre);  // Movie (Shrek) in Comedy genre
        Movie dieHardMovie = new Movie("Die Hard", 0, actionGenre);  // Movie (Die Hard) in Action genre
        Movie johnWickMovie = new Movie("John Wick", 0, actionGenre);  // Movie (John Wick) in Action genre

        // Create rentals for the movies
        Rental nemoRental = new Rental(nemoMovie, 3, member);  // create rental for movie (Nemo)
        Rental shrekRental = new Rental(shrekMovie, 1, member);  // create rental for movie (Shrek)
        Rental dieHardRental = new Rental(dieHardMovie, 5, member);  // create rental for movie (Die Hard)
        Rental johnWickRental = new Rental(johnWickMovie, 2, member);  // create rental for movie (John Wick)

        // Add rentals to the customer
        testCustomer.addRental(nemoRental);
        testCustomer.addRental(shrekRental);
        testCustomer.addRental(dieHardRental);
        testCustomer.addRental(johnWickRental);

        // Create reviews for the movies
        Review nemoReview = new Review(testCustomer, nemoMovie, 4);  // rating: 4 stars
        Review shrekReview = new Review(testCustomer, shrekMovie, 5);  // rating: 5 stars
        Review dieHardReview = new Review(testCustomer, dieHardMovie, 4);  // rating: 4 stars
        Review johnWickReview = new Review(testCustomer, johnWickMovie, 5);  // rating: 5 stars

        // Add the reviews to the customer and movies
        testCustomer.addReview(nemoReview);
        testCustomer.addReview(shrekReview);
        testCustomer.addReview(dieHardReview);
        testCustomer.addReview(johnWickReview);

        nemoMovie.addReview(nemoReview);
        shrekMovie.addReview(shrekReview);
        dieHardMovie.addReview(dieHardReview);
        johnWickMovie.addReview(johnWickReview);

        // Output the customer's XML statement (no need to change)
        System.out.println(testCustomer.xmlStatement());

        // Display all reviews for the movies with star ratings
        System.out.println("\nReviews for Movies:");
        for (Review review : nemoMovie.getReviews()) {
            System.out.println(review.displayReview());
        }
        for (Review review : shrekMovie.getReviews()) {
            System.out.println(review.displayReview());
        }
        for (Review review : dieHardMovie.getReviews()) {
            System.out.println(review.displayReview());
        }
        for (Review review : johnWickMovie.getReviews()) {
            System.out.println(review.displayReview());
        }

        // Display movies in each genre
        System.out.println("\nMovies in Comedy Genre:");
        comedyGenre.displayMovies();  // Display all movies in the Comedy genre

        System.out.println("\nMovies in Action Genre:");
        actionGenre.displayMovies();  // Display all movies in the Action genre
    }
}
