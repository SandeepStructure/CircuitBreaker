package com.ubs.f35.servicecapplication;

import com.netflix.discovery.AbstractDiscoveryClientOptionalArgs;
import com.netflix.discovery.EurekaEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class EurekaClientConfig {

    @Bean
    public AbstractDiscoveryClientOptionalArgs<?> discoveryClientOptionalArgs() {
        return new AbstractDiscoveryClientOptionalArgs<Object>() {
            @Override
            public void setEventListeners(Set<EurekaEventListener> listeners) {
                super.setEventListeners(listeners);
            }
        };
    }
}