package ua.gnatyuk.sweethome.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.List;

@Service
public class TemperatureServImpl implements TemperatureService {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Override
    public List<TemperatureDTO> getTemperatureDuringSomePeriod(ChartPeriod period) {
        return temperatureDAO.getTemperaturesDuringSomePeriod(period);
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

        return timePeriodWithData;
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

        return timePeriodWithData;
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
    public TemperatureDTO getMaxTemperaturePerYearInTheHall(ChartPeriod period) {
        return temperatureDAO.getMaxTemperatureHallPerYear(period);
    }

    @Override
    public TemperatureDTO getMinTemperaturePerYearInTheHall(ChartPeriod period) {
        return temperatureDAO.getMinTemperatureHallPerYear(period);
    }

    @Override
    public TemperatureDTO getMaxTemperaturePerYearInTheKitchen(ChartPeriod period) {
        return temperatureDAO.getMaxTemperatureKitchenPerYear(period);
    }

    @Override
    public TemperatureDTO getMinTemperaturePerYearInTheKitchen(ChartPeriod period) {
        return temperatureDAO.getMinTemperatureKitchenPerYear(period);
    }

    @Override
    public TemperatureDTO getMaxTemperaturePerYearOutside(ChartPeriod period) {
        return temperatureDAO.getMaxTemperatureOutsidePerYear(period);
    }

    @Override
    public TemperatureDTO getMinTemperaturePerYearOutside(ChartPeriod period) {
        return temperatureDAO.getMinTemperatureOutsidePerYear(period);
    }

    @Override
    public List<TemperatureDTO> allMinAndMaxPerPeriod(ChartPeriod period) {
        return temperatureDAO.getallMaxAndMinParameters(period);
    }
}
