package org.depersonalizationAssistant;

import java.util.concurrent.TimeUnit;

import org.depersonalizationAssistant.controller.DiscussaoController;
import org.depersonalizationAssistant.controller.HomeController;
import org.depersonalizationAssistant.controller.PacienteController;
import org.depersonalizationAssistant.controller.RelatorioController;
import org.depersonalizationAssistant.dao.PacienteDAO;
import org.depersonalizationAssistant.dao.RelatorioDAO;
import org.depersonalizationAssistant.interceptor.AuditionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = { HomeController.class, PacienteController.class, PacienteDAO.class,
		RelatorioDAO.class, RelatorioController.class, DiscussaoController.class })
public class AppWebConfiguration implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/", "D:/statics/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuditionInterceptor());
	}

}
