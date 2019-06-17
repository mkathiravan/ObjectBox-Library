package net.kathir.googlearchitecturewithobjectbox.repository.api;

import android.arch.lifecycle.Observer;
import android.os.AsyncTask;

import com.squareup.picasso.Downloader;

import net.kathir.googlearchitecturewithobjectbox.model.Zoo;
import net.kathir.googlearchitecturewithobjectbox.repository.api.response.Response;


public class ZooAPI {

    public static void addZoo(Zoo newZoo, Observer<Response> responseObserver)
    {

        AsyncTask.execute(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored)
            {

            }

            String fakeResponse = "{\"name\":"+newZoo.getName() + "\"}";
            Response response = new Response(Response.STATUS_SUCCESS,fakeResponse);
            responseObserver.onChanged(response);

        });
    }

    public static void updateZoo(Zoo zoo, Observer<Response> responseObserver)
    {
        AsyncTask.execute(() -> {

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored)
            {

            }

            String fakeRepsone = "{\"name\": \""+ zoo.getName() + "\", \"id\" : \"" +zoo.getId() + "\"}";
            Response response = new Response(Response.STATUS_SUCCESS,fakeRepsone);
            responseObserver.onChanged(response);
        });
    }

    public static void loadZoos(Observer<Response> responseObserver)
    {
        AsyncTask.execute(() -> {

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored)
            {

            }

            Response response = new Response(Response.STATUS_FAIL,"Error occurred! ");
            responseObserver.onChanged(response);
        });
    }

    public static void loadZoo(long id, Observer<Response> responseObserver)
    {
        AsyncTask.execute(()-> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored)
            {

            }

            Response response = new Response(Response.STATUS_FAIL,"Error occurred!");
            responseObserver.onChanged(response);
        });
    }
}
