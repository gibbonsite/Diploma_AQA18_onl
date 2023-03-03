package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseAdapter {
    //Class created for next changes
    protected Gson gson;

    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        }
        return gson;
    }
}
