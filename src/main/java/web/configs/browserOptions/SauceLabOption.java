package web.configs.browserOptions;


import java.util.HashMap;
import java.util.Map;

public class SauceLabOption {
    private SauceLabOption() {}
    private static SauceLabOption sauceLabOption;
    public static SauceLabOption getInstance(){
        if (sauceLabOption==null)
            sauceLabOption = new SauceLabOption();
        return sauceLabOption;
    }
    public Map<String, Object> getOptions(String username, String accessKey) {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", username);
        sauceOptions.put("accessKey", accessKey);

        return sauceOptions;
    }


}
