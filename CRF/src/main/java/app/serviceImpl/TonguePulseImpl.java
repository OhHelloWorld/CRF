package app.serviceImpl;

import app.Utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.TonguePulseDTO;
import app.entities.TonguePulseDO;
import app.repo.TonguePulseRepo;
import app.service.TonguePulseService;

@Service
public class TonguePulseImpl implements TonguePulseService {

    @Autowired
    private TonguePulseRepo tonguePulseRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Transactional
    public void saveTonguePulse(TonguePulseDTO tonguePulseDTO) {
        tonguePulseRepo.save(convertUtil.convertToTonguePulseDO(tonguePulseDTO));
    }

    public TonguePulseDTO getTonguePulseByPatientId(int patientId) {
        if (tonguePulseRepo.getTonguePulseByPatientId(patientId) != null) {
            return convertUtil.convertToTonguePulseDTO(tonguePulseRepo.getTonguePulseByPatientId(patientId));
        } else {
            return null;
        }
    }

    public boolean getCompleteByPatientId(int patientId) {
        try {
            return tonguePulseRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }



}
