package com.example.domabatchinsert.jobs.always;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class IdentityStrategyConfiguration {
  private JobRepository jobRepository;
  private PlatformTransactionManager platformTransactionManager;

  public IdentityStrategyConfiguration(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
    this.jobRepository = jobRepository;
    this.platformTransactionManager = platformTransactionManager;
  }

//  @Bean
//  public Job identityStrategyJob(Step step1) {
//    return new JobBuilder("identityStrategyJob", jobRepository)
//        .start(step1)
//        .build();
//  }

  @Bean
  public Step identityStrategyJobStep(IdentityStrategyReader reader, IdentityStrategyWriter writer) {
    return new StepBuilder("identityStrategyJobStep", jobRepository)
        .<IdentityStrategyEntity, IdentityStrategyEntity>chunk(100, platformTransactionManager)
        .reader(reader)
        .writer(writer)
        .allowStartIfComplete(true)
        .build();
  }
}
