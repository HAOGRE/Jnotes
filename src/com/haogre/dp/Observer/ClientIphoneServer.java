package com.haogre.dp.Observer;

public class ClientIphoneServer implements Client {
    private static String name = "苹果服务";
    private WeatherInfo info;

    @Override
    public void getWeather(WeatherInfo info) {
        this.info = info;
        dealMsg();
    }

    private void dealMsg() {
        System.out.println(name + "收到最新天气：time=" + info.getTime() + "msg=" + info.getWeather() + "。马上开始推送消息...");
    }
}
