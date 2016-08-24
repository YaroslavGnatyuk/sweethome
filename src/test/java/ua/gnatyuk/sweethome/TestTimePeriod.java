package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.config.SpringWebConfig;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.TimePeriod;

/**
 * Created by yroslav on 8/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class, SpringWebConfig.class})
public class TestTimePeriod {
    @Autowired
    @Qualifier(value = "timePeriodOneMonth")
    TimePeriod month;

    @Autowired
    TemperatureService temperatureService;

    @Test
    public void getTimePeriod(){
        System.out.println(temperatureService.getTemperatureDuringSomePeriod(month).size());

    }
}
