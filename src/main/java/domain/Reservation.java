package domain;

import utils.DateTimeUtils;

public class Reservation {
    private static final int ZERO = 0;
    private static final String POINT_RANGE_ERROR = "[ERROR] 포인트가 0보다 작거나 금액보다 큽니다.";
    private final Movie movie;
    private final PlaySchedule playSchedule;
    private final int customerCount;

    public Reservation(Movie movie, PlaySchedule playSchedule, int customerCount) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.customerCount = customerCount;
    }

    public int getMoviePrice() {
        return movie.calculateMoviePrice(customerCount);
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

    public boolean isPlayScheduleWithInOneHour(PlaySchedule newPlaySchedule) {
        return playSchedule.isWithInOneHour(newPlaySchedule);
    }

//    public void compareTime(LocalDateTime newMovieTime) {
//        int reservationTime = movie.
//    }

    @Override
    public String toString() {
        return movie.getMovieInfo(movieTimeIndex, personnel);
    }
}
