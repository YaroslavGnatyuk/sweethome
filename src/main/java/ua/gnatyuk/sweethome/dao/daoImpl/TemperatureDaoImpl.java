package ua.gnatyuk.sweethome.dao.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.sweethome.converter.EntityDTOConverter;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.dao.entities.Temperature;
import ua.gnatyuk.sweethome.dto.TemperatureDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yroslav on 8/1/16.
 */
@Repository
public class TemperatureDaoImpl implements TemperatureDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public TemperatureDTO getLastTemperature() {
        Temperature temperature = (Temperature) sessionFactory
                .getCurrentSession()
                .createQuery("from Temperature order by date DESC").uniqueResult();

        return EntityDTOConverter.convertTemperatureToTemperatureDTO(temperature);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TemperatureDTO> getAllRecordsBiggest80000() {
        List<Temperature> temperatures = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Temperature where id > 80000").list();
        List<TemperatureDTO> temperatureDTOs = new ArrayList<>(temperatures.size());

        for (int i = 0; i < temperatures.size(); i++) {
            temperatureDTOs.add(i,EntityDTOConverter.convertTemperatureToTemperatureDTO(temperatures.get(i)));
        }

        return temperatureDTOs;
    }
}
