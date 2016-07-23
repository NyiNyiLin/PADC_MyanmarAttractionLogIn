package xyz.aungpyaephyo.padc.myanmarattractions.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaBrowserCompat;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import xyz.aungpyaephyo.padc.myanmarattractions.R;
import xyz.aungpyaephyo.padc.myanmarattractions.controllers.ControllerAccountControl;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;
import xyz.aungpyaephyo.padc.myanmarattractions.views.PasswordVisibilityListener;

/**
 * Created by aung on 7/15/16.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.et_login_email)
    EditText etLogInEmial;

    @BindView(R.id.et_login_password)
    EditText etLoginPassword;

    @BindView(R.id.tv_login_register)
            TextView tvLoginRegister;

    @BindView(R.id.tv_forget_password)
            TextView tvForgetPassword;

    ControllerAccountControl mControllerAccountControl;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mControllerAccountControl = (ControllerAccountControl) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, rootView);
        tvLoginRegister.setText(Html.fromHtml(getString(R.string.msg_register)));
        tvForgetPassword.setText(Html.fromHtml(getString(R.string.msg_forget_pasword)));

        etLoginPassword.setOnTouchListener(new PasswordVisibilityListener());

        return rootView;
    }

    @OnClick(R.id.btn_login_login)
    public void onTapLogin(View view){
        String email = etLogInEmial.getText().toString();
        String password = etLoginPassword.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            if(TextUtils.isEmpty(email)){
                etLogInEmial.setError(getString(R.string.error_missing_email));
            }
            if(TextUtils.isEmpty(password)){
                etLoginPassword.setError(getString(R.string.error_missing_password));
            }
        }else if (!isEmailValid(email)) {
            //Email address is not in the right format.
            etLogInEmial.setError(getString(R.string.error_email_is_not_valid));
        } else {
            //Checking on client side is done here.
            mControllerAccountControl.onLogin(email, password);
        }
    }

    @OnClick(R.id.tv_login_register)
    public void onTapLogIn(View view){
        mControllerAccountControl.onNoAccount();
    }

    public boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(MyanmarAttractionsConstants.EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}