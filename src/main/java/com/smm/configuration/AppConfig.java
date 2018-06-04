package com.smm.configuration;

import com.smm.vendor.payment.PayStrategyFactory;
import com.smm.vendor.smm.SMMAPIStrategy;
import com.smm.vendor.smm.SMMAPIStrategyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@ComponentScan(basePackages = {"com.smm"})
@EnableJpaRepositories("com.smm.repository")
public class AppConfig {

    @Bean("payStrategyFactory")
    public FactoryBean payStrategyFactory() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(PayStrategyFactory.class);
        return factoryBean;
    }

    @Bean("smmapiStrategyFactory")
    public FactoryBean smmapiStrategyFactory() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(SMMAPIStrategyFactory.class);
        return factoryBean;
    }


}
