package com.scmspain.karyon.healthcheckendpoint.common;

import com.google.inject.Singleton;
import com.netflix.governator.annotations.Modules;
import com.scmspain.karyon.healthcheckendpoint.module.HealthCheckEndPointModule;
import netflix.karyon.KaryonBootstrap;
import netflix.karyon.health.AlwaysHealthyHealthCheck;
import scmspain.karyon.restrouter.KaryonRestRouterModule;

@KaryonBootstrap(name = "AppServer", healthcheck = AlwaysHealthyHealthCheck.class)
@Singleton
@Modules(include = {
    AppServerForTesting.KaryonRestRouterModuleImpl.class,
    HealthCheckEndPointModule.class
})
public interface AppServerForTesting {
    class KaryonRestRouterModuleImpl extends KaryonRestRouterModule {

        public static final int DEFAULT_PORT = 8000;
        public static final int DEFAULT_THREADS = 20;

        @Override
        protected void configureServer() {
            server().port(DEFAULT_PORT).threadPoolSize(DEFAULT_THREADS);
        }

        @Override
        public void configure()
        {
            super.configure();
        }
    }
}
