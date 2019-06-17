package net.kathir.googlearchitecturewithobjectbox.repository.api.parser;

import com.google.gson.Gson;

import net.kathir.googlearchitecturewithobjectbox.model.Animal;
import net.kathir.googlearchitecturewithobjectbox.model.Zoo;

import java.util.Arrays;
import java.util.List;

public class ZooParser {

    private String mResponse;
    private Zoo mZoo;
    private List<Zoo> mZooList;
    private List<Animal> mAnimalList;
    private Gson mGson;

    public ZooParser(String response)
    {
        mResponse = response;
        mGson = new Gson();
    }

    public void parseZooList()
    {
        if(mResponse != null)
        {
            Zoo[] zoos = mGson.fromJson(mResponse,Zoo[].class);
            mZooList = Arrays.asList(zoos);
        }
    }

    public void parseZoo()
    {
        if(mResponse != null)
        {
            mZoo = mGson.fromJson(mResponse,Zoo.class);
        }
    }

    public Zoo getZoo()
    {
        return mZoo;
    }

    public List<Zoo> getZooList()
    {
        return mZooList;
    }

    public List<Animal> getAnimalList()
    {
        return mAnimalList;
    }

}
