package ua.gnatyuk.sweethome.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//TODO I should complete development aspect for logging user actions!
@Aspect
@EnableAspectJAutoProxy
public class AppLogger {
    private static Logger logger = Logger.getLogger(AppLogger.class.getName());

    @Before(value = "execution(* ua.gnatyuk.sweethome.service.serviceImpl.TemperatureServImpl.getTemperatureDuringSomePeriodBackward())")
    public void logBefore(){
        logger.info("Move forward ...");
        System.out.println("forward");
    }
}
