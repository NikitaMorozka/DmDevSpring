package com.nikita.dmdevspring.listener.entity;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter
public class EntityEvent extends ApplicationEvent {

    private final AccessType accessType;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }
}
