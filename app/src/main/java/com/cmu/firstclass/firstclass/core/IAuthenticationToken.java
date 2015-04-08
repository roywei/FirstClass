package com.cmu.firstclass.firstclass.core;

/**
 * Created by jialiangtan on 4/1/15.
 */
public interface IAuthenticationToken {
    public enum UserType {
        ADMIN,
        NORMAL;
    }

    /**
     * checks the account validity from the database, storing user info if valid
     * @param accountName
     * @param password
     * @return the userKey if the account is valid and null if not
     */
    String accountValidation(String accountName, String password);

    /**
     * checks the user type
     * @param userID the key of the user. This can be retrieved from the database. Note that
     *                userKey is not accountName, it is the allocated user identity key after
     *                a user's registration.
     * @return ADMIN if the user is of type administration and NORMAL if it is a normal user.
     */
    UserType checkUserType(String userID);
}
