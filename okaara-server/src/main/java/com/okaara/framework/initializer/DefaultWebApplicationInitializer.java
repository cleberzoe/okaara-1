package com.okaara.framework.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Classe que inicializa o DispatcherServlet do spring
 * 
 * @author fabricio.reis
 *
 */
public class DefaultWebApplicationInitializer implements WebApplicationInitializer {

	boolean debug = true;

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		if (debug) {
			container.setInitParameter("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
		}

		XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
		rootContext.setConfigLocation("classpath:spring/spring.xml");

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/services/*");
	}

}
