package net.kathir.googlearchitecturewithobjectbox.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.provider.ContactsContract;

import net.kathir.googlearchitecturewithobjectbox.model.Zoo;
import net.kathir.googlearchitecturewithobjectbox.repository.ZooRepository;

import java.util.List;

import io.objectbox.reactive.DataSubscription;

public class ZooListViewModel extends BaseViewModel {

    private MutableLiveData<List<Zoo>> mZoosLiveData;

    public ZooListViewModel()
    {
        mZoosLiveData = new MutableLiveData<>();
        DataSubscription subscription = ZooRepository.subscribeToZooList(this::refreshZoos);
        addSubscription(subscription);
    }

    private void refreshZoos(List<Zoo> zoos)
    {
        mZoosLiveData.postValue(zoos);
    }

    public LiveData<List<Zoo>> getZoos()
    {
        return mZoosLiveData;
    }

    public void refreshZoos()
    {
        ZooRepository.refreshZoos();
    }
}
