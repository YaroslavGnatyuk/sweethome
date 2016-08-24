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
    public List<TemperatureDTO> getTemperatureDuringSomePeriod(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public List<TemperatureDTO> getDataDuringNextPeriod(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }

    @Override
    public TemperatureDTO getLastRecord() {
        return temperatureDAO.getLastRecord();
    }

    @Override
    public List<TemperatureDTO> getDataDuringPreviousPreviousPeriod(TimePeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
    }
}
