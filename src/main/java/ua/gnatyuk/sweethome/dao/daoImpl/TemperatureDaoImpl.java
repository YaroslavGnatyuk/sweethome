package ua.gnatyuk.sweethome.dao.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.model.entities.Temperature;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.util.TimePeriod;
import ua.gnatyuk.sweethome.util.converter.EntityDTOConverter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class TemperatureDaoImpl implements TemperatureDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public TemperatureDTO getFirstRecord() {
        Temperature temperature = (Temperature) sessionFactory
                .getCurrentSession()
                .createQuery("from Temperature order by date ASC")
                .setMaxResults(1)
                .uniqueResult();

        return EntityDTOConverter.convertTemperatureToTemperatureDTO(temperature);
    }

    @Override
    @Transactional(readOnly = true)
    public TemperatureDTO getLastRecord() {
        Temperature temperature = (Temperature) sessionFactory
                .getCurrentSession()
                .createQuery("from Temperature order by date DESC")
                .setMaxResults(1)
                .uniqueResult();

        return EntityDTOConverter.convertTemperatureToTemperatureDTO(temperature);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TemperatureDTO> getTemperaturesDuringSomePeriod(TimePeriod period) {
        Timestamp beginPeriod = Timestamp.valueOf(period.getBegin());
        Timestamp endPeriod = Timestamp.valueOf(period.getEnd());

        List<Temperature> temperatures = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Temperature s WHERE s.date BETWEEN :beginPeriod AND :endPeriod")
                .setParameter("beginPeriod", beginPeriod)
                .setParameter("endPeriod", endPeriod)
                .list();

        List<TemperatureDTO> temperatureDTOs = new ArrayList<>(temperatures.size());

        for (int i = 0; i < temperatures.size(); i++) {
            temperatureDTOs.add(i,EntityDTOConverter.convertTemperatureToTemperatureDTO(temperatures.get(i)));
        }
        return temperatureDTOs;
    }
}
