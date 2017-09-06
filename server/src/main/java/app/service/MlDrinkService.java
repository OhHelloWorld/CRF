package app.service;

import app.dto.MedicineLiverDrinkDTO;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public interface MlDrinkService {

    MedicineLiverDrinkDTO getMlDrink(int mlPatientId);

    void saveMlDrink(MedicineLiverDrinkDTO mlDrink);
}
