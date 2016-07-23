package xyz.aungpyaephyo.padc.myanmarattractions.data.agents;

/**
 * Created by IN-3442 on 09-Jul-16.
 */
public interface AttractionDataAgent {
    void loadAttractions();
    void register(String name, String email, String password, String dateOfBirth, String countryOfOrigin);
    void login(String email, String password);
}
