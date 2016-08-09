package ua.gnatyuk.sweethome.service;

import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.util.List;

public interface TemperatureService {
    List<TemperatureDTO> getTemperatureDuringOneMonth(TimePeriod period);
    List<TemperatureDTO> getDataDuringOneDay(TimePeriod period);
    List<TemperatureDTO> getTemperatureDuringOneHour(TimePeriod period);

    List<TemperatureDTO> getTemperatureDuringNextMonth(TimePeriod period);
    List<TemperatureDTO> getTemperatureDuringPreviousMonth(TimePeriod period);

    List<TemperatureDTO> getDataDuringNextDay(TimePeriod period);
    List<TemperatureDTO> getDataDuringPreviousDay(TimePeriod period);

    List<TemperatureDTO> getDataDuringNextHour(TimePeriod period);
    List<TemperatureDTO> getDataDuringPreviousHour(TimePeriod period);
}
