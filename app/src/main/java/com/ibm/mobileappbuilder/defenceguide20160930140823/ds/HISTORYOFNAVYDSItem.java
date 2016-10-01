
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;
import android.graphics.Bitmap;
import android.net.Uri;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class HISTORYOFNAVYDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("history") public String history;
    @SerializedName("picture") public String picture;
    @SerializedName("id") public String id;
    @SerializedName("pictureUri") public transient Uri pictureUri;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(history);
        dest.writeString(picture);
        dest.writeString(id);
    }

    public static final Creator<HISTORYOFNAVYDSItem> CREATOR = new Creator<HISTORYOFNAVYDSItem>() {
        @Override
        public HISTORYOFNAVYDSItem createFromParcel(Parcel in) {
            HISTORYOFNAVYDSItem item = new HISTORYOFNAVYDSItem();

            item.history = in.readString();
            item.picture = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public HISTORYOFNAVYDSItem[] newArray(int size) {
            return new HISTORYOFNAVYDSItem[size];
        }
    };

}


