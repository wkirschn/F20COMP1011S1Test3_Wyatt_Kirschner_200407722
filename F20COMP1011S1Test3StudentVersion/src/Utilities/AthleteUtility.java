package Utilities;


import Models.Athlete;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

public class AthleteUtility {



// Will use this to return the information of the Athlete when requested

    public static Athlete[] getAthleteFromJSON(File jsonFile)
    {
        Gson gson = new Gson();
        Athlete[] athleteQuery2 = null;

        try(
                FileReader filereader = new FileReader(jsonFile);
                JsonReader jsonReader = new JsonReader(filereader);
                )

        {
          athleteQuery2 = gson.fromJson(jsonReader, Athlete[].class);
           System.out.println(athleteQuery2);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return athleteQuery2;
    }


}
