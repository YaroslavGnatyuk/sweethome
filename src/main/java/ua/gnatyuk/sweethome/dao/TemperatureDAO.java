package ua.gnatyuk.sweethome.dao;

import ua.gnatyuk.sweethome.dto.TemperatureDTO;

import java.util.List;

/**
 * Created by yroslav on 8/1/16.
 */
public interface TemperatureDAO {
    TemperatureDTO getLastTemperature();
    List<TemperatureDTO> getAllRecordsBiggest80000();
}
