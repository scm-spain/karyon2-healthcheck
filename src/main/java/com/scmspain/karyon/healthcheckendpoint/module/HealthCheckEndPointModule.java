package com.scmspain.karyon.healthcheckendpoint.module;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.netflix.governator.guice.BootstrapModule;
import com.scmspain.karyon.healthcheckendpoint.HealthCheckController;
import netflix.karyon.Karyon;

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

    public static BootstrapModule asBootstrapModule() {
        return Karyon.toBootstrapModule(HealthCheckEndPointModule.class);
    }
}
