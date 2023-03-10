package Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import core.Service.Automat;
import core.Service.FileManager;
import core.Service.IAutomat;
import core.Service.IRequest;
import core.model.HotDrink;
import core.model.RequestByName;
import core.model.RequestByTemp;
import core.model.RequestByVolume;
import core.presenter.Presenter;
import core.view.ConsoleView;
import core.view.IDataProvider;
import core.view.IView;

public class AppHotDrinks {

    private AppHotDrinks() {}

    public static void ButtonClick() {

        System.out.print("\033[H\033[J");
        IView view = new ConsoleView();
        List<IRequest<HotDrink>> req = new ArrayList<>(Arrays.asList(new RequestByName<HotDrink>(), new RequestByVolume<HotDrink>(), new RequestByTemp<HotDrink>()));
        IAutomat<HotDrink> automat = new Automat<>();
        IDataProvider<HotDrink> provider = new FileManager<>("Data.txt");

        Presenter<HotDrink> presenter = new Presenter<>(view, automat, provider, req);
        presenter.loadFeed();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.println(" 1 - Запросы  2 - Вывести все");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.getProduct();
                        break;
                    case "2":
                        presenter.getAllProduct();
                        break;

                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
}
