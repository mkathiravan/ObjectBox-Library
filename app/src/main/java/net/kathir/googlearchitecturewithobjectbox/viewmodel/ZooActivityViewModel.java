package net.kathir.googlearchitecturewithobjectbox.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import net.kathir.googlearchitecturewithobjectbox.model.Zoo;
import net.kathir.googlearchitecturewithobjectbox.repository.ZooRepository;

import io.objectbox.reactive.DataSubscription;

public class ZooActivityViewModel extends BaseViewModel {

    private MutableLiveData<Zoo> mZooLiveData;

    public ZooActivityViewModel()
    {
        mZooLiveData = new MutableLiveData<>();
    }

    public void loadZoo(long id)
    {
        DataSubscription sub = ZooRepository.subscribeToZoo(this::refreshZoo,id,false);
        addSubscription(sub);
        ZooRepository.refreshZoo(id);
    }

    private void refreshZoo(Zoo zoo)
    {
        mZooLiveData.postValue(zoo);
    }

    public LiveData<Zoo> getZoo()
    {
        return mZooLiveData;
    }
}
