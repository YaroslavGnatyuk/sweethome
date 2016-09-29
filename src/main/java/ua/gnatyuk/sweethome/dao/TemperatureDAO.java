package ua.gnatyuk.sweethome.dao;

import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.List;

public interface TemperatureDAO {
    TemperatureDTO getFirstRecord();
    TemperatureDTO getLastRecord();

    List<TemperatureDTO> getTemperaturesDuringSomePeriod(ChartPeriod period);
    TemperatureDTO getPreviousRecordById(Integer id);

    TemperatureDTO getMaxTemperatureHallPerYear(ChartPeriod year);
    TemperatureDTO getMinTemperatureHallPerYear(ChartPeriod year);

    TemperatureDTO getMaxTemperatureKitchenPerYear(ChartPeriod year);
    TemperatureDTO getMinTemperatureKitchenPerYear(ChartPeriod year);

    TemperatureDTO getMaxTemperatureOutsidePerYear(ChartPeriod year);
    TemperatureDTO getMinTemperatureOutsidePerYear(ChartPeriod year);

    TemperatureDTO getMaxPressurePerYear(ChartPeriod year);
    TemperatureDTO getMinPressurePerYear(ChartPeriod year);

    public List<TemperatureDTO> getallMaxAndMinParameters(ChartPeriod period);
}
