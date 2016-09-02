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
                        resetAllPeriods();
                        return temperatureService.getTemperatureDuringSomePeriod(hour);
                    }

                    case ("fastbackward"): {
                        hour.shiftFastBackwardByOneHour();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(hour);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            hour.shiftFastForwardByOneHour();
                            return temperatureService.getTemperatureDuringSomePeriod(hour);
                        }
                    }

                    case ("backward"): {
                        hour.shiftBackwardByOneHour();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(hour);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            hour.shiftForwardByOneHour();
                            return temperatureService.getTemperatureDuringSomePeriod(hour);
                        }
                    }

                    case ("forward"): {
                        hour.shiftForwardByOneHour();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(hour);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            hour.shiftBackwardByOneHour();
                            return temperatureService.getTemperatureDuringSomePeriod(hour);
                        }
                    }

                    case ("fastforward"): {
                        hour.shiftFastForwardByOneHour();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(hour);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            hour.shiftFastBackwardByOneHour();
                            return temperatureService.getTemperatureDuringSomePeriod(hour);
                        }
                    }

                    default:
                        throw new NullPointerException("This address doesn't serve");
                }
            }

            case ("oneday"): {
                switch (direction) {
                    case ("current"): {
                        resetAllPeriods();
                        return temperatureService.getTemperatureDuringSomePeriod(day);
                    }

                    case ("fastbackward"): {
                        day.shiftFastBackwardByOneDay();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(day);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            day.shiftFastForwardByOneDay();
                            return temperatureService.getTemperatureDuringSomePeriod(day);
                        }
                    }

                    case ("backward"): {
                        day.shiftBackwardByOneDay();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(day);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            day.shiftForwardByOneDay();
                            return temperatureService.getTemperatureDuringSomePeriod(day);
                        }
                    }

                    case ("forward"): {
                        day.shiftForwardByOneDay();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(day);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            day.shiftBackwardByOneDay();
                            return temperatureService.getTemperatureDuringSomePeriod(day);
                        }
                    }

                    case ("fastforward"): {
                        day.shiftFastForwardByOneDay();
                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(day);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            day.shiftFastBackwardByOneDay();
                            return temperatureService.getTemperatureDuringSomePeriod(day);
                        }
                    }

                    default:
                        throw new NullPointerException("This address doesn't serve");
                }
            }

            case ("onemonth"): {
                switch (direction) {
                    case ("current"): {
                        resetAllPeriods();
                        return trimDataPerMonth((ArrayList<TemperatureDTO>) temperatureService
                                .getTemperatureDuringSomePeriod(month));
                    }

                    case ("fastbackward"): {
                        month.shiftFastBackwardByOneMonth();

                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(month);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            month.shiftFastForwardByOneMonth();
                            return trimDataPerMonth((ArrayList<TemperatureDTO>) temperatureService
                                    .getTemperatureDuringSomePeriod(month));
                        }
                    }

                    case ("backward"): {
                        month.shiftBackwardByOneMonth();

                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(month);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            month.shiftForwardByOneMonth();
                            return trimDataPerMonth((ArrayList<TemperatureDTO>) temperatureService
                                    .getTemperatureDuringSomePeriod(month));
                        }
                    }

                    case ("forward"): {
                        month.shiftForwardByOneMonth();

                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(month);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            month.shiftBackwardByOneMonth();
                            return trimDataPerMonth((ArrayList<TemperatureDTO>) temperatureService
                                    .getTemperatureDuringSomePeriod(month));
                        }
                    }

                    case ("fastforward"): {
                        day.shiftFastForwardByOneMonth();

                        List<TemperatureDTO> timePeriodWithData =
                                temperatureService.getTemperatureDuringSomePeriod(month);
                        if (!timePeriodWithData.isEmpty()) {
                            return timePeriodWithData;
                        } else {
                            month.shiftFastBackwardByOneMonth();
                            return trimDataPerMonth((ArrayList<TemperatureDTO>) temperatureService
                                    .getTemperatureDuringSomePeriod(month));
                        }
                    }

                    default:
                        throw new NullPointerException("This address doesn't serve");
                }
            }
        }

        return null;
    }

    private ArrayList<TemperatureDTO> trimDataPerMonth(ArrayList<TemperatureDTO> data) {

        ArrayList<TemperatureDTO> temp = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            if (i % 20 == 0) {
                temp.add(data.get(i));
            }
        }

        return temp;
    }

    private void resetAllPeriods(){
        LocalDateTime begin = LocalDateTime.now();
        begin = begin
                .minusMinutes(begin.getMinute())
                .minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();
        end = end
                .plusHours(1)
                .minusMinutes(end.getMinute());
        hour.setBegin(begin);
        hour.setEnd(end);

        begin = begin
                .minusHours(begin.getHour())
                .minusMinutes(begin.getMinute())
                .minusSeconds(begin.getSecond());

        end = end
                .plusDays(1L)
                .minusHours(end.getHour())
                .minusMinutes(end.getMinute())
                .minusSeconds(end.getSecond());
        day.setBegin(begin);
        day.setEnd(end);

        begin = begin
                .minusDays(begin.getDayOfMonth()-1L)
                .minusHours(begin.getHour())
                .minusMinutes(begin.getMinute())
                .minusSeconds(begin.getSecond());

        end = end
                .minusDays(end.getDayOfMonth()-1L)
                .plusMonths(1L)
                .minusHours(end.getHour())
                .minusMinutes(end.getMinute())
                .minusSeconds(end.getSecond());
        month.setBegin(begin);
        month.setEnd(end);
    }
}