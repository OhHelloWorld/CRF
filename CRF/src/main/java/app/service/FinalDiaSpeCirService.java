package app.service;

import app.dto.FinalDiagnosisSpecialCircumstancesDTO;

/**
 * Created by 10210 on 2017/7/12.
 */
public interface FinalDiaSpeCirService {

    public void saveFinalDiagnosisSpecialCircumstances(
            FinalDiagnosisSpecialCircumstancesDTO finalDTO);

    public FinalDiagnosisSpecialCircumstancesDTO getInformation(Long id);

    public boolean getCompleteByPatientId(int patientId);
}
