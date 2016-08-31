package com.cervejaria.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cervejaria.brewer.controller.CervejasController;

@EnableWebMvc
@ComponentScan(basePackageClasses= {CervejasController.class})
@Configuration
public class WebConfig {

}
