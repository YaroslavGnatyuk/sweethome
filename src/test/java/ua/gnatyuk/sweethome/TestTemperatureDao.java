package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.dao.TemperatureDAO;

/**
 * Created by yroslav on 8/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class})
public class TestTemperatureDao {
    @Autowired
    TemperatureDAO temperatureDAO;

    @Test
    public void getLastTemp(){
        System.out.println(temperatureDAO.getLastTemperature().getId());
    }

    @Test
    public void getRecordsBiggestThan80000(){
        System.out.println(temperatureDAO.getAllRecordsBiggest80000().size());
    }
}
