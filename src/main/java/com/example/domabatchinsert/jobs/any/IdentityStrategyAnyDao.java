package com.example.domabatchinsert.jobs.any;

import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;

import java.util.List;

@Dao
@ConfigAutowireable
public interface IdentityStrategyAnyDao {
  @BatchInsert
  BatchResult<IdentityStrategyAnyEntity> batchInsert(List<IdentityStrategyAnyEntity> entities);

  @BatchInsert(ignoreGeneratedKeys = true)
  BatchResult<IdentityStrategyAnyEntity> batchInsertIgnoreGeneratedKeys(List<IdentityStrategyAnyEntity> entities);
}
