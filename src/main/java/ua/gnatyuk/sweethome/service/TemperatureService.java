package ua.gnatyuk.sweethome.service;

import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.List;

public interface TemperatureService {
    List<TemperatureDTO> getTemperatureDuringSomePeriod(ChartPeriod period);
    List<TemperatureDTO> getTemperatureDuringSomePeriodForward(ChartPeriod period);
    List<TemperatureDTO> getTemperatureDuringSomePeriodBackward(ChartPeriod period);

    TemperatureDTO getLastRecord();
    TemperatureDTO getFirstRecord();

    List<TemperatureDTO> allMinAndMaxPerPeriod(ChartPeriod period);
}
