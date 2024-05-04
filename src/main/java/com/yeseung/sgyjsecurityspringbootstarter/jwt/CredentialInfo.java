package com.yeseung.sgyjsecurityspringbootstarter.jwt;

import lombok.Data;

@Data
public class CredentialInfo {

    private String credential;


    public CredentialInfo(String password) {
        this.credential = password;
    }

}