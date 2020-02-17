package com.adrien.money;
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable
{

    //POJO
    //Plain old Java object

    private String displayInfo;

    public User(String arg_displayInfo)
    {
        this.displayInfo = arg_displayInfo;
    }

    protected User(Parcel in)
    {
        displayInfo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(displayInfo);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>()
    {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getDisplayInfo()
    {
        return displayInfo;
    }

    public void setDisplayInfo(String arg_displayInfo)
    {
        this.displayInfo = arg_displayInfo;
    }
}
