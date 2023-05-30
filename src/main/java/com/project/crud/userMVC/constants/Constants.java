package com.project.crud.userMVC.constants;
public enum Constants {
    SUCCESS_ALL_DELETED,
    FAIL_ALL_DELETED,
    SUCCESS_SOFT_DELETED,
    FAIL_SOFT_DELETED,
    SUCCESS_CURRENT_DELETED,
    FAIL_CURRENT_DELETED;

    public String getName(){
        return name().toLowerCase();
    }
}