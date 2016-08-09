package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.config.SpringWebConfig;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.time.LocalDateTime;

/**
 * Created by yroslav on 8/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class, SpringWebConfig.class})
public class TestTimePeriod {
    @Autowired
    TimePeriod timePeriod;

    @Test
    public void getTimePeriod(){
        LocalDateTime begin = LocalDateTime.now();
        begin = begin.minusHours(begin.getHour());
        begin = begin.minusMinutes(begin.getMinute());
        begin = begin.minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();

        System.out.println(begin.toString() + " !!! " + end.toString());

    }
}
