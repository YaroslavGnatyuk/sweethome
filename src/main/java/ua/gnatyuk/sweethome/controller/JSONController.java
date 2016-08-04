package ua.gnatyuk.sweethome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.gnatyuk.sweethome.dto.TemperatureDTO;
import ua.gnatyuk.sweethome.services.TemperatureService;

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

    @RequestMapping(path = "/oneweek",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin(origins = "*")
    public List<TemperatureDTO> getTemperatureDuringOneHour(){

        LocalDateTime begin = LocalDateTime.of(2016,07,13,0,0);
        LocalDateTime end = LocalDateTime.of(2016,07,20,0,0);

        return temperatureService.getTemperatureDuringOneHour(begin,end);
    }

}
