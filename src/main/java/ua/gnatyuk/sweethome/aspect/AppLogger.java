package ua.gnatyuk.sweethome.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//TODO I should complete development aspect for logging user actions!1. Aspect is working:)!!!
@Aspect
@EnableAspectJAutoProxy
public class AppLogger {
    private static Logger logger = Logger.getLogger(AppLogger.class);

    @Before(value = "execution(* ua.gnatyuk.sweethome.service.TemperatureService.getTemperatureDuringSomePeriodForward(..))")
    public void logBefore(){
        logger.info("user move forward -> ");
        System.out.println("\n\nFORWARD\n\n");
    }
}
