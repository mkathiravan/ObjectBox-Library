package net.kathir.googlearchitecturewithobjectbox;

import android.app.Application;

import net.kathir.googlearchitecturewithobjectbox.model.Animal;
import net.kathir.googlearchitecturewithobjectbox.model.MyObjectBox;
import net.kathir.googlearchitecturewithobjectbox.model.Zoo;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {

    private static App sApp;
    private static BoxStore sBoxStore;


    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        sBoxStore = MyObjectBox.builder().androidContext(App.getApp()).build();
        initDatabase();
    }

    public static App getApp()
    {
        return sApp;
    }

    public static BoxStore getsBoxStore()
    {
        return sBoxStore;
    }

    private void initDatabase() {
        Box<Zoo> zooBox = App.getsBoxStore().boxFor(Zoo.class);

        // add some hard-coded default data if there is none
        if (zooBox.count() == 0) {
            List<Animal> canadaAnimals = new ArrayList<>();
            canadaAnimals.add(new Animal("Beven", "https://c7.alamy.com/comp/HXE2MP/michael-bevan-lifts-world-cup-pakistan-v-australia-20-june-1999-HXE2MP.jpg", "Middle"));
            canadaAnimals.add(new Animal("Gilchrist", "https://loveforthegame.files.wordpress.com/2008/03/r140377_482710.jpg", "keeper"));
            canadaAnimals.add(new Animal("Pointing", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Ricky_Ponting.jpg/479px-Ricky_Ponting.jpg", "Captain"));
            Zoo canadaZoo = new Zoo("Australia");
            canadaZoo.animals.addAll(canadaAnimals);


            List<Animal> australiaAnimals = new ArrayList<>();
            australiaAnimals.add(new Animal("Sachin", "https://www.naukrinama.com/stressbuster/wp-content/uploads/2017/12/gq-sachin-tendulkar.jpg", "Opener"));
            australiaAnimals.add(new Animal("Dhoni", "https://cdn-30-skcir4i63ajp.netdna-ssl.com/wp-content/uploads/2019/05/MS-Dhoni.jpg", "Keeper"));
            australiaAnimals.add(new Animal("Virat", "https://akm-img-a-in.tosshub.com/indiatoday/images/story/201701/kohlifb-story_647_012717125956.jpg", "Middle"));
            Zoo australiaZoo = new Zoo("India");
            australiaZoo.animals.addAll(australiaAnimals);


            List<Animal> brazilAnimals = new ArrayList<>();
            brazilAnimals.add(new Animal("Gibbs", "https://cdn.dnaindia.com/sites/default/files/styles/full/public/2017/03/14/556453-gibbs-getty.jpg", "Opener"));
            brazilAnimals.add(new Animal("Klusener", "https://statics.sportskeeda.com/editor/2018/08/1bf1b-1535623559-800.jpg", "All Rounder"));
            brazilAnimals.add(new Animal("Pollack", "https://media.gettyimages.com/photos/-picture-id87262358?s=612x612", "Bowler"));
            Zoo brazilZoo = new Zoo("South Africa");
            brazilZoo.animals.addAll(brazilAnimals);

            zooBox.put(canadaZoo, australiaZoo, brazilZoo);
        }
    }
}
