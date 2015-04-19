package com.cmu.firstclass.firstclass.entities;

/**
 * This account manager is responsible for taking all kinds of actions that are
 * related to user account. The authentication information is stored inside for
 * the convinience of quick retrive user related information from the database.
 */
public class AuthenticationToken implements IAuthenticationToken {
    private String userKey;

    @Override
    public String accountValidation(String accountName, String password) {
        // TODO
        return null;
    }

    @Override
    public UserType checkUserType(String userID) {
        // TODO
        return null;
    }
}
