package ua.gnatyuk.sweethome.config;

import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ua.gnatyuk.sweethome.util.period.ChartPeriod;
import ua.gnatyuk.sweethome.util.period.LengthOfPeriod;

import java.time.LocalDateTime;

@Configuration
@ComponentScan("ua.gnatyuk.sweethome")
@EnableWebMvc
@Import({SpringConfig.class})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);

        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean(name = "timePeriodOneHour")
    @Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ChartPeriod getTimePeriodOneHour(){

        LocalDateTime begin = LocalDateTime.now();
        begin = begin
                .minusMinutes(begin.getMinute())
                .minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();
        end = end
                .plusHours(1)
                .minusMinutes(end.getMinute());

        return new ChartPeriod(begin,end, LengthOfPeriod.HOUR);
    }

    @Bean(name = "timePeriodOneDay")
    @Scope(value = WebApplicationContext.SCOPE_SESSION,   proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ChartPeriod getTimePeriodOneDay(){

        LocalDateTime begin = LocalDateTime.now();
        begin = begin
                .minusHours(begin.getHour())
                .minusMinutes(begin.getMinute())
                .minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();
        end = end
                .plusDays(1L)
                .minusHours(end.getHour())
                .minusMinutes(end.getMinute())
                .minusSeconds(end.getSecond());

        return new ChartPeriod(begin,end, LengthOfPeriod.DAY);
    }

    @Bean(name = "timePeriodOneMonth")
    @Scope(value = WebApplicationContext.SCOPE_SESSION,   proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ChartPeriod getTimePeriodOneMonth(){

        LocalDateTime begin = LocalDateTime.now();
        begin = begin
                .minusDays(begin.getDayOfMonth()-1L)
                .minusHours(begin.getHour())
                .minusMinutes(begin.getMinute())
                .minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();
        end = end
                .minusDays(end.getDayOfMonth()-1L)
                .plusMonths(1L)
                .minusHours(end.getHour())
                .minusMinutes(end.getMinute())
                .minusSeconds(end.getSecond());

        return new ChartPeriod(begin,end, LengthOfPeriod.MONTH);
    }
}