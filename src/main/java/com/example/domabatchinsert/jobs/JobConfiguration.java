package com.example.domabatchinsert.jobs;

import com.example.domabatchinsert.jobs.any.IdentityStrategyAnyEntity;
import com.example.domabatchinsert.jobs.any.IdentityStrategyAnyReader;
import com.example.domabatchinsert.jobs.any.IdentityStrategyAnyWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobConfiguration {
  private JobRepository jobRepository;

  public JobConfiguration(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
    this.jobRepository = jobRepository;
  }

  @Bean
  public Job identityStrategyJob(Step identityStrategyJobStep, Step identityStrategyAnyJobStep) {
    return new JobBuilder("identityStrategyJob", jobRepository)
        .start(identityStrategyJobStep)
        .next(identityStrategyAnyJobStep)
        .build();
  }
}
