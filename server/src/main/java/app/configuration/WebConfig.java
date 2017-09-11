package app.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 52400 on 2017/6/30.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${online_image_path}")
    private String onlineImagePath;

    @Value("${online_excel_path}")
    private String onlineExcelPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/hospital/image/**").addResourceLocations(onlineImagePath);
        registry.addResourceHandler("/api/image/**").addResourceLocations(onlineImagePath);
        registry.addResourceHandler("/excelDown/**").addResourceLocations(onlineExcelPath);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login.html");
    }

}
