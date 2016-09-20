package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by yroslav on 8/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class})
public class TestTemperatureDaoImpl {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Test
    public void getLastRecord(){
        System.out.println(temperatureDAO.getLastRecord().toString());
    }

    @Test
    public void getTemperaturesDuringOneHour(){
        LocalDateTime begin = LocalDateTime.of(2016,3,22,10,0,0);
        LocalDateTime end = LocalDateTime.of(2016,3,22,11,0,0);

        TimePeriod period = new TimePeriod();
        period.setBegin(begin);
        period.setEnd(end);

        assertEquals("We must have number of the records > 50 and <60. This is records per one hour."
                ,true, temperatureDAO.getTemperaturesDuringSomePeriod(period).size()>=50
                && temperatureDAO.getTemperaturesDuringSomePeriod(period).size()<=60);
    }
}
