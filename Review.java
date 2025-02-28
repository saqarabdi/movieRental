import java.util.ArrayList;
import java.util.List;

public class Review {
    private Movie movie;
    private Customer customer;
    private int rating; // Rating from 1 to 5

    // Static list to store all reviews for movies
    private static List<Review> reviews = new ArrayList<>();

    public Review(Movie movie, Customer customer, int rating) {
        this.movie = movie;
        this.customer = customer;
        this.rating = Math.max(1, Math.min(rating, 5)); // Ensure rating is between 1 and 5
        reviews.add(this);
    }

    public static double getAverageRating(Movie movie) {
        int totalReviews = 0;
        int totalRating = 0;
        for (Review review : reviews) {
            if (review.movie.equals(movie)) {
                totalReviews++;
                totalRating += review.rating;
            }
        }
        return totalReviews > 0 ? (double) totalRating / totalReviews : 0.0;
    }

    public static void displayRatings(Movie movie) {
        System.out.println("Ratings for: " + movie.getTitle());
        int totalReviews = 0;
        for (Review review : reviews) {
            if (review.movie.equals(movie)) {
                System.out.println("Customer: " + review.customer.getName() + " | Rating: " + review.rating + " stars");
                totalReviews++;
            }
        }
        if (totalReviews == 0) {
            System.out.println("No ratings available yet.");
        } else {
            System.out.println("Average Rating: " + getAverageRating(movie) + " stars");
        }
    }
}

