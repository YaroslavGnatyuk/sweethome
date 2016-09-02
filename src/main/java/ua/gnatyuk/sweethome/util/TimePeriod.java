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

    public void shiftFastForwardByOneHour(){
        begin = begin.plusHours(2L);
        end = end.plusHours(2L);
    }

    public void shiftBackwardByOneHour(){
        begin = begin.minusHours(1L);
        end = end.minusHours(1L);
    }

    public void shiftFastBackwardByOneHour(){
        begin = begin.minusHours(2L);
        end = end.minusHours(2L);
    }
/*--------------------------------------------------*/
    public void shiftForwardByOneDay(){
        begin = begin.plusDays(1L);
        end = end.plusDays(1L);
    }

    public void shiftBackwardByOneDay(){
        begin = begin.minusDays(1L);
        end = end.minusDays(1L);
    }

    public void shiftFastForwardByOneDay(){
        begin = begin.plusDays(2L);
        end = end.plusDays(2L);
    }

    public void shiftFastBackwardByOneDay(){
        begin = begin.minusDays(2L);
        end = end.minusDays(2L);
    }
/*----------------------------------------------------*/
    public void shiftForwardByOneMonth(){
        begin = begin.plusMonths(1L);
        end = end.plusMonths(1L);
    }

    public void shiftBackwardByOneMonth(){
        begin = begin.minusMonths(1L);
        end = end.minusMonths(1L);
    }

    public void shiftFastForwardByOneMonth(){
        begin = begin.plusMonths(2L);
        end = end.plusMonths(2L);
    }

    public void shiftFastBackwardByOneMonth(){
        begin = begin.minusMonths(2L);
        end = end.minusMonths(2L);
    }
}
