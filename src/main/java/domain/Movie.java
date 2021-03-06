package domain;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Movie {
    private static final String ALL_PLAY_SCHEDULE_CAPACITY_ZERO_ERROR = "[ERROR] 해당 영화의 예약가능 자리가 없습니다.";
    private static final String INDEX_PLAY_SCHEDULE_CAPACITY_ZERO_ERROR = "[ERROR] 해당 순서의 예약가능 자리가 없습니다.";
    private static final String INDEX_RANGE_ERROR = "[ERROR] 영화 시간표 순서를 벗어났습니다.";
    private static final int MIN_INDEX = 1;
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

    public PlaySchedule findPlayScheduleByIndex(int index) {
        checkPlayScheduleIndexRange(index);
        checkPlayScheduleCapacityByIndex(index);
        return playSchedules.get(index - 1);
    }


    private void checkPlayScheduleIndexRange(int index) {
        if (index < MIN_INDEX || index > playSchedules.size()) {
            throw new IllegalArgumentException(INDEX_RANGE_ERROR);
        }
    }

    private void checkPlayScheduleCapacityByIndex(int index) {
        PlaySchedule playSchedule = playSchedules.get(index - 1);
        if (playSchedule.isCapacityZero()) {
            throw new IllegalArgumentException(INDEX_PLAY_SCHEDULE_CAPACITY_ZERO_ERROR);
        }
    }


    public int calculateMoviePrice(int personnel) {
        return price * personnel;
    }

    public String getMovieInfo() {
        return id + " - " + name + ", " + price + "원" + NEW_LINE;
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
