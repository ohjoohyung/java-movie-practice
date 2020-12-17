package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reservations {
    private static final String ONE_HOUR_RANGE_ERROR = "예약은 일행과 차이가 1시간 이내의 영화만 가능합니다.";
    private static final int MIN_COMPARE_SIZE = 0;

    private final List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void checkReservationsPlaySchedule(PlaySchedule playSchedule) {
        if (reservations.size() > MIN_COMPARE_SIZE) {
            Reservation reservation = reservations.get(MIN_COMPARE_SIZE);
            if (!reservation.isPlayScheduleWithInOneHour(playSchedule)) {
                throw new IllegalArgumentException(ONE_HOUR_RANGE_ERROR);
            }
        }
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }
}
