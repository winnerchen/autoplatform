package yiheng.chen.common.util;

import java.util.ResourceBundle;

/**
 * @Author: Yiheng Chen
 * @Description: utils for loading .properties file
 * @Date: Created in 10:47 2017/12/18
 * @Modified by:
 */
public class PropertiesFileUtil {

    private ResourceBundle resourceBundle = null;

    public PropertiesFileUtil(String bundleFile) {
        resourceBundle = ResourceBundle.getBundle(bundleFile);
    }

    public String getValue(String key) {
        if (null == resourceBundle) {
            return null;
        }
        return resourceBundle.getString(key);
    }

}
