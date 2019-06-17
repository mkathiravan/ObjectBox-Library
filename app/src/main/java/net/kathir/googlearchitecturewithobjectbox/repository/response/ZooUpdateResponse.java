package net.kathir.googlearchitecturewithobjectbox.repository.api.response;

public class ZooUpdateResponse {

    private int mStatus;
    private String mErrorMessage;

    public ZooUpdateResponse(@net.kathir.googlearchitecturewithobjectbox.repository.api.response.Response.Status int status)
    {
        mStatus = status;
    }

    public void setErrorMessage(String message)
    {
        mErrorMessage = message;
    }

    public String getErrorMessage()
    {
        return mErrorMessage;
    }

    @net.kathir.googlearchitecturewithobjectbox.repository.api.response.Response.Status
    public int getStatus()
    {
        return mStatus;
    }
}
