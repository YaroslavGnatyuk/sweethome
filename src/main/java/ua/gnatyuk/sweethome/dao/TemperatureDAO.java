package ua.gnatyuk.sweethome.dao;

import ua.gnatyuk.sweethome.dto.TemperatureDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TemperatureDAO {
    TemperatureDTO getLastRecord();
    List<TemperatureDTO> getTemperaturesDuringSomePeriod(LocalDateTime begin, LocalDateTime end);
}
