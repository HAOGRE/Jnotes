package haogre.dp.singleton;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : leetcode
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 2019-02-20 17:14
 **/
public class BadSynchronizedSingleton {

  //一个静态的实例
  private static BadSynchronizedSingleton synchronizedSingleton;
  //私有化构造函数
  private BadSynchronizedSingleton(){}
  //给出一个公共的静态方法返回一个单一实例
  public synchronized static BadSynchronizedSingleton getInstance(){
    if (synchronizedSingleton == null) {
      synchronizedSingleton = new BadSynchronizedSingleton();
    }
    return synchronizedSingleton;
  }

}
