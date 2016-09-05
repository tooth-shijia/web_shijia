package com.shijia.web.repository.dao;


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





