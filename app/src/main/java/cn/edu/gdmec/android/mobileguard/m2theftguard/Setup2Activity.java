package cn.edu.gdmec.android.mobileguard.m2theftguard;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;


public class Setup2Activity extends BaseSetUpActivity implements View.OnClickListener{
    private TelephonyManager mTelephoneyManager;
    private Button mBindSIMBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_2);
        //设置第2个小圆点的颜色
        ((RadioButton) findViewById(R.id.rb_seconnd)).setChecked(true);
        //获取电话管理器这个系统服务
        mTelephoneyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        //找到布局中的  sim卡绑定  按钮
        mBindSIMBtn = (Button) findViewById(R.id.btn_bind_sim);
        mBindSIMBtn.setOnClickListener(this);
        if(isBind()){
            mBindSIMBtn.setEnabled(false);
        }else{
            mBindSIMBtn.setEnabled(true);
        }
    }

    private boolean isBind(){
        //sp是父类BaseSetupActivity的属性，是SharePreference，按ctrl+鼠标左键就能跳转到声明的位置
        String simString = sp.getString("sim",null);
        if(TextUtils.isEmpty(simString)){
            return false;
        }
        return true;
    }
    @Override
    public void showNext() {
        if (!isBind()){
            Toast.makeText(this,"您还没有绑定SIM卡！",Toast.LENGTH_LONG).show();
            return;
        }
        startActivityAndFinishSelf(Setup3Activity.class);
    }

    @Override
    public void showPre() {
        startActivityAndFinishSelf(Setup1Activity.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bind_sim:
                //绑定SIM卡
                bindSIM();
                break;
        }
    }
    //绑定SIM卡
    private void bindSIM(){
        if(!isBind()){
            //使用电话管理器服务来获取sim卡号
            String simSerialNumber = mTelephoneyManager.getSimSerialNumber();
            //存储sim卡号
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("sim",simSerialNumber);
            edit.commit();
            Toast.makeText(this,"SIM卡绑定成功！",Toast.LENGTH_LONG).show();
            mBindSIMBtn.setEnabled(false);
        }else {
            //已经绑定，提醒用户
            Toast.makeText(this,"SIM卡已经绑定！",Toast.LENGTH_LONG).show();
            mBindSIMBtn.setEnabled(false);
        }
    }

}
