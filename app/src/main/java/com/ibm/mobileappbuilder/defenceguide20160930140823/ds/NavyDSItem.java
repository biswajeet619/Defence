
package com.ibm.mobileappbuilder.defenceguide20160930140823.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class NavyDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("post") public String post;
    @SerializedName("qualification") public String qualification;
    @SerializedName("percentageRequired") public Double percentageRequired;
    @SerializedName("selectionProcess") public String selectionProcess;
    @SerializedName("role") public String role;
    @SerializedName("websiteForApplication") public String websiteForApplication;
    @SerializedName("furtherpromotions") public String furtherpromotions;
    @SerializedName("examsToBeWritten") public String examsToBeWritten;
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
        dest.writeValue(percentageRequired);
        dest.writeString(selectionProcess);
        dest.writeString(role);
        dest.writeString(websiteForApplication);
        dest.writeString(furtherpromotions);
        dest.writeString(examsToBeWritten);
        dest.writeString(id);
    }

    public static final Creator<NavyDSItem> CREATOR = new Creator<NavyDSItem>() {
        @Override
        public NavyDSItem createFromParcel(Parcel in) {
            NavyDSItem item = new NavyDSItem();

            item.post = in.readString();
            item.qualification = in.readString();
            item.percentageRequired = (Double) in.readValue(null);
            item.selectionProcess = in.readString();
            item.role = in.readString();
            item.websiteForApplication = in.readString();
            item.furtherpromotions = in.readString();
            item.examsToBeWritten = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public NavyDSItem[] newArray(int size) {
            return new NavyDSItem[size];
        }
    };

}


