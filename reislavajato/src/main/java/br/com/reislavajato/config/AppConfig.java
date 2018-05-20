package br.com.reislavajato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // habilita anotações para o gerenciamento de transações do spring (@bean)
@ComponentScans(value = { @ComponentScan("br.com.reislavajato.dao.jpa"), @ComponentScan("br.com.reislavajato.dao"),
		@ComponentScan("br.com.reislavajato.neg"), @ComponentScan("br.com.reislavajato.neg.impl"),
		@ComponentScan("br.com.reislavajato.dao.jpa.auditoria"), @ComponentScan("br.com.reislavajato.dao.auditoria"),
		@ComponentScan("br.com.reislavajato.neg.auditoria"), @ComponentScan("br.com.reislavajato.neg.impl.auditoria") })

// @ComponentScans faz parte de @Configuration, faz varredura nas annotations do
// projeto (nos annotationconfigapplicationContext dos controllers)

public class AppConfig {

	// inicializa entitymanagerfactory JPA com Spring, possibilitando DAOs JPA com
	// injeção de dependências
	@Bean
	public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("reisLavajato");
		return factoryBean;
	}

	// possibilita o entitymanagerfactory a usar JPA ou JDBC, um gerenciador de
	// transações para uma única entitymanager factory
	@Bean
	public JpaTransactionManager geJpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
		return transactionManager;
	}
}
