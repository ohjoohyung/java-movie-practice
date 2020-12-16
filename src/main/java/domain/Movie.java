package domain;



import java.util.ArrayList;
import java.util.List;


public class Movie {
    private static final String ALL_PLAY_SCHEDULE_CAPACITY_ZERO_ERROR = "[ERROR] 해당 영화의 예약가능 자리가 없습니다.";
    private static final int ZERO = 0;
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }


    public boolean isMovieId(int movieId) {
        return this.id == movieId;
    }

    public void checkPlayScheduleCapacity() {
        int playScheduleCount = playSchedules.size();
        for (PlaySchedule playSchedule : playSchedules) {
            if (playSchedule.isCapacityZero()) {
                playScheduleCount--;
            }
        }
        if (playScheduleCount == ZERO) {
            throw new IllegalArgumentException(ALL_PLAY_SCHEDULE_CAPACITY_ZERO_ERROR);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}
