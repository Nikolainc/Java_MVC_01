package core.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import core.model.HotDrink;
import core.view.IDataProvider;

public class FileManager<T extends HotDrink> implements IDataProvider<T> {

    private String fileName;

    public FileManager(String fileName) {

        this.fileName = fileName;

    }

    @Override
    public List<T> loadFeed() {

        List<HotDrink> drinkList = new ArrayList<>();

        try {

            File file = new File(this.fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String[] data = reader.readLine().split("#");

            while (data != null) {

                drinkList.add((T) new HotDrink(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                
                data = reader.readLine().split("#");

            }

            reader.close();
            fr.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return (List<T>) drinkList;

    }

    @Override
    public boolean saveFeed(List<T> data) {
        
        try (FileWriter writer = new FileWriter(this.fileName, false)) {

            for (T drink : data) {

                writer.append(drink.gName() + "#" + drink.gVolume() + "#" + drink.gTemp() + "\n");
                
            }

            writer.flush();
            return true;

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        return false;

    }
    
}
