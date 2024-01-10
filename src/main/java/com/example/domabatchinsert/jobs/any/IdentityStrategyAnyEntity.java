package com.example.domabatchinsert.jobs.any;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import java.util.OptionalInt;
import java.util.OptionalLong;

@Entity
@Table(name = "IDENTITY_STRATEGY_ANY")
public record IdentityStrategyAnyEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    OptionalLong id,
    OptionalInt value) {}
