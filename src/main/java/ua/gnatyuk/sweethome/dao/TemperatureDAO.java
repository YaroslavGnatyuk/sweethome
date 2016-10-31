package ua.gnatyuk.sweethome.dao;

import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.List;

public interface TemperatureDAO {
    TemperatureDTO getFirstRecord();
    TemperatureDTO getLastRecord();

    List<TemperatureDTO> getTemperaturesDuringSomePeriod(ChartPeriod period);
    TemperatureDTO getPreviousRecordById(Integer id);

    public List<TemperatureDTO> getAllMaxAndMinParameters(ChartPeriod period);
}
