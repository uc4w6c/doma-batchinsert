package com.example.domabatchinsert.jobs.always;

import org.seasar.doma.jdbc.BatchResult;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IdentityStrategyWriter implements ItemWriter<IdentityStrategyEntity> {
  private IdentityStrategyDao identityStrategyDao;

  public IdentityStrategyWriter(IdentityStrategyDao identityStrategyDao) {
    this.identityStrategyDao = identityStrategyDao;
  }

  @Override
  public void write(Chunk<? extends IdentityStrategyEntity> chunk) throws Exception {
    BatchResult<IdentityStrategyEntity> result = identityStrategyDao.batchInsertIgnoreGeneratedKeys((List<IdentityStrategyEntity>) chunk.getItems());
    System.out.println("always:" + result.getEntities().get(0).id());
  }
}
