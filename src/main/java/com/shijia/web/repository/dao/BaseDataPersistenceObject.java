package com.shijia.web.repository.dao;


import org.springframework.context.support.ApplicationObjectSupport;

/**
 * Created by Tangxinqi on 2016/6/18.
 */
public abstract class BaseDataPersistenceObject  implements DataPersistenceObject {

    private boolean isAutoTransaction = true;

    public boolean isAutoTransaction() {

        return isAutoTransaction;
    }

    public void setAutoTransaction(boolean autoTransaction) {
        isAutoTransaction = autoTransaction;
    }
}





