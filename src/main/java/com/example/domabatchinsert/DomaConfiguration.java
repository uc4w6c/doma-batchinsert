package com.example.domabatchinsert;

import com.example.domabatchinsert.orverride.CustomQueryImplementors;
import org.seasar.doma.boot.autoconfigure.DomaConfig;
import org.seasar.doma.boot.autoconfigure.DomaConfigBuilder;
import org.seasar.doma.boot.autoconfigure.DomaProperties;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.ConfigSupport;
import org.seasar.doma.jdbc.EntityListenerProvider;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.Naming;
import org.seasar.doma.jdbc.QueryImplementors;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DomaConfiguration {
  /**
   * case: CustomPostgreDialect custom
   *
   * @return
   */
  // @Bean
  public Dialect dialect() {
    return new CustomPostgreDialect();
  }

  /**
   * case: Prevent prepareIdValue if ignoreGeneratedKeys is true (same as PR)
   *
   * @param domaProperties
   * @return
   */
  @Bean
  public DomaConfigBuilder domaConfigBuilder(DomaProperties domaProperties) {
    DomaConfigBuilder domaConfigBuilder = new DomaConfigBuilder(domaProperties);
    domaConfigBuilder.queryImplementors(new CustomQueryImplementors());
    return domaConfigBuilder;
  }

  class CustomPostgreDialect extends PostgresDialect {
    @Override
    public boolean supportsIdentityReservation() {
      return false;
    }
  }
}
