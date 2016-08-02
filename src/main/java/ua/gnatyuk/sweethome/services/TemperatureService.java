package ua.gnatyuk.sweethome.services;

import ua.gnatyuk.sweethome.dto.TemperatureDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TemperatureService {
    List<TemperatureDTO> getTemperatureDuringOneMonth(LocalDateTime begin, LocalDateTime end);
    List<TemperatureDTO> getTemperatureDuringOneDay(LocalDateTime begin, LocalDateTime end);
    List<TemperatureDTO> getTemperatureDuringOneHour(LocalDateTime begin, LocalDateTime end);

    List<TemperatureDTO> getTemperatureDuringNextMonth(LocalDateTime begin, LocalDateTime end);
    List<TemperatureDTO> getTemperatureDuringPreviousMonth(LocalDateTime begin, LocalDateTime end);

    List<TemperatureDTO> getTemperatureDuringNextDay(LocalDateTime begin, LocalDateTime end);
    List<TemperatureDTO> getTemperatureDuringPreviousDay(LocalDateTime begin, LocalDateTime end);

    List<TemperatureDTO> getTemperatureDuringNextHour(LocalDateTime begin, LocalDateTime end);
    List<TemperatureDTO> getTemperatureDuringPreviousHour(LocalDateTime begin, LocalDateTime end);
}
