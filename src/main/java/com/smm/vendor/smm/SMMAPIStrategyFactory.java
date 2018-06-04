package com.smm.vendor.smm;

import com.smm.model.enums.SMMAPIType;

public interface SMMAPIStrategyFactory {

    SMMAPIStrategy getSMMAPIStrategy(SMMAPIType smmapiType);
}
