package ua.gnatyuk.sweethome.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.services.TemperatureService;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TemperatureServImpl implements TemperatureService {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Override
    public List<TemperatureDTO> getTemperatureDuringOneMonth(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringOneDay(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringOneHour(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringNextMonth(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringPreviousMonth(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringNextDay(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringPreviousDay(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringNextHour(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringPreviousHour(LocalDateTime begin, LocalDateTime end) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(begin, end);
    }
}
