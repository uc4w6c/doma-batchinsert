package com.example.domabatchinsert.jobs.any;

import org.seasar.doma.jdbc.BatchResult;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IdentityStrategyAnyWriter implements ItemWriter<IdentityStrategyAnyEntity> {
  private IdentityStrategyAnyDao identityStrategyAnyDao;

  public IdentityStrategyAnyWriter(IdentityStrategyAnyDao identityStrategyAnyDao) {
    this.identityStrategyAnyDao = identityStrategyAnyDao;
  }

  @Override
  public void write(Chunk<? extends IdentityStrategyAnyEntity> chunk) throws Exception {
    BatchResult<IdentityStrategyAnyEntity> result = identityStrategyAnyDao.batchInsert((List<IdentityStrategyAnyEntity>) chunk.getItems());
    System.out.println("any:" + result.getEntities().get(0).id());
  }
}
