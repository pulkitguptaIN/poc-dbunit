package me.pulkit.playground.context.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import me.pulkit.playground.bean.Employee;
import me.pulkit.playground.context.PocDbunitContext;
import me.pulkit.playground.service.EmployeeService;

public class PocDbunitContextHandler {

	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		try (GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				PocDbunitContext.class)) {
			LOGGER.info("PocDbunit application processing started...");
			EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
			Employee employee = employeeService.read(1);
			System.out.println(employee);
			LOGGER.info("PocDbunit application processing completed...");
		} catch (Exception e) {
			LOGGER.error("Unexpected error occurred..", e);
		}

	}

}
