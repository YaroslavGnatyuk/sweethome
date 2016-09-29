package ua.gnatyuk.sweethome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.period.ChartPeriod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yroslav on 8/2/16.
 */
@Controller
@RequestMapping(path = "/")
public class JSONController {

    @Autowired
    TemperatureService temperatureService;

    @Autowired
    @Qualifier(value = "timePeriodOneHour")
    ChartPeriod hour;

    @Autowired
    @Qualifier(value = "timePeriodOneDay")
    ChartPeriod day;

    @Autowired
    @Qualifier(value = "timePeriodOneMonth")
    ChartPeriod month;

    //    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/lastrecord", method = RequestMethod.GET)
    @ResponseBody
    public TemperatureDTO lastRecord()
    {

        return temperatureService.getLastRecord();
    }

    @RequestMapping(path = "/{period}/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataPerSomePeriod(@PathVariable("direction") String direction,
                                                     @PathVariable("period") String period) {
        switch (period) {
            case ("onehour"): {
                switch (direction) {
                    case ("current"): {
                        hour.resetPeriod();
                        return temperatureService.getTemperatureDuringSomePeriod(hour);
                    }
                    case ("fastbackward"): {
                        temperatureService.getTemperatureDuringSomePeriodBackward(hour);
                        return temperatureService.getTemperatureDuringSomePeriodBackward(hour);
                    }
                    case ("backward"): {
                        return temperatureService.getTemperatureDuringSomePeriodBackward(hour);
                    }
                    case ("forward"): {
                        return temperatureService.getTemperatureDuringSomePeriodForward(hour);
                    }
                    case ("fastforward"): {
                        temperatureService.getTemperatureDuringSomePeriodForward(hour);
                        return temperatureService.getTemperatureDuringSomePeriodForward(hour);
                    }
                    default:
                        throw new NullPointerException("This address doesn't serve");
                }
            }

            case ("oneday"): {
                switch (direction) {
                    case ("current"): {
                        day.resetPeriod();
                        return temperatureService.getTemperatureDuringSomePeriod(day);
                    }
                    case ("fastbackward"): {
                        temperatureService.getTemperatureDuringSomePeriodBackward(day);
                        return temperatureService.getTemperatureDuringSomePeriodBackward(day);
                    }
                    case ("backward"): {
                        return temperatureService.getTemperatureDuringSomePeriodBackward(day);
                    }
                    case ("forward"): {
                        return temperatureService.getTemperatureDuringSomePeriodForward(day);
                    }
                    case ("fastforward"): {
                        temperatureService.getTemperatureDuringSomePeriodForward(day);
                        return temperatureService.getTemperatureDuringSomePeriodForward(day);
                    }
                    default:
                        throw new NullPointerException("This address doesn't serve");
                }
            }

            case ("onemonth"): {
                switch (direction) {
                    case ("current"): {
                        month.resetPeriod();
                        return filter(temperatureService
                                .getTemperatureDuringSomePeriod(month));
                    }
                    case ("fastbackward"): {
                        temperatureService.getTemperatureDuringSomePeriodBackward(month);
                        return filter(temperatureService.getTemperatureDuringSomePeriodBackward(month));
                    }
                    case ("backward"): {
                       return filter(temperatureService.getTemperatureDuringSomePeriodBackward(month));
                    }
                    case ("forward"): {
                       return filter(temperatureService.getTemperatureDuringSomePeriodForward(month));
                    }
                    case ("fastforward"): {
                        temperatureService.getTemperatureDuringSomePeriodForward(month);
                        return filter(temperatureService.getTemperatureDuringSomePeriodForward(month));
                    }
                    default:
                        throw new NullPointerException("This address doesn't serve");
                }
            }
        }
        return new ArrayList<>();
    }

    private List<TemperatureDTO> filter(List<TemperatureDTO> data) {
        List<TemperatureDTO> month = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (i % 20 == 0) {
                month.add(data.get(i));
            }
        }
        return month;
    }
}