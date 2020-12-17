package domain;

import utils.DateTimeUtils;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private static final String PERSONNEL_RANGE_ERROR = "[ERROR] 예약가능 인원 범위를 벗어났습니다.";
    private static final String ONE_HOUR_RANGE_ERROR = "[ERROR] 예매한 영화와의 상영 시간 차이가 1시간 이내여야합니다.";
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

    public void reduceCapacity(int personnel) {
        checkCapacityRange(personnel);
        capacity -= personnel;
    }

    public void checkCapacityRange(int customerCount) {
        if (capacity < customerCount || customerCount < MIN_PERSONNEL) {
            throw new IllegalArgumentException(PERSONNEL_RANGE_ERROR);
        }
    }

    public void compareTime(LocalDateTime newMovieTime) {
        if (!DateTimeUtils.isOneHourWithinRange(startDateTime, newMovieTime)) {
            throw new IllegalArgumentException(ONE_HOUR_RANGE_ERROR);
        }
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean isWithInOneHour(PlaySchedule newPlaySchedule) {
        return DateTimeUtils.isOneHourWithinRange(startDateTime, newPlaySchedule.startDateTime);
    }



    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }
}
