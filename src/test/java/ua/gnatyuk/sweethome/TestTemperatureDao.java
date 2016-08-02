package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by yroslav on 8/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class})
public class TestTemperatureDao {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Test
    public void getLastRecord(){
        System.out.println(temperatureDAO.getLastRecord().getId());
    }

    @Test
    public void getTemperaturesDuringOneHour(){
        LocalDateTime begin = LocalDateTime.of(2016,3,22,10,0,0);
        LocalDateTime end = LocalDateTime.of(2016,3,22,11,0,0);

        assertEquals("We must have number of the records > 50 and <60"
                ,true, temperatureDAO.getTemperaturesDuringSomePeriod(begin,end).size()>=50
                && temperatureDAO.getTemperaturesDuringSomePeriod(begin,end).size()<=60);
    }
}
