package ua.gnatyuk.sweethome.dao;

import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.util.List;

public interface TemperatureDAO {
    TemperatureDTO getFirstRecord();
    TemperatureDTO getLastRecord();

    List<TemperatureDTO> getTemperaturesDuringSomePeriod(TimePeriod period);
}
