package com.smm.vendor.smm;

import com.smm.model.emun.SMMAPIType;

public interface SMMAPIStrategyFactory {

    SMMAPIStrategy getSMMAPIStrategy(SMMAPIType smmapiType);
}
