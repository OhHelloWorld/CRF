package app.serviceImpl;

import app.Utils.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.PhysicalChemicalInspectionDTO;
import app.entities.PhysicalChemicalInspectionDO;
import app.repo.PhysicalChemicalInspectionRepo;
import app.service.PhysicalChemicalInspectionService;

@Service
public class PhysicalChemicalInspectionServiceImpl implements PhysicalChemicalInspectionService {

    @Autowired
    private PhysicalChemicalInspectionRepo pRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Transactional
    public void savePhysicalChemicalInspection(PhysicalChemicalInspectionDTO pDto) {
        pRepo.save( convertUtil.convertToPhysicalChemicalInspectionDO(pDto));
    }

    public PhysicalChemicalInspectionDTO getPhysicalByPatientId(int patientId) {
        if (pRepo.getPhysicalByPatientId(patientId) != null) {
            return convertUtil.convertToPhysicalDTO(pRepo.getPhysicalByPatientId(patientId));
        } else {
            return null;
        }
    }

    public boolean getCompleteByPatientId(int patientId) {
        try {
            return pRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }


}
