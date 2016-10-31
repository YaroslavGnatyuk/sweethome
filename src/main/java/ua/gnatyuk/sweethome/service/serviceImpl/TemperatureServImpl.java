package ua.gnatyuk.sweethome.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TemperatureServImpl implements TemperatureService {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Override
    public List<TemperatureDTO> getTemperatureDuringSomePeriod(ChartPeriod period) {
        return filterIncorrectRecords(temperatureDAO.getTemperaturesDuringSomePeriod(period).stream());
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringSomePeriodForward(ChartPeriod period) {
        List<TemperatureDTO> timePeriodWithData = temperatureDAO
                .getTemperaturesDuringSomePeriod(period);

        TemperatureDTO lastInPeriod = timePeriodWithData.get(timePeriodWithData.size()-1);
        TemperatureDTO lastRecord = getLastRecord();

        if(lastInPeriod.equals(lastRecord)) {
            return timePeriodWithData;
        } else do {
            period.shiftForward();
            timePeriodWithData = temperatureDAO.getTemperaturesDuringSomePeriod(period);
        }while(timePeriodWithData.isEmpty());

        return filterIncorrectRecords(timePeriodWithData.stream());
    }

    @Override
    public List<TemperatureDTO> getTemperatureDuringSomePeriodBackward(ChartPeriod period) {
        TemperatureDTO firstInPeriod = temperatureDAO.getTemperaturesDuringSomePeriod(period).get(0);
        List<TemperatureDTO> timePeriodWithData;

        if(firstInPeriod.equals(getFirstRecord())) {
            return temperatureDAO.getTemperaturesDuringSomePeriod(period);
        } else do {
            period.shiftBackward();
            timePeriodWithData = temperatureDAO.getTemperaturesDuringSomePeriod(period);
        }while(timePeriodWithData.isEmpty());

        return filterIncorrectRecords(timePeriodWithData.stream());
    }

    private List<TemperatureDTO> filterIncorrectRecords(Stream<TemperatureDTO> dtoStream){
        return dtoStream.filter(x->x.getBarPressure()>730 && x.getBarPressure()<780)
                .filter(x->x.getTemperatureInside1()>-30 && x.getTemperatureInside1()<50)
                .filter(x->x.getTemperatureInside2()>-30 && x.getTemperatureInside2()<50)
                .filter(x->x.getTemperatureOutside()>-30 && x.getTemperatureOutside()<50)
                .collect(Collectors.toList());
    }

    @Override
    public TemperatureDTO getFirstRecord() {
        return temperatureDAO.getFirstRecord();
    }

    @Override
    public TemperatureDTO getLastRecord() {
        return temperatureDAO.getLastRecord();
    }

    @Override
    public List<TemperatureDTO> allMinAndMaxPerPeriod(ChartPeriod period) {
        return temperatureDAO.getAllMaxAndMinParameters(period);
    }
}
