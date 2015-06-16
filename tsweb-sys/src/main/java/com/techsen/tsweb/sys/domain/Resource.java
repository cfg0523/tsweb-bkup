package com.techsen.tsweb.sys.domain;

public interface Resource {

    public ResourceType getResourceType();
    
}

enum ResourceType {
    Menu, Controller
}