# karyon2-healthcheck

This a module for the Netflix framework [Karyon](https://github.com/Netflix/karyon) which adds an endpoint /healthcheck [GET] that uses HealthCheckHandler service.
It works close to karyon-rest-router

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

You will notice that it will use the implementation you set for "healthcheck" into KaryonBootstrap.
See AppServerForTesting for further details and a functional implementation.

## Gradle

Add dependency as follows:

```
    compile 'com.scmspain.karyon:karyon-healthcheck:0.1.1'
```

## AppServer.properties

Make sure you do not set a too restrictive base package in order to get HealthCheckController also included and enabled.

```
com.scmspain.karyon.rest.property.packages=com.scmspain
```
