package com.smm.vendor.smm;

import com.smm.model.SMMAPIType;

public interface SMMAPIStrategyFactory {

    SMMAPIStrategy getSMMAPIStrategy(SMMAPIType smmapiType);
}
