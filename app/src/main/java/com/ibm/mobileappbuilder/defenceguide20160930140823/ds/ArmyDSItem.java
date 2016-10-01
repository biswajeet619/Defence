
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ArmyDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("post") public String post;
    @SerializedName("qualification") public String qualification;
    @SerializedName("percentagerequired") public Double percentagerequired;
    @SerializedName("role") public String role;
    @SerializedName("selectionprocess") public String selectionprocess;
    @SerializedName("websiteForApplication") public String websiteForApplication;
    @SerializedName("furtherpromotions") public String furtherpromotions;
    @SerializedName("examToBeWritten") public String examToBeWritten;
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
        dest.writeValue(percentagerequired);
        dest.writeString(role);
        dest.writeString(selectionprocess);
        dest.writeString(websiteForApplication);
        dest.writeString(furtherpromotions);
        dest.writeString(examToBeWritten);
        dest.writeString(id);
    }

    public static final Creator<ArmyDSItem> CREATOR = new Creator<ArmyDSItem>() {
        @Override
        public ArmyDSItem createFromParcel(Parcel in) {
            ArmyDSItem item = new ArmyDSItem();

            item.post = in.readString();
            item.qualification = in.readString();
            item.percentagerequired = (Double) in.readValue(null);
            item.role = in.readString();
            item.selectionprocess = in.readString();
            item.websiteForApplication = in.readString();
            item.furtherpromotions = in.readString();
            item.examToBeWritten = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public ArmyDSItem[] newArray(int size) {
            return new ArmyDSItem[size];
        }
    };

}


