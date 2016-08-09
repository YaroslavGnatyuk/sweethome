package ua.gnatyuk.sweethome.util;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
@AllArgsConstructor()
@NoArgsConstructor
public class TimePeriod {
    @Getter@Setter private LocalDateTime begin;
    @Getter@Setter private LocalDateTime end;

    public void shiftForwardByOneHour(){
        begin = begin.plusHours(1L);
        end = end.plusHours(1L);
    }

    public void shiftBackwardByOneHour(){
        begin = begin.minusHours(1L);
        end = end.minusHours(1L);
    }

    public void shiftForwardByOneDay(){
        begin = begin.plusDays(1L);
        end = end.plusDays(1L);
    }

    public void shiftBackwardByOneDay(){
        begin = begin.minusDays(1L);
        end = end.minusDays(1L);
    }
}
