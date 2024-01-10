package com.example.domabatchinsert.jobs.always;

import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.BatchResult;

import java.util.List;

@Dao
@ConfigAutowireable
public interface IdentityStrategyDao {
  @BatchInsert
  BatchResult<IdentityStrategyEntity> batchInsert(List<IdentityStrategyEntity> entities);

  @BatchInsert(ignoreGeneratedKeys = true)
  BatchResult<IdentityStrategyEntity> batchInsertIgnoreGeneratedKeys(List<IdentityStrategyEntity> entities);
}
