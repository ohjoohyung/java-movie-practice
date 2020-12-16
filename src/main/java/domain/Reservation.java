package domain;

public class Reservation {
    private static final int ZERO = 0;
    private static final String POINT_RANGE_ERROR = "[ERROR] 포인트가 0보다 작거나 금액보다 큽니다.";
    private final Movie movie;
    private final int movieTimeIndex;
    private final int personnel;

    public Reservation(Movie movie, int movieTimeIndex, int personnel) {
        this.movie = movie;
        this.movieTimeIndex = movieTimeIndex;
        this.personnel = personnel;
    }

    public int getMoviePrice() {
        return movie.calculateMoviePrice(personnel);
    }

    public void reducePriceByPoint(int point) {
        int moviePrice = getMoviePrice();
        checkPointRange(point, moviePrice);

    }

    private void checkPointRange(int point, int moviePrice) {
        if (point < ZERO || point > moviePrice) {
            throw new IllegalArgumentException(POINT_RANGE_ERROR);
        }
    }
}
