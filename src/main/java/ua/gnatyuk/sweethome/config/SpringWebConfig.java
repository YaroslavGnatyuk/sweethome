package ua.gnatyuk.sweethome.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ua.gnatyuk.sweethome.util.*;

import java.time.LocalDateTime;

@Configuration
@ComponentScan("ua.gnatyuk.sweethome")
@EnableWebMvc
@Import({SpringConfig.class})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
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

    @Bean(name = "timePeriodOneDay")
    @Scope(value = "session",   proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TimePeriod getTimePeriodOneDay(){
        LocalDateTime begin = LocalDateTime.now();
        begin = begin.minusHours(begin.getHour());
        begin = begin.minusMinutes(begin.getMinute());
        begin = begin.minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();

        return new TimePeriod(begin,end);
    }

    @Bean(name = "timePeriodOneHour")
    @Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TimePeriod getTimePeriodOneHour(){
        LocalDateTime begin = LocalDateTime.now();
        begin = begin.minusMinutes(begin.getMinute());
        begin = begin.minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();

        return new TimePeriod(begin,end);
    }

    @Bean(name = "timePeriodOneMonth")
    @Scope(value = "session",   proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TimePeriod getTimePeriodOneMonth(){
        LocalDateTime begin = LocalDateTime.now();
        begin = begin.minusDays(begin.getDayOfMonth());
        begin = begin.minusHours(begin.getHour());
        begin = begin.minusMinutes(begin.getMinute());
        begin = begin.minusSeconds(begin.getSecond());

        LocalDateTime end = LocalDateTime.now();

        return new TimePeriod(begin,end);
    }
}
