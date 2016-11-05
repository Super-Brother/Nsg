package top.yokey.nsg.system;

import android.os.CountDownTimer;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：自定义的倒计时类
*
*/

public class MyCountTime extends CountDownTimer {

    public MyCountTime(long millis, long count) {
        super(millis, count);
    }

    @Override
    public void onTick(long millis) {

    }

    @Override
    public void onFinish() {

    }

}
