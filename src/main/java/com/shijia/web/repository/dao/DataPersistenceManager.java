package com.shijia.web.repository.dao;

/**
 * Created by Tangxinqi on 2016/7/31.
 */
public class DataPersistenceManager {

    private static  DataPersistenceManager dataPersistenceManager;

    public  static synchronized DataPersistenceManager getInstance(){
        if(dataPersistenceManager == null){
            dataPersistenceManager =  new DataPersistenceManager();
            return dataPersistenceManager;
        }
        return dataPersistenceManager;
    }

    private DataPersistenceObject dataPersistenceObject;

    public DataPersistenceObject getDataPersistenceObject() {
        return dataPersistenceObject;
    }

    public void setDataPersistenceObject(DataPersistenceObject dataPersistenceObject) {
        this.dataPersistenceObject = dataPersistenceObject;
    }
}
