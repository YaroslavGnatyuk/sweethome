package ua.gnatyuk.sweethome.util.period;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ChartPeriod {
    @Getter@Setter private LocalDateTime begin;
    @Getter@Setter private LocalDateTime end;
    @Getter@Setter private LengthOfPeriod type;

    public void shiftForward(){
        switch(type){
            case HOUR:{
                begin = begin.plusHours(1L);
                end = end.plusHours(1L);
                break;
            }
            case DAY:{
                begin = begin.plusDays(1L);
                end = end.plusDays(1L);
                break;
            }
            case MONTH:{
                begin = begin.plusMonths(1L);
                end = end.plusMonths(1L);
                break;
            }
        }
    }

    public void shiftBackward(){
        switch(type){
            case HOUR:{
                begin = begin.minusHours(1L);
                end = end.minusHours(1L);
                break;
            }
            case DAY:{
                begin = begin.minusDays(1L);
                end = end.minusDays(1L);
                break;
            }
            case MONTH:{
                begin = begin.minusMonths(1L);
                end = end.minusMonths(1L);
                break;
            }
        }
    }

    public void resetPeriod(){
        LocalDateTime begin = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();

        switch(type){
            case HOUR:{
                begin = begin
                        .minusMinutes(begin.getMinute())
                        .minusSeconds(begin.getSecond());

                end = end
                        .plusHours(1)
                        .minusMinutes(end.getMinute())
                        .minusSeconds(end.getSecond());
                this.begin = begin;
                this.end = end;
                break;
            }

            case DAY:{
                begin = begin
                        .minusHours(begin.getHour())
                        .minusMinutes(begin.getMinute())
                        .minusSeconds(begin.getSecond());

                end = end
                        .plusDays(1L)
                        .minusHours(end.getHour())
                        .minusMinutes(end.getMinute())
                        .minusSeconds(end.getSecond());
                this.begin = begin;
                this.end = end;
                break;
            }

            case MONTH:{
                begin = begin
                        .minusDays(begin.getDayOfMonth()-1L)
                        .minusHours(begin.getHour())
                        .minusMinutes(begin.getMinute())
                        .minusSeconds(begin.getSecond());

                end = end
                        .minusDays(end.getDayOfMonth()-1L)
                        .plusMonths(1L)
                        .minusHours(end.getHour())
                        .minusMinutes(end.getMinute())
                        .minusSeconds(end.getSecond());

                this.begin = begin;
                this.end = end;
                break;
            }
        }
    }
}
