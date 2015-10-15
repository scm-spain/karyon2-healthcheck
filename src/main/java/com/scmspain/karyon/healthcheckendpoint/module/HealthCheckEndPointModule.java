package com.scmspain.karyon.healthcheckendpoint.module;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.scmspain.karyon.healthcheckendpoint.HealthCheckController;

/**
 */
public class HealthCheckEndPointModule extends AbstractModule {
    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        bind(HealthCheckController.class).asEagerSingleton();
    }
}
