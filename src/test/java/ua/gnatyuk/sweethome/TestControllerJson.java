package ua.gnatyuk.sweethome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.gnatyuk.sweethome.config.SpringConfig;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringConfig.class})
public class TestControllerJson {
    @Autowired
    TemperatureService temperatureService;
    @Autowired
    @Qualifier(value = "timePeriodOneMonth")
    TimePeriod month;

    @Test
    public void testTrimData(){
        List<TemperatureDTO> date = temperatureService.getTemperatureDuringSomePeriod(month);
        System.out.println(date.size());

        List<TemperatureDTO> temp = new ArrayList<>();
        for (int i = 0; i < date.size(); i++) {
            if (i % 20 == 0) {
                temp.add(date.get(i));
            }
        }
        System.out.println(temp.size());
    }
}
