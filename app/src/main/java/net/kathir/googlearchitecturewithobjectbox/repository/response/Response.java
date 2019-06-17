package net.kathir.googlearchitecturewithobjectbox.repository.api.response;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Response {

    public static final int STATUS_LOADING = 0, STATUS_SUCCESS = 1, STATUS_FAIL = 2;

    @Retention(SOURCE)
    @IntDef({STATUS_LOADING,STATUS_SUCCESS,STATUS_FAIL})
    @interface Status
    {

    }

    private final int mStatus;

    @Status
    public int getmStatus() {
        return mStatus;
    }

    public String getmPayload() {
        return mPayload;
    }

    private String mPayload;

    public Response(@Status int status, String payload)
    {
        mStatus = status;
        mPayload = payload;
    }


}
