
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class AirForceDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("post") public String post;
    @SerializedName("qualification") public String qualification;
    @SerializedName("examstobewritten") public String examstobewritten;
    @SerializedName("percentagerequired") public Double percentagerequired;
    @SerializedName("role") public String role;
    @SerializedName("selectionprocess") public String selectionprocess;
    @SerializedName("furtherpromotions") public String furtherpromotions;
    @SerializedName("websiteForApplication") public String websiteForApplication;
    @SerializedName("askExpert") public Long askExpert;
    @SerializedName("id") public String id;

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
        dest.writeString(post);
        dest.writeString(qualification);
        dest.writeString(examstobewritten);
        dest.writeValue(percentagerequired);
        dest.writeString(role);
        dest.writeString(selectionprocess);
        dest.writeString(furtherpromotions);
        dest.writeString(websiteForApplication);
        dest.writeValue(askExpert);
        dest.writeString(id);
    }

    public static final Creator<AirForceDSItem> CREATOR = new Creator<AirForceDSItem>() {
        @Override
        public AirForceDSItem createFromParcel(Parcel in) {
            AirForceDSItem item = new AirForceDSItem();

            item.post = in.readString();
            item.qualification = in.readString();
            item.examstobewritten = in.readString();
            item.percentagerequired = (Double) in.readValue(null);
            item.role = in.readString();
            item.selectionprocess = in.readString();
            item.furtherpromotions = in.readString();
            item.websiteForApplication = in.readString();
            item.askExpert = (Long) in.readValue(null);
            item.id = in.readString();
            return item;
        }

        @Override
        public AirForceDSItem[] newArray(int size) {
            return new AirForceDSItem[size];
        }
    };

}


