package be.belfius.sbcrudrw;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	@Bean
	org.springframework.boot.web.servlet.ServletRegistrationBean h2servletRegistration() {
		org.springframework.boot.web.servlet.ServletRegistrationBean registrationBean = new org.springframework.boot.web.servlet.ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}
}
