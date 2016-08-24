package ua.gnatyuk.sweethome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.time.LocalDateTime;
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
    TimePeriod hour;

    @Autowired
    @Qualifier(value = "timePeriodOneDay")
    TimePeriod day;

    @Autowired
    @Qualifier(value = "timePeriodOneMonth")
    TimePeriod month;

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/lastrecord",method = RequestMethod.GET)
    @ResponseBody
    public TemperatureDTO lastRecord(){
        return temperatureService.getLastRecord();
    }

    @RequestMapping(path = "/onehour",method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataDuringLastHour(){
        LocalDateTime currentTime = LocalDateTime.now();
        hour.setEnd(currentTime);

        return temperatureService.getTemperatureDuringSomePeriod(hour);
    }

    @RequestMapping(path = "/oneday",method = RequestMethod.GET)
    @ResponseBody
//    @CrossOrigin(origins = "*")
    public List<TemperatureDTO> getDataDuringLastDay(){
        LocalDateTime currentTime = LocalDateTime.now();
        day.setEnd(currentTime);

        return temperatureService.getTemperatureDuringSomePeriod(day);
    }

    @RequestMapping(path = "/onemonth",method = RequestMethod.GET)
    @ResponseBody
//    @CrossOrigin(origins = "*")
    public List<TemperatureDTO> getDataDuringLastMonth(){
        LocalDateTime currentTime = LocalDateTime.now();
        month.setEnd(currentTime);

        return trimDataPerMonth((ArrayList<TemperatureDTO>) temperatureService
                .getTemperatureDuringSomePeriod(month));
    }

    @RequestMapping(path = "/onehourforward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneHourForward(){
        hour.shiftForwardByOneHour();
        return temperatureService.getDataDuringNextPeriod(hour);
    }

    @RequestMapping(path = "/onehourbackward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneHourBackward(){
        hour.shiftBackwardByOneHour();
        return temperatureService.getDataDuringPreviousPreviousPeriod(hour);
    }

    @RequestMapping(path = "/onedayforward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneDayForward(){
        hour.shiftForwardByOneDay();
        return temperatureService.getDataDuringNextPeriod(hour);
    }

    @RequestMapping(path = "/onedaybackward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneDayBackward(){
        hour.shiftBackwardByOneDay();
        return temperatureService.getDataDuringPreviousPreviousPeriod(hour);
    }

    private ArrayList<TemperatureDTO> trimDataPerMonth(ArrayList<TemperatureDTO> data){

        ArrayList<TemperatureDTO> temp = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (i % 20 == 0){
                temp.add(data.get(i));
            }
        }

        return temp;
    }
}
