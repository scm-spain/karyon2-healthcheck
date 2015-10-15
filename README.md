# karyon-health-check-endpoint-module

Karyon-health-check-endpoint-module is a module for the Netflix framework [Karyon](https://github.com/Netflix/karyon) which adds an endpoint /healthcheck [GET] that uses HealthCheckHandler service.

## Documentation

Simply add this module into Modules specification for your AppServer.

```
@KaryonBootstrap(name = "AppServer", healthcheck = AlwaysHealthyHealthCheck.class)
@Modules(include = {
    ...
    HealthCheckEndPointModule.class
})
public interface AppServerForTesting {
    ...
}
```

You will notice that it will use the implementation you set for "healthcheck" into KaryonBootstrap

## Gradle

Add dependency as follows:

```
    compile 'com.scmspain:karyon-health-check-endpoint-module:0.1.0-SNAPSHOT'
```

## AppServer.properties

Make sure you do not set a too restrictive base package in order to get HealthCheckController also included and enabled.

```
com.scmspain.karyon.rest.property.packages=com.scmspain
```
