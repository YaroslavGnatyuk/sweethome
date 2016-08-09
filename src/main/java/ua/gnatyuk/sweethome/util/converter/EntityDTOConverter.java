package ua.gnatyuk.sweethome.util.converter;

import ua.gnatyuk.sweethome.model.entities.Temperature;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;

public final class EntityDTOConverter {

    public EntityDTOConverter() {

    }

    public static TemperatureDTO convertTemperatureToTemperatureDTO(Temperature temperature){
        if(temperature == null)
            return null;
        TemperatureDTO temperatureDTO = new TemperatureDTO();

        temperatureDTO.setId(temperature.getId());
        temperatureDTO.setBarPressure(temperature.getBarPressure());
        temperatureDTO.setDate(temperature.getDate());
        temperatureDTO.setTemperatureInside1(temperature.getTemperatureInside1());
        temperatureDTO.setTemperatureInside2(temperature.getTemperatureInside2());
        temperatureDTO.setTemperatureOutside(temperature.getTemperatureOutside());
        temperatureDTO.setBarPressure(temperature.getBarPressure());
        return temperatureDTO;
    }
}
