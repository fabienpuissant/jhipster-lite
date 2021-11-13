package tech.jhipster.forge.generator.server.springboot.dbmigration.liquibase.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.forge.generator.buildtool.generic.domain.BuildToolService;
import tech.jhipster.forge.generator.project.domain.ProjectRepository;
import tech.jhipster.forge.generator.server.springboot.dbmigration.liquibase.domain.LiquibaseDomainService;
import tech.jhipster.forge.generator.server.springboot.dbmigration.liquibase.domain.LiquibaseService;
import tech.jhipster.forge.generator.server.springboot.properties.domain.SpringBootPropertiesService;

@Configuration
public class LiquibaseServiceBeanConfiguration {

  public final ProjectRepository projectRepository;
  public final BuildToolService buildToolService;
  public final SpringBootPropertiesService springBootPropertiesService;

  public LiquibaseServiceBeanConfiguration(
    ProjectRepository projectRepository,
    BuildToolService buildToolService,
    SpringBootPropertiesService springBootPropertiesService
  ) {
    this.projectRepository = projectRepository;
    this.buildToolService = buildToolService;
    this.springBootPropertiesService = springBootPropertiesService;
  }

  @Bean
  public LiquibaseService liquibaseService() {
    return new LiquibaseDomainService(projectRepository, buildToolService, springBootPropertiesService);
  }
}
