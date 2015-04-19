package com.cmu.firstclass.firstclass.entities;

/**
 * Created by jialiangtan on 4/1/15.
 */
public class ServerRequestor implements IServerRequestor {
    private ServerRequestor serverRequestor;

    private ServerRequestor() {
        // TODO
    }

    @Override
    public IServerRequestor getInstance() {
        if (serverRequestor == null) {
            serverRequestor = new ServerRequestor();
        }
        return serverRequestor;
    }

    /**
     * query for a result of a {@link String} type
     * @param sqlQuery
     */
    private String queryForStringResult(String sqlQuery) {
        // TODO
        return null;
    }

    /**
     * query for a result of an {@link Object} type
     * @param sqlQuery
     */
    private Object queryForObjectResult(String sqlQuery) {
        // TODO
        return null;
    }


}
