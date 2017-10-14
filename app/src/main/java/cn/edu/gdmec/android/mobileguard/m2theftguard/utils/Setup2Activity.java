package cn.edu.gdmec.android.mobileguard.m2theftguard.utils;
import android.os.Bundle;
import android.widget.RadioButton;

import cn.edu.gdmec.android.mobileguard.R;


public class Setup2Activity extends BaseSetUpActivity {
    @Override
    protected void  onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_setup_2);
        //设置第2个小圆点的颜色
        ((RadioButton) findViewById(R.id.rb_second)).setChecked(true);
    }
    @Override
    public void showNext(){
        startActivityAndFinishSelf(Setup3Activity.class);
    }

    @Override
    public void showPre(){
        startActivityAndFinishSelf(Setup1Activity.class);
    }
}
