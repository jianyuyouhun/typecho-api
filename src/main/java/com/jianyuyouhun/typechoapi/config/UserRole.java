package com.jianyuyouhun.typechoapi.config;

public enum UserRole {
    ADMIN("administrator"),
    VISITOR("visitor");
    public String value;
    UserRole(String value){
        this.value = value;
    }
}
