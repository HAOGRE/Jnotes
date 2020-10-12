#!/bin/bash


# input text <string>
# input keyevent <key code number or name>
# input tap <x> <y>
# input swipe <x1> <y1> <x2> <y2>


# 进攻
adb shell input tap 290 1290
sleep 1s
echo '点击进攻'
# 搜索
adb shell input tap 2000 620 
echo '点击搜索'
sleep 5s

# 选兵1
adb shell input tap 650 1250
echo '选兵'
# 边上下兵1
adb shell input swipe 200 750 200 750 500
sleep 1s

adb shell input swipe 200 750 200 750 800
sleep 2s

adb shell input swipe 200 750 200 750 600
sleep 1s

adb shell input swipe 200 750 200 750 900
sleep 2s

adb shell input swipe 200 750 200 750 3000

echo '下兵1结束'

# 选兵2
sleep 1s
adb shell input tap 820 1250

echo '选兵2'
# 边上下兵2
adb shell input swipe 200 750 200 750 800
sleep 2s

adb shell input swipe 200 750 200 750 500
sleep 2s

adb shell input swipe 200 750 200 750 600
sleep 1s

adb shell input swipe 200 750 200 750 800
sleep 1s

adb shell input swipe 200 750 200 750 4000

echo '下兵2结束'
#长按120s 保持屏幕不灭
adb shell input swipe 200 750 1500 1230 120000

echo '结束'
# 结束
adb shell input tap 1500 1230
sleep 2s

echo '回营地'
# 回营地
adb shell input tap 290 1290

sleep 2s


