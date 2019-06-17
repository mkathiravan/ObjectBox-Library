package net.kathir.googlearchitecturewithobjectbox.repository;

import android.arch.lifecycle.MutableLiveData;

import net.kathir.googlearchitecturewithobjectbox.model.Zoo;
import net.kathir.googlearchitecturewithobjectbox.repository.api.ZooAPI;
import net.kathir.googlearchitecturewithobjectbox.repository.api.parser.ZooParser;
import net.kathir.googlearchitecturewithobjectbox.repository.api.response.Response;
import net.kathir.googlearchitecturewithobjectbox.repository.api.response.ZooUpdateResponse;

import java.util.List;

import io.objectbox.reactive.DataObserver;
import io.objectbox.reactive.DataSubscription;

public class ZooRepository {

    public static DataSubscription subscribeToZooList(DataObserver<List<Zoo>> observer)
    {
        return net.kathir.googlearchitecturewithobjectbox.repository.database.ZooDAO.subscribeToZooList(observer);
    }

    public static DataSubscription subscribeToZoo(DataObserver<Zoo> observer, long id, boolean singleUpdate)
    {
        return net.kathir.googlearchitecturewithobjectbox.repository.database.ZooDAO.subscibeToZoo(observer,id,singleUpdate);
    }

    public static void refreshZoo(long id)
    {
        ZooAPI.loadZoo(id,zooResponse -> {
            if(zooResponse !=null && zooResponse.getmStatus() == Response.STATUS_SUCCESS)
            {
                net.kathir.googlearchitecturewithobjectbox.repository.api.parser.ZooParser parser = new ZooParser(zooResponse.getmPayload());
                parser.parseZoo();
                Zoo zoo = parser.getZoo();
                if(zoo != null)
                {
                    net.kathir.googlearchitecturewithobjectbox.repository.database.ZooDAO.insertZoo(zoo);
                }
            }
        });
    }

    public static void refreshZoos()
    {
        ZooAPI.loadZoos(zoosResponse -> {
            if(zoosResponse != null && zoosResponse.getmStatus() == Response.STATUS_SUCCESS)
            {
                ZooParser parser = new ZooParser(zoosResponse.getmPayload());
                parser.parseZooList();
                List<Zoo> zoos = parser.getZooList();
                if(zoos != null)
                {
                    net.kathir.googlearchitecturewithobjectbox.repository.database.ZooDAO.insertZoos(zoos);
                }
            }
        });
    }

    public static void addZoo(Zoo newZoo, MutableLiveData<net.kathir.googlearchitecturewithobjectbox.repository.api.response.ZooUpdateResponse> liveResponse)
    {
        liveResponse.postValue(new ZooUpdateResponse(Response.STATUS_LOADING));
        ZooAPI.updateZoo(newZoo,zooRespone -> handleZooResponse(zooRespone,liveResponse));
    }

    public static void updateZoo(Zoo zoo,MutableLiveData<ZooUpdateResponse> liveResponse)
    {
        liveResponse.postValue(new ZooUpdateResponse(Response.STATUS_LOADING));
        ZooAPI.updateZoo(zoo,zooResponse -> handleZooResponse(zooResponse,liveResponse));
    }

    private static void handleZooResponse(Response zooResponse, MutableLiveData<ZooUpdateResponse> liveResponse)
    {
        if(zooResponse != null)
        {
            if(zooResponse.getmStatus() == Response.STATUS_SUCCESS)
            {
                ZooParser parser = new ZooParser(zooResponse.getmPayload());
                parser.parseZoo();
                Zoo zoo = parser.getZoo();
                if(zoo != null)
                {
                    net.kathir.googlearchitecturewithobjectbox.repository.database.ZooDAO.insertZoo(zoo);
                }
            }

            liveResponse.postValue(new ZooUpdateResponse(zooResponse.getmStatus()));
        }
    }
}
