package com.example.domabatchinsert.jobs.always;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.OptionalLong;

@Component
public class IdentityStrategyReader implements ItemReader<IdentityStrategyEntity> {
  private List<IdentityStrategyEntity> entities = new ArrayList<IdentityStrategyEntity>();
  private int row = 0;

  public IdentityStrategyReader() {
    for (int i = 0; i < 1000; i++) {
      entities.add(new IdentityStrategyEntity(OptionalLong.empty(), OptionalInt.of(i)));
    }
  }

  @Override
  public IdentityStrategyEntity read() throws Exception {
    if (row < entities.size()) {
      return entities.get(row++);
    }
    return null;
  }
}
