package com.cmu.firstclass.firstclass.ws.remote;

import com.cmu.firstclass.firstclass.entities.IDataChangeListener;
import com.cmu.firstclass.firstclass.entities.NormalUser;
import com.cmu.firstclass.firstclass.entities.University;

import java.util.List;

/**
 * Created by Roy on 4/15/15.
 */
public interface IDatabaseService {

    /**
     * @return partially retrieved university list, only names are included inside university
     */
    List<University> getListOfUniversities();

    /**
     * loads the complete university content from database
     * @param university
     */
    void loadUniversityContent(University university);

    /**
     * loads the complete user content from database
     * @param user
     */
    void loadUserContent(NormalUser user);
}
