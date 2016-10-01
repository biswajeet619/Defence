
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;
import android.graphics.Bitmap;
import android.net.Uri;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class HISTORYOFARMYDSItem implements Parcelable, IdentifiableBean {

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

    public static final Creator<HISTORYOFARMYDSItem> CREATOR = new Creator<HISTORYOFARMYDSItem>() {
        @Override
        public HISTORYOFARMYDSItem createFromParcel(Parcel in) {
            HISTORYOFARMYDSItem item = new HISTORYOFARMYDSItem();

            item.history = in.readString();
            item.picture = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public HISTORYOFARMYDSItem[] newArray(int size) {
            return new HISTORYOFARMYDSItem[size];
        }
    };

}


