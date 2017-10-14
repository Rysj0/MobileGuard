package cn.edu.gdmec.android.mobileguard.m2theftguard.utils;
import android.os.Bundle;
import android.widget.RadioButton;

import cn.edu.gdmec.android.mobileguard.R;


public class Setup3Activity extends BaseSetUpActivity {
    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_setup_3);
        //设置第3个小圆点的颜色
        ((RadioButton) findViewById(R.id.rb_third)).setChecked(true);
    }
    @Override
    public void showNext(){
        startActivityAndFinishSelf(Setup4Activity.class);
    }

    @Override
    public void showPre(){
        startActivityAndFinishSelf(Setup2Activity.class);
    }
}
