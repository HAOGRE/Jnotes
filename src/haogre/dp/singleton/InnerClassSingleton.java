package haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description:
 * @Author : zhanghao@nash.work
 * @Date : 2019-02-20 17:16
 **/

public class InnerClassSingleton {

  public static Singleton getInstance(){
    return Singleton.singleton;
  }

  private static class Singleton{

    protected static Singleton singleton = new Singleton();

  }
}
