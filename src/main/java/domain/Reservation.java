package domain;

public class Reservation {
    private static final String NEW_LINE = "\n";
    private final Movie movie;
    private final PlaySchedule playSchedule;
    private final int customerCount;

    public Reservation(Movie movie, PlaySchedule playSchedule, int customerCount) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.customerCount = customerCount;
        playSchedule.reduceCapacity(customerCount);
    }


    public int getMoviePrice() {
        return movie.calculateMoviePrice(customerCount);
    }

    public boolean isPlayScheduleWithInOneHour(PlaySchedule newPlaySchedule) {
        return playSchedule.isWithInOneHour(newPlaySchedule);
    }

    @Override
    public String toString() {
        return movie.getMovieInfo()
                + playSchedule.toString()
                + "예약 인원: " + customerCount+ "명" + NEW_LINE;
    }
}
