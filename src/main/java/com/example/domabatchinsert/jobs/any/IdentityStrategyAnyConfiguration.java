package com.example.domabatchinsert.jobs.any;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class IdentityStrategyAnyConfiguration {
  private JobRepository jobRepository;
  private PlatformTransactionManager platformTransactionManager;

  public IdentityStrategyAnyConfiguration(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
    this.jobRepository = jobRepository;
    this.platformTransactionManager = platformTransactionManager;
  }

//  @Bean
//  public Job identityStrategyAnyJob(Step identityStrategyAnyJobStep) {
//    return new JobBuilder("identityStrategyAnyJob", jobRepository)
//        .start(identityStrategyAnyJobStep)
//        .build();
//  }

  @Bean
  public Step identityStrategyAnyJobStep(IdentityStrategyAnyReader reader, IdentityStrategyAnyWriter writer) {
    return new StepBuilder("identityStrategyJobAnyStep", jobRepository)
        .<IdentityStrategyAnyEntity, IdentityStrategyAnyEntity>chunk(100, platformTransactionManager)
        .reader(reader)
        .writer(writer)
        .allowStartIfComplete(true)
        .build();
  }
}
