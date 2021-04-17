
package com.example.canacomercio.retrofit.response.employee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("admins_count")
    @Expose
    private Integer adminsCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param adminsCount
     */
    public Meta(Integer adminsCount) {
        super();
        this.adminsCount = adminsCount;
    }

    public Integer getAdminsCount() {
        return adminsCount;
    }

    public void setAdminsCount(Integer adminsCount) {
        this.adminsCount = adminsCount;
    }

}
