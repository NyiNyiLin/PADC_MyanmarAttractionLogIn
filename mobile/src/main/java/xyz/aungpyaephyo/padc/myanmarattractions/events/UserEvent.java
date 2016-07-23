package xyz.aungpyaephyo.padc.myanmarattractions.events;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by aung on 7/15/16.
 */
public class UserEvent {
    public static class SuccessRegistrationEvent {
        private UserVO loginUser;

        public SuccessRegistrationEvent(UserVO loginUser) {
            this.loginUser = loginUser;
        }

        public UserVO getLoginUser() {
            return loginUser;
        }
    }

    public static class FailedRegistrationEvent {
        private String message;

        public FailedRegistrationEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class SuccessLogInEvent {
        private UserVO loginUser;

        public SuccessLogInEvent(UserVO loginUser) {
            this.loginUser = loginUser;
        }

        public UserVO getLoginUser() {
            return loginUser;
        }
    }

    public static class FailedLogInEvent {
        private String message;

        public FailedLogInEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class RegisterEvent{

    }


}