package com.techsen.tsweb.sys.domain;

public interface Principal {
    
    public PrincipalType getPrincipalType();
    
}

enum PrincipalType {
    User, Role
}
