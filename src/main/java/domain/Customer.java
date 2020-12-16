package domain;

public class Customer {
    private final Movie movie;
    private final int movieTimeIndex;
    private final int personnel;

    public Customer(Movie movie, int movieTimeIndex, int personnel) {
        this.movie = movie;
        this.movieTimeIndex = movieTimeIndex;
        this.personnel = personnel;
    }
}
