package ua.gnatyuk.sweethome.service;

import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.util.List;

public interface TemperatureService {
    List<TemperatureDTO> getTemperatureDuringSomePeriod(TimePeriod period);
    TemperatureDTO getLastRecord();
    TemperatureDTO getFirstRecord();
}
