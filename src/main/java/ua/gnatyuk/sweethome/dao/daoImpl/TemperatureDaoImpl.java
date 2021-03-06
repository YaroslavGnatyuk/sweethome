package ua.gnatyuk.sweethome.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.model.entities.Temperature;
import ua.gnatyuk.sweethome.util.converter.EntityToDTOConverter;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        return EntityToDTOConverter.convertTemperatureToTemperatureDTO(temperature);
    }

    @Override
    @Transactional(readOnly = true)
    public TemperatureDTO getLastRecord() {
        Temperature temperature = (Temperature) sessionFactory
                .getCurrentSession()
                .createQuery("from Temperature order by date DESC")
                .setMaxResults(1)
                .uniqueResult();

        return EntityToDTOConverter.convertTemperatureToTemperatureDTO(temperature);
    }

    @Override
    @Transactional(readOnly = true)
    public TemperatureDTO getPreviousRecordById(Integer id) {
        Temperature temperature = (Temperature) sessionFactory
                .getCurrentSession()
                .createQuery("FROM Temperature where id = :id")
                .setParameter("id",--id).uniqueResult();    // --id - I get previous record.

            return EntityToDTOConverter.convertTemperatureToTemperatureDTO(temperature);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TemperatureDTO> getTemperaturesDuringSomePeriod(ChartPeriod period) {
        Timestamp beginPeriod = Timestamp.valueOf(period.getBegin());
        Timestamp endPeriod = Timestamp.valueOf(period.getEnd());

        List<Temperature> temperatures = sessionFactory
                .getCurrentSession()
                .createQuery("FROM Temperature s WHERE s.date BETWEEN :beginPeriod AND :endPeriod")
                .setParameter("beginPeriod", beginPeriod)
                .setParameter("endPeriod", endPeriod)
                .list();

        List<TemperatureDTO> temperatureDTOs = new ArrayList<>(temperatures.size());
        temperatures.forEach(x->temperatureDTOs.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(x)));
        return temperatureDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TemperatureDTO> getAllMaxAndMinParameters(ChartPeriod period){

        Comparator<Temperature> compareTemperatureInTheKitchen = (a,b)->a.getTemperatureInside2().compareTo(b.getTemperatureInside2());
        Comparator<Temperature> comparePressure = (a,b)->a.getBarPressure().compareTo(b.getBarPressure());

        List<TemperatureDTO> listOfMaxAndMin = new ArrayList<>(8);

        Session session = sessionFactory.openSession();
        LocalDateTime begin = period.getBegin()
                .minusMonths(period.getBegin().getMonthValue())
                .minusDays(period.getBegin().getDayOfMonth())
                .minusHours(period.getBegin().getHour())
                .minusMinutes(period.getBegin().getMinute())
                .minusSeconds(period.getBegin().getSecond());
        LocalDateTime end = begin.plusYears(1);

        Timestamp beginPeriod = Timestamp.valueOf(begin);
        Timestamp endPeriod = Timestamp.valueOf(end);

        List<Temperature> outside = (List<Temperature>) session.createQuery("FROM Temperature s WHERE s.temperatureOutside BETWEEN 10 AND 50 AND s.date BETWEEN :beginPeriod AND :endPeriod" +
                " ORDER BY s.temperatureOutside ASC")
                .setParameter("beginPeriod", beginPeriod)
                .setParameter("endPeriod", endPeriod)
                .list();

        listOfMaxAndMin.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(outside.get(0)));
        listOfMaxAndMin.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(outside.get(outside.size()-1)));

        List<Temperature> parameters = outside.stream()
                .sorted(compareTemperatureInTheKitchen)
                .filter(t->t.getTemperatureInside2() != 0)
                .collect(Collectors.toList());

        listOfMaxAndMin.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(parameters.get(0)));
        listOfMaxAndMin.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(parameters.get(parameters.size()-1)));

        parameters = outside.stream()
                .sorted(comparePressure)
                .filter(x->x.getBarPressure()>700)
                .collect(Collectors.toList());

        listOfMaxAndMin.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(parameters.get(0)));
        listOfMaxAndMin.add(EntityToDTOConverter.convertTemperatureToTemperatureDTO(parameters.get(parameters.size()-1)));
        return listOfMaxAndMin;
    }
}
