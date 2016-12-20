package com.wappier.investigation.realm;

import android.app.Application;

import io.realm.Realm;

public class RealmApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
