package xyz.aungpyaephyo.padc.myanmarattractions.data.responses;

import android.icu.text.UnicodeSet;

import com.google.gson.annotations.SerializedName;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by IN-3442 on 17-Jul-16.
 */
public class RegisterResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private UserVO loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UserVO getLoginUser() {
        return loginUser;
    }
}
