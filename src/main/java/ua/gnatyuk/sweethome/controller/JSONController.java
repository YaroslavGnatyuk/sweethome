package ua.gnatyuk.sweethome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.gnatyuk.sweethome.model.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.service.TemperatureService;
import ua.gnatyuk.sweethome.util.TimePeriod;

import java.time.LocalDateTime;
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
    @Qualifier(value = "timePeriodOneDay")
    TimePeriod timePeriodOneDay;

    @Autowired
    @Qualifier(value = "timePeriodOneHour")
    TimePeriod timePeriodOneHour;

    @RequestMapping(path = "/oneday",method = RequestMethod.GET)
    @ResponseBody
//    @CrossOrigin(origins = "*")
    public List<TemperatureDTO> getDataDuringLastDay(){
        if(!isLastRecordFresh()){
            timePeriodOneDay.setEnd(LocalDateTime.now());
            return temperatureService.getDataDuringOneDay(timePeriodOneDay);
        }
        else
            return temperatureService.getDataDuringOneDay(timePeriodOneDay);
    }

    @RequestMapping(path = "/onehour",method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataDuringLastHour(){
        if(!isLastRecordFresh()){
            timePeriodOneHour.setEnd(LocalDateTime.now());
            return temperatureService.getDataDuringOneDay(timePeriodOneHour);
        }
        else
            return temperatureService.getDataDuringOneDay(timePeriodOneHour);
    }

    @RequestMapping(path = "/onehourforward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneHourForward(){
        timePeriodOneHour.shiftForwardByOneHour();
        return temperatureService.getDataDuringNextHour(timePeriodOneHour);
    }

    @RequestMapping(path = "/onehourbackward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneHourBackward(){
        timePeriodOneHour.shiftBackwardByOneHour();
        return temperatureService.getDataDuringPreviousHour(timePeriodOneHour);
    }

    @RequestMapping(path = "/onedayforward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneDayForward(){
        timePeriodOneHour.shiftForwardByOneDay();
        return temperatureService.getDataDuringNextDay(timePeriodOneHour);
    }

    @RequestMapping(path = "/onedaybackward", method = RequestMethod.GET)
    @ResponseBody
    public List<TemperatureDTO> getDataOneDayBackward(){
        timePeriodOneHour.shiftBackwardByOneDay();
        return temperatureService.getDataDuringPreviousDay(timePeriodOneHour);
    }

    private boolean isLastRecordFresh(){
        if( timePeriodOneDay.getEnd().compareTo(LocalDateTime.now())<0 ) {
            return false;
        }
        else
            return true;
    }
}
