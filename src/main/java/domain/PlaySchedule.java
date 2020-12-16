package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private static final String PERSONNEL_RANGE_ERROR = "[ERROR] 예약가능 인원 범위를 벗어났습니다.";
    private static final int ZERO = 0;
    private static final int MIN_PERSONNEL = 1;
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public boolean isCapacityZero() {
        return capacity == ZERO;
    }

    public void checkCapacityRange(int personnel) {
        if (capacity < personnel || personnel < MIN_PERSONNEL) {
            throw new IllegalArgumentException(PERSONNEL_RANGE_ERROR);
        }
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
