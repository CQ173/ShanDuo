package com.yapin.shanduo.ui.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yapin.shanduo.R;
import com.yapin.shanduo.app.ShanDuoPartyApplication;
import com.yapin.shanduo.im.model.UserInfo;
import com.yapin.shanduo.presenter.UserDetailPresenter;
import com.yapin.shanduo.ui.activity.CustomerServiceActivity;
import com.yapin.shanduo.ui.activity.EditingformationAcivity;
import com.yapin.shanduo.ui.activity.LoginActivity;
import com.yapin.shanduo.ui.activity.MembercenterActivity;
import com.yapin.shanduo.ui.activity.MyDynamicsActivity;
import com.yapin.shanduo.ui.activity.MyWalletActivity;
import com.yapin.shanduo.ui.activity.MyactivitiesActivity;
import com.yapin.shanduo.ui.activity.ScrollingActivity;
import com.yapin.shanduo.ui.contract.UserDetailContract;
import com.yapin.shanduo.utils.ApiUtil;
import com.yapin.shanduo.utils.GlideUtil;
import com.yapin.shanduo.utils.PrefJsonUtil;
import com.yapin.shanduo.ui.activity.SetupActivity;
import com.yapin.shanduo.utils.PrefUtil;
import com.yapin.shanduo.utils.StartActivityUtil;
import com.yapin.shanduo.utils.ToastUtil;
import com.yapin.shanduo.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * implements  UserDetailContract.View
 */
public class PersonFragment extends Fragment implements UserDetailContract.View{

    private Activity activity;
    private Context context;
    UserDetailPresenter presenter;

    private final int PUBLISH_ACT_OPEN_LOGIN = 1;
    private final int PUBLISH_MYDYNAMICS_LOGIN = 2;
    private final int MYACTIVITIES =3;
    private final int MYACTIVITIESACTIVITY =4;
    private final int EDITING=5;
    private final int MYWALLET=6;
    private final int SETUP=7;
    private final int MEMBER_CENTER = 8;
    private final int SCROLLING = 9;
    private final int CUSTOMER_SERVICE = 10;

      private TextView tv_nickname;
      private ImageView ib_Headportrait;
      private TextView tv_sex;
      private LinearLayout ll_person_a;
      private LinearLayout ll_person_aa;
      private TextView tv_login_reg;
      private TextView tv_id;
      private TextView tv_svip;
      private TextView tv_level;
      private TextView tv_friend_count;
      private TextView tv_act_count;
      private TextView tv_trend_count;
      private LinearLayout ll_zhangs;

    public static PersonFragment newInstance() {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        presenter = new UserDetailPresenter();
        presenter.init(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_layout,container,false);
        ButterKnife.bind(this,view);

        tv_nickname = view.findViewById(R.id.tv_nickname);
        ib_Headportrait = view.findViewById(R.id.ib_Headportrait);
        tv_sex = view.findViewById(R.id.tv_sex);
        ll_person_a = view.findViewById(R.id.ll_person_a);
        ll_person_aa = view.findViewById(R.id.ll_person_aa);
        tv_login_reg = view.findViewById(R.id.tv_login_reg);
        tv_id = view.findViewById(R.id.tv_id);
        tv_svip = view.findViewById(R.id.tv_svip);
        tv_level = view.findViewById(R.id.tv_level);
        tv_friend_count = view.findViewById(R.id.tv_friend_count);
        tv_act_count = view.findViewById(R.id.tv_act_count);
        tv_trend_count = view.findViewById(R.id.tv_trend_count);
        ll_zhangs = view.findViewById(R.id.ll_zhangs);
        initViewinfo();
        return view;
    }




    private void initViewinfo() {
        context = ShanDuoPartyApplication.getContext();
        activity = getActivity();

    }
    @OnClick({R.id.tv_MyDynamics,R.id.tv_Myactivities ,R.id.ll_person_a , R.id.text_setup , R.id.text_mywallet ,R.id.tv_login_reg , R.id.tv_member_center ,R.id.tv_Creditcenter , R.id.text_customer_service})
    public void onClick(View view){
        switch (view.getId()){

            case R.id.tv_member_center:     //会员中心
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity , this , LoginActivity.class , MEMBER_CENTER);
                }else {
                    StartActivityUtil.start(activity  , this, MembercenterActivity.class , PUBLISH_MYDYNAMICS_LOGIN);
                }
                break;

            case R.id.tv_MyDynamics:    //我的动态
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity  , this, LoginActivity.class , PUBLISH_ACT_OPEN_LOGIN);
                }else {
                    StartActivityUtil.start(activity  ,  MyDynamicsActivity.class);
                }
                break;

            case R.id.tv_Myactivities:      //我的活动
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity  , this, LoginActivity.class , MYACTIVITIESACTIVITY);
                }else {
                    StartActivityUtil.start(activity  , MyactivitiesActivity.class );
                }
                break;
            case R.id.ll_person_a:      //个人信息
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity  , this, LoginActivity.class , EDITING);
                }else {
                    StartActivityUtil.start(activity  , this, EditingformationAcivity.class , PUBLISH_MYDYNAMICS_LOGIN);
                }
                break;
            case R.id.text_setup:       //设置
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity  , this, LoginActivity.class , SETUP);
                }else {
                    StartActivityUtil.start(activity , SetupActivity.class);
                }
                break;

            case R.id.text_mywallet:        //我的钱包
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity  , this, LoginActivity.class , MYWALLET);
                }else {
                    StartActivityUtil.start(activity  , MyWalletActivity.class);
                }
                break;
            case R.id.tv_login_reg:
                StartActivityUtil.start(activity , LoginActivity.class);
                break;
            case R.id.tv_Creditcenter:    //信用中心
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity , this , LoginActivity.class , SCROLLING);
                }else {
                    StartActivityUtil.start(activity , ScrollingActivity.class );
                }
                break;
            case R.id.text_customer_service:
                if(TextUtils.isEmpty(PrefUtil.getToken(context))){
                    StartActivityUtil.start(activity , this , LoginActivity.class , CUSTOMER_SERVICE);
                }else {
                    StartActivityUtil.start(activity , CustomerServiceActivity.class );
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( resultCode != Activity.RESULT_OK) return;
        switch (requestCode){
            case PUBLISH_ACT_OPEN_LOGIN:
                StartActivityUtil.start(activity  ,  MyDynamicsActivity.class);
                break;
            case MYACTIVITIESACTIVITY:
                StartActivityUtil.start(activity  , MyactivitiesActivity.class );
                break;
            case EDITING:

                break;
            case MYWALLET:
                StartActivityUtil.start(activity  , MyWalletActivity.class);
                break;
            case MEMBER_CENTER:

                break;
            case SCROLLING:
                StartActivityUtil.start(activity , ScrollingActivity.class );
                break;
            case SETUP:
                StartActivityUtil.start(activity , SetupActivity.class);
                break;
            case CUSTOMER_SERVICE:
                StartActivityUtil.start(activity , CustomerServiceActivity.class );
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(TextUtils.isEmpty(PrefUtil.getToken(context))){
            ll_person_a.setVisibility(View.GONE);
            ll_person_aa.setVisibility(View.VISIBLE);
            ll_zhangs.setVisibility(View.GONE);
        }else {
            presenter.start();
            ll_person_aa.setVisibility(View.GONE);
            ll_person_a.setVisibility(View.VISIBLE);
            ll_zhangs.setVisibility(View.VISIBLE);
            tv_friend_count.setText(PrefJsonUtil.getProfile(context).getAttention()+"");
            tv_act_count.setText(PrefJsonUtil.getProfile(context).getActivity()+"");
            tv_trend_count.setText(PrefJsonUtil.getProfile(context).getDynamic()+"");

            tv_nickname.setText(Utils.unicodeToString(PrefJsonUtil.getProfile(context).getName()));
            tv_id.setText(PrefJsonUtil.getProfile(context).getUserId());
            tv_level.setText("LV"+PrefJsonUtil.getProfile(context).getLevel()+"");
            GlideUtil.load(context ,activity , ApiUtil.IMG_URL + PrefJsonUtil.getProfile(context).getPicture() , ib_Headportrait);

            Drawable drawable = null;
            if ("0".equals(PrefJsonUtil.getProfile(context).getGender())) {
                drawable = activity.getResources().getDrawable(R.drawable.icon_women);
                tv_sex.setBackgroundResource(R.drawable.rounded_tv_sex_women);
//                ll_person_a.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_women_bg));
            } else {
//                ll_person_a.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_man_bg));
                drawable = activity.getResources().getDrawable(R.drawable.icon_men);
                tv_sex.setBackgroundResource(R.drawable.rounded_tv_sex_men);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tv_sex.setCompoundDrawables(drawable, null, null, null);
            tv_sex.setCompoundDrawablePadding(2);
            tv_sex.setText(PrefJsonUtil.getProfile(context).getAge()+"");

            int level = PrefJsonUtil.getProfile(context).getVip();
            if(level == 0){
                tv_svip.setVisibility(View.GONE);
            }else if(level < 9){
                tv_svip.setVisibility(View.VISIBLE);
                tv_svip.setText("VIP"+level);
                tv_svip.setBackgroundResource(R.drawable.rounded_tv_vip);
            }else {
                tv_svip.setVisibility(View.VISIBLE);
                tv_svip.setText("SVIP"+(level-10));
                tv_svip.setBackgroundResource(R.drawable.rounded_tv_svip);
            }
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void dataSuccess(String data) {
        UserInfo.getInstance().setUserSig(PrefJsonUtil.getProfile(context).getUserSig());
        UserInfo.getInstance().setId(PrefJsonUtil.getProfile(context).getUserId());
    }

    @Override
    public void loading() {

    }

    @Override
    public void networkError() {
        ToastUtil.showShortToast(context,"网络连接异常");
    }

    @Override
    public void error(String msg) {
        ToastUtil.showShortToast(context ,msg);
    }

    @Override
    public void showFailed(String msg) {
        ToastUtil.showShortToast(context ,msg);
    }
}
