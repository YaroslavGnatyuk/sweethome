package ua.gnatyuk.sweethome.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.util.List;
@Service
public class TemperatureServImpl implements TemperatureService {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Override
    public List<TemperatureDTO> getTemperatureDuringOneMonth(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getDataDuringOneDay(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringOneHour(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringNextMonth(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringPreviousMonth(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getDataDuringNextDay(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getDataDuringPreviousDay(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getDataDuringNextHour(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getDataDuringPreviousHour(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }
}
