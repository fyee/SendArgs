package com.howzhi.sendargs.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by howzhi on 15-8-19.
 */
//public class User implements Serializable {
public class User implements Parcelable {
    private String userName;
    private int age;

    public User(String name, int age) {
        this.userName = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getUserName());
        dest.writeInt(getAge());
    }

    public static final Creator<User> CREATOR  = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source.readString(), source.readInt()); //多个同样类型的属性时，使用 bundle
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
