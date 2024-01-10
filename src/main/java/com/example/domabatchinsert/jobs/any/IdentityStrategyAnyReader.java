package com.example.domabatchinsert.jobs.any;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.OptionalLong;

@Component
public class IdentityStrategyAnyReader implements ItemReader<IdentityStrategyAnyEntity> {
  private List<IdentityStrategyAnyEntity> entities = new ArrayList<IdentityStrategyAnyEntity>();
  private int row = 0;

  public IdentityStrategyAnyReader() {
    for (int i = 0; i < 1000; i++) {
      entities.add(new IdentityStrategyAnyEntity(OptionalLong.empty(), OptionalInt.of(i)));
    }
  }

  @Override
  public IdentityStrategyAnyEntity read() throws Exception {
    if (row < entities.size()) {
      return entities.get(row++);
    }
    return null;
  }
}
