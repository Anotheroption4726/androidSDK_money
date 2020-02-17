package com.adrien.money;

import android.os.Parcel;
import android.os.Parcelable;

public class Currency implements Parcelable
{
    public String symbol;
    public int flagId;
    public float rate;

    public Currency(String symbol, int flagId, float rate) {
        this.symbol = symbol;
        this.flagId = flagId;
        this.rate = rate;
    }

    protected Currency(Parcel in) {
        symbol = in.readString();
        flagId = in.readInt();
        rate = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(symbol);
        dest.writeInt(flagId);
        dest.writeFloat(rate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };
}
