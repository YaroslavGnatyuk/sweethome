package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.config.SpringWebConfig;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by yroslav on 8/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class, SpringWebConfig.class})
public class TestTimePeriod {
    @Autowired
    @Qualifier(value = "timePeriodOneMonth")
    ChartPeriod month;

    @Autowired
    @Qualifier(value = "timePeriodOneHour")
    ChartPeriod hour;

    @Autowired
    TemperatureService temperatureService;

    @Test
    public void getTimePeriod(){
        System.out.println("Before shifting" + hour.toString());
        hour.shiftBackward();
        System.out.println("After shifting" + hour.toString());
        System.out.println(temperatureService.getTemperatureDuringSomePeriod(hour).toString());
    }
    @Test
    public void compareRecords(){
        TemperatureDTO firstInPeriod = temperatureService
                .getTemperatureDuringSomePeriod(hour)
                .get(0);
        if(firstInPeriod.equals(temperatureService.getFirstRecord())) {
            System.out.println(temperatureService.getTemperatureDuringSomePeriod(hour));
        }

        List<TemperatureDTO> timePeriodWithData;
        do{
            System.out.println("Before shifting: " + hour.toString());
            System.out.println("Making shift");
            hour.shiftBackward();
            System.out.println("After shifting: " + hour.toString());
            timePeriodWithData = temperatureService.getTemperatureDuringSomePeriod(hour);
        }while(timePeriodWithData.isEmpty());

        System.out.println(timePeriodWithData);
    }

    @Test
    public void lastAndFirstRecords(){
        TemperatureDTO lastRec = temperatureService.getLastRecord();

        temperatureService.getTemperatureDuringSomePeriodBackward(hour);
        temperatureService.getTemperatureDuringSomePeriodBackward(hour);
        temperatureService.getTemperatureDuringSomePeriodForward(hour);

        List<TemperatureDTO> temperatureDTOs = temperatureService.getTemperatureDuringSomePeriodForward(hour);
        TemperatureDTO lastRecAlternative = temperatureDTOs.get(temperatureDTOs.size()-1);

        System.out.println("Last record is: " + lastRec.toString());
        System.out.println("Alternative last record is: " + lastRecAlternative.toString());
        assertEquals(true, lastRecAlternative.equals(temperatureService.getLastRecord()));
    }
    @Test
    public void getMaxTemperatureInTheHall(){
        temperatureService.allMinAndMaxPerPeriod(hour).forEach(t->System.out.println(t.toString()));
    }
}
