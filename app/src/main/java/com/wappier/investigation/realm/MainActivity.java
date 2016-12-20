package com.wappier.investigation.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wappier.investigation.realm.model.Person;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm = Realm.getDefaultInstance();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // Add a person
                Person person = realm.createObject(Person.class);
                person.setId(1);
                person.setName("Young Person");
                person.setAge(14);
            }
        });
        // long count = mRealm.where(Person.class).count();
        RealmResults<Person> persons = mRealm.where(Person.class).findAll();
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
