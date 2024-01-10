package com.example.domabatchinsert.orverride;

import org.seasar.doma.jdbc.QueryImplementors;
import org.seasar.doma.jdbc.entity.EntityType;
import org.seasar.doma.jdbc.query.AutoBatchInsertQuery;

import java.lang.reflect.Method;

public class CustomQueryImplementors implements QueryImplementors {
  public <ENTITY> AutoBatchInsertQuery<ENTITY> createAutoBatchInsertQuery(
      Method method, EntityType<ENTITY> entityType) {
    return new CustomAutoBatchInsertQuery<>(entityType);
  }
}
