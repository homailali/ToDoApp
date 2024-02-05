package life.homail.todoapp.ClassesInstances;

import life.homail.todoapp.HomePage.HomePageMain;

public class HomePageMainInstance {
    public static HomePageMain homePageMain;




    public static void initializeHomePageMain(HomePageMain homePageMain){
        HomePageMainInstance.homePageMain=homePageMain;
    }
}
