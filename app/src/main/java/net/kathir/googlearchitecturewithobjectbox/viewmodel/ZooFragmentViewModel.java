package net.kathir.googlearchitecturewithobjectbox.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import net.kathir.googlearchitecturewithobjectbox.model.Zoo;
import net.kathir.googlearchitecturewithobjectbox.repository.ZooRepository;

public class ZooFragmentViewModel extends BaseViewModel {

    private MutableLiveData<Zoo> mZooLiveData;
    private MutableLiveData<net.kathir.googlearchitecturewithobjectbox.repository.api.response.ZooUpdateResponse> mZooResponseLiveData;

    public ZooFragmentViewModel()
    {
        mZooLiveData = new MutableLiveData<>();
        mZooResponseLiveData = new MutableLiveData<>();
    }

    public void loadZoo(long id)
    {
        ZooRepository.subscribeToZoo(this:: refreshZoo,id,true);
    }

    private void refreshZoo(Zoo zoo)
    {
        mZooLiveData.postValue(zoo);
    }

    public LiveData<Zoo> getZoo()
    {
        return mZooLiveData;
    }

    public LiveData<net.kathir.googlearchitecturewithobjectbox.repository.api.response.ZooUpdateResponse> getZooUpdateResponse()
    {
       return mZooResponseLiveData;
    }

    public void updateZoo(Zoo zoo)
    {
        ZooRepository.updateZoo(zoo,mZooResponseLiveData);
    }

    public void addZoo(String name)
    {
        ZooRepository.addZoo(new Zoo(name),mZooResponseLiveData);
    }
}
