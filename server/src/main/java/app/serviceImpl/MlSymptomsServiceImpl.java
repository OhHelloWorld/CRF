package app.serviceImpl;

import app.dto.MedicineLiverSymptomsDTO;
import app.dto.MedicineLiverSymptomsOtherDTO;
import app.entities.MedicineLiverSymptomsDO;
import app.entities.MedicineLiverSymptomsOtherDO;
import app.repo.MlSymptomsRepo;
import app.service.MlSymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@Service
public class MlSymptomsServiceImpl implements MlSymptomsService {

    @Autowired
    private MlSymptomsRepo mlSymptomsRepo;

    private MedicineLiverSymptomsDTO convertToDTO(MedicineLiverSymptomsDO medicineLiverSymptomsDO) {
        MedicineLiverSymptomsDTO medicineLiverSymptomsDTO = new MedicineLiverSymptomsDTO();
        medicineLiverSymptomsDTO.setId(medicineLiverSymptomsDO.getId());
        medicineLiverSymptomsDTO.setAbdominalDistention(medicineLiverSymptomsDO.getAbdominalDistention());
        medicineLiverSymptomsDTO.setAbdominalDistentionBeginDate(medicineLiverSymptomsDO.getAbdominalDistentionBeginDate());
        medicineLiverSymptomsDTO.setAbdominalDistentionDisappearDate(medicineLiverSymptomsDO.getAbdominalDistentionDisappearDate());
        medicineLiverSymptomsDTO.setAbdominalDistentionDischarge(medicineLiverSymptomsDO.getAbdominalDistentionDischarge());
        medicineLiverSymptomsDTO.setAnorexia(medicineLiverSymptomsDO.getAnorexia());
        medicineLiverSymptomsDTO.setAnorexiaBeginDate(medicineLiverSymptomsDO.getAnorexiaBeginDate());
        medicineLiverSymptomsDTO.setAnorexiaDisappearDate(medicineLiverSymptomsDO.getAnorexiaDisappearDate());
        medicineLiverSymptomsDTO.setAnorexiaDischarge(medicineLiverSymptomsDO.getAnorexiaDischarge());
        medicineLiverSymptomsDTO.setArthralgia(medicineLiverSymptomsDO.getArthralgia());
        medicineLiverSymptomsDTO.setArthralgiaBeginDate(medicineLiverSymptomsDO.getArthralgiaBeginDate());
        medicineLiverSymptomsDTO.setArthralgiaDisappearDate(medicineLiverSymptomsDO.getArthralgiaDisappearDate());
        medicineLiverSymptomsDTO.setArthralgiaDischarge(medicineLiverSymptomsDO.getArthralgiaDischarge());
        medicineLiverSymptomsDTO.setComplete(medicineLiverSymptomsDO.isComplete());
        medicineLiverSymptomsDTO.setWeak(medicineLiverSymptomsDO.getWeak());
        medicineLiverSymptomsDTO.setWeakBeginDate(medicineLiverSymptomsDO.getWeakBeginDate());
        medicineLiverSymptomsDTO.setWeakDisappearDate(medicineLiverSymptomsDO.getWeakDisappearDate());
        medicineLiverSymptomsDTO.setWeakDischarge(medicineLiverSymptomsDO.getWeakDischarge());
        medicineLiverSymptomsDTO.setJaundice(medicineLiverSymptomsDO.getJaundice());
        medicineLiverSymptomsDTO.setJaundiceBeginDate(medicineLiverSymptomsDO.getJaundiceBeginDate());
        medicineLiverSymptomsDTO.setJaundiceDisappearDate(medicineLiverSymptomsDO.getJaundiceDisappearDate());
        medicineLiverSymptomsDTO.setJaundiceDischarge(medicineLiverSymptomsDO.getJaundiceDischarge());
        medicineLiverSymptomsDTO.setNausea(medicineLiverSymptomsDO.getNausea());
        medicineLiverSymptomsDTO.setNauseaBeginDate(medicineLiverSymptomsDO.getNauseaBeginDate());
        medicineLiverSymptomsDTO.setNauseaDisappearDate(medicineLiverSymptomsDO.getNauseaDisappearDate());
        medicineLiverSymptomsDTO.setNauseaDischarge(medicineLiverSymptomsDO.getNauseaDischarge());
        medicineLiverSymptomsDTO.setVomit(medicineLiverSymptomsDO.getVomit());
        medicineLiverSymptomsDTO.setVomitBeginDate(medicineLiverSymptomsDO.getVomitBeginDate());
        medicineLiverSymptomsDTO.setVomitDisappearDate(medicineLiverSymptomsDO.getVomitDisappearDate());
        medicineLiverSymptomsDTO.setVomitDischarge(medicineLiverSymptomsDO.getVomitDischarge());
        medicineLiverSymptomsDTO.setGingivalBleeding(medicineLiverSymptomsDO.getGingivalBleeding());
        medicineLiverSymptomsDTO.setGingivalBleedingBeginDate(medicineLiverSymptomsDO.getGingivalBleedingBeginDate());
        medicineLiverSymptomsDTO.setGingivalBleedingDisappearDate(medicineLiverSymptomsDO.getGingivalBleedingDisappearDate());
        medicineLiverSymptomsDTO.setGingivalBleedingDischarge(medicineLiverSymptomsDO.getGingivalBleedingDischarge());
        medicineLiverSymptomsDTO.setEpistaxis(medicineLiverSymptomsDO.getEpistaxis());
        medicineLiverSymptomsDTO.setEpistaxisBeginDate(medicineLiverSymptomsDO.getEpistaxisBeginDate());
        medicineLiverSymptomsDTO.setEpistaxisDisappearDate(medicineLiverSymptomsDO.getEpistaxisDisappearDate());
        medicineLiverSymptomsDTO.setEpistaxisDischarge(medicineLiverSymptomsDO.getEpistaxisDischarge());
        medicineLiverSymptomsDTO.setLiverInjury(medicineLiverSymptomsDO.getLiverInjury());
        medicineLiverSymptomsDTO.setLiverPain(medicineLiverSymptomsDO.getLiverPain());
        medicineLiverSymptomsDTO.setLiverPainBeginDate(medicineLiverSymptomsDO.getAnorexiaBeginDate());
        medicineLiverSymptomsDTO.setLiverPainDisappearDate(medicineLiverSymptomsDO.getLiverPainDisappearDate());
        medicineLiverSymptomsDTO.setLiverPainDischarge(medicineLiverSymptomsDO.getLiverPainDischarge());
        medicineLiverSymptomsDTO.setHepatomegaly(medicineLiverSymptomsDO.getHepatomegaly());
        medicineLiverSymptomsDTO.setHepatomegalyBeginDate(medicineLiverSymptomsDO.getHepatomegalyBeginDate());
        medicineLiverSymptomsDTO.setHepatomegalyDisappearDate(medicineLiverSymptomsDO.getHepatomegalyDisappearDate());
        medicineLiverSymptomsDTO.setHepatomegalyDischarge(medicineLiverSymptomsDO.getHepatomegalyDischarge());
        medicineLiverSymptomsDTO.setSplenomegaly(medicineLiverSymptomsDO.getSplenomegaly());
        medicineLiverSymptomsDTO.setSplenomegalyBeginDate(medicineLiverSymptomsDO.getSplenomegalyBeginDate());
        medicineLiverSymptomsDTO.setSplenomegalyDisappearDate(medicineLiverSymptomsDO.getSplenomegalyDisappearDate());
        medicineLiverSymptomsDTO.setSplenomegalyDischarge(medicineLiverSymptomsDO.getSplenomegalyDischarge());
        medicineLiverSymptomsDTO.setFever(medicineLiverSymptomsDO.getFever());
        medicineLiverSymptomsDTO.setFeverBeginDate(medicineLiverSymptomsDO.getFeverBeginDate());
        medicineLiverSymptomsDTO.setFeverDisappearDate(medicineLiverSymptomsDO.getFeverDisappearDate());
        medicineLiverSymptomsDTO.setFeverDischarge(medicineLiverSymptomsDO.getFeverDischarge());
        medicineLiverSymptomsDTO.setRash(medicineLiverSymptomsDO.getRash());
        medicineLiverSymptomsDTO.setRashBeginDate(medicineLiverSymptomsDO.getRashBeginDate());
        medicineLiverSymptomsDTO.setRashDisappearDate(medicineLiverSymptomsDO.getRashDisappearDate());
        medicineLiverSymptomsDTO.setRashDischarge(medicineLiverSymptomsDO.getRashDischarge());
        medicineLiverSymptomsDTO.setSkinItch(medicineLiverSymptomsDO.getSkinItch());
        medicineLiverSymptomsDTO.setSkinItchBeginDate(medicineLiverSymptomsDO.getSkinItchBeginDate());
        medicineLiverSymptomsDTO.setSkinItchDisappearDate(medicineLiverSymptomsDO.getSkinItchDisappearDate());
        medicineLiverSymptomsDTO.setSkinItchDischarge(medicineLiverSymptomsDO.getSkinItchDischarge());

        List<MedicineLiverSymptomsOtherDTO> medicineLiverSymptomsOtherDTOS = new ArrayList<>();
        List<MedicineLiverSymptomsOtherDO> medicineLiverSymptomsOtherDOS = medicineLiverSymptomsDO.getMedicineLiverSymptomsOtherDOs();
        if (!medicineLiverSymptomsOtherDOS.isEmpty() && medicineLiverSymptomsOtherDOS != null) {
            for (MedicineLiverSymptomsOtherDO medicineLiverSymptomsOtherDO : medicineLiverSymptomsOtherDOS) {
                MedicineLiverSymptomsOtherDTO medicineLiverSymptomsOtherDTO = new MedicineLiverSymptomsOtherDTO();
                medicineLiverSymptomsOtherDTO.setBeginDate(medicineLiverSymptomsOtherDO.getBeginDate());
                medicineLiverSymptomsOtherDTO.setDescription(medicineLiverSymptomsOtherDO.getDescription());
                medicineLiverSymptomsOtherDTO.setDisappearDate(medicineLiverSymptomsOtherDO.getDisappearDate());
                medicineLiverSymptomsOtherDTO.setDischargeSymptoms(medicineLiverSymptomsOtherDO.getDischargeSymptoms());
                medicineLiverSymptomsOtherDTO.setId(medicineLiverSymptomsOtherDO.getId());
                medicineLiverSymptomsOtherDTO.setName(medicineLiverSymptomsOtherDO.getName());
                medicineLiverSymptomsOtherDTO.setMedicineLiverSymptomsId(medicineLiverSymptomsOtherDO.getMedicineLiverSymptomsDO().getId());
                medicineLiverSymptomsOtherDTOS.add(medicineLiverSymptomsOtherDTO);
            }
        }
        medicineLiverSymptomsDTO.setMedicineLiverSymptomsOtherDTOs(medicineLiverSymptomsOtherDTOS);
        return medicineLiverSymptomsDTO;
    }

    private MedicineLiverSymptomsDO convertToEntity(MedicineLiverSymptomsDTO medicineLiverSymptomsDTO) {
        MedicineLiverSymptomsDO medicineLiverSymptomsDO = new MedicineLiverSymptomsDO();
        medicineLiverSymptomsDO.setAbdominalDistention(medicineLiverSymptomsDTO.getAbdominalDistention());
        medicineLiverSymptomsDO.setAbdominalDistentionBeginDate(medicineLiverSymptomsDTO.getAbdominalDistentionBeginDate());
        medicineLiverSymptomsDO.setAbdominalDistentionDisappearDate(medicineLiverSymptomsDTO.getAbdominalDistentionDisappearDate());
        medicineLiverSymptomsDO.setAbdominalDistentionDischarge(medicineLiverSymptomsDTO.getAbdominalDistentionDischarge());
        medicineLiverSymptomsDO.setAnorexia(medicineLiverSymptomsDTO.getAnorexia());
        medicineLiverSymptomsDO.setAnorexiaBeginDate(medicineLiverSymptomsDTO.getAnorexiaBeginDate());
        medicineLiverSymptomsDO.setAnorexiaDisappearDate(medicineLiverSymptomsDTO.getAnorexiaDisappearDate());
        medicineLiverSymptomsDO.setAnorexiaDischarge(medicineLiverSymptomsDTO.getAnorexiaDischarge());
        medicineLiverSymptomsDO.setArthralgia(medicineLiverSymptomsDTO.getArthralgia());
        medicineLiverSymptomsDO.setArthralgiaBeginDate(medicineLiverSymptomsDTO.getArthralgiaBeginDate());
        medicineLiverSymptomsDO.setArthralgiaDisappearDate(medicineLiverSymptomsDTO.getArthralgiaDisappearDate());
        medicineLiverSymptomsDO.setArthralgiaDischarge(medicineLiverSymptomsDTO.getArthralgiaDischarge());
        medicineLiverSymptomsDO.setComplete(medicineLiverSymptomsDTO.isComplete());
        medicineLiverSymptomsDO.setWeak(medicineLiverSymptomsDTO.getWeak());
        medicineLiverSymptomsDO.setWeakBeginDate(medicineLiverSymptomsDTO.getWeakBeginDate());
        medicineLiverSymptomsDO.setWeakDisappearDate(medicineLiverSymptomsDTO.getWeakDisappearDate());
        medicineLiverSymptomsDO.setWeakDischarge(medicineLiverSymptomsDTO.getWeakDischarge());
        medicineLiverSymptomsDO.setJaundice(medicineLiverSymptomsDTO.getJaundice());
        medicineLiverSymptomsDO.setJaundiceBeginDate(medicineLiverSymptomsDTO.getJaundiceBeginDate());
        medicineLiverSymptomsDO.setJaundiceDisappearDate(medicineLiverSymptomsDTO.getJaundiceDisappearDate());
        medicineLiverSymptomsDO.setJaundiceDischarge(medicineLiverSymptomsDTO.getJaundiceDischarge());
        medicineLiverSymptomsDO.setNausea(medicineLiverSymptomsDTO.getNausea());
        medicineLiverSymptomsDO.setNauseaBeginDate(medicineLiverSymptomsDTO.getNauseaBeginDate());
        medicineLiverSymptomsDO.setNauseaDisappearDate(medicineLiverSymptomsDTO.getNauseaDisappearDate());
        medicineLiverSymptomsDO.setNauseaDischarge(medicineLiverSymptomsDTO.getNauseaDischarge());
        medicineLiverSymptomsDO.setVomit(medicineLiverSymptomsDTO.getVomit());
        medicineLiverSymptomsDO.setVomitBeginDate(medicineLiverSymptomsDTO.getVomitBeginDate());
        medicineLiverSymptomsDO.setVomitDisappearDate(medicineLiverSymptomsDTO.getVomitDisappearDate());
        medicineLiverSymptomsDO.setVomitDischarge(medicineLiverSymptomsDTO.getVomitDischarge());
        medicineLiverSymptomsDO.setGingivalBleeding(medicineLiverSymptomsDTO.getGingivalBleeding());
        medicineLiverSymptomsDO.setGingivalBleedingBeginDate(medicineLiverSymptomsDTO.getGingivalBleedingBeginDate());
        medicineLiverSymptomsDO.setGingivalBleedingDisappearDate(medicineLiverSymptomsDTO.getGingivalBleedingDisappearDate());
        medicineLiverSymptomsDO.setGingivalBleedingDischarge(medicineLiverSymptomsDTO.getGingivalBleedingDischarge());
        medicineLiverSymptomsDO.setEpistaxis(medicineLiverSymptomsDTO.getEpistaxis());
        medicineLiverSymptomsDO.setEpistaxisBeginDate(medicineLiverSymptomsDTO.getAnorexiaBeginDate());
        medicineLiverSymptomsDO.setEpistaxisDisappearDate(medicineLiverSymptomsDTO.getEpistaxisDisappearDate());
        medicineLiverSymptomsDO.setEpistaxisDischarge(medicineLiverSymptomsDTO.getEpistaxisDischarge());
        medicineLiverSymptomsDO.setLiverInjury(medicineLiverSymptomsDTO.getLiverInjury());
        medicineLiverSymptomsDO.setLiverPain(medicineLiverSymptomsDTO.getLiverPain());
        medicineLiverSymptomsDO.setLiverPainBeginDate(medicineLiverSymptomsDTO.getAnorexiaBeginDate());
        medicineLiverSymptomsDO.setLiverPainDisappearDate(medicineLiverSymptomsDTO.getLiverPainDisappearDate());
        medicineLiverSymptomsDO.setLiverPainDischarge(medicineLiverSymptomsDTO.getLiverPainDischarge());
        medicineLiverSymptomsDO.setHepatomegaly(medicineLiverSymptomsDTO.getHepatomegaly());
        medicineLiverSymptomsDO.setHepatomegalyBeginDate(medicineLiverSymptomsDTO.getHepatomegalyBeginDate());
        medicineLiverSymptomsDO.setHepatomegalyDisappearDate(medicineLiverSymptomsDTO.getHepatomegalyDisappearDate());
        medicineLiverSymptomsDO.setHepatomegalyDischarge(medicineLiverSymptomsDTO.getHepatomegalyDischarge());
        medicineLiverSymptomsDO.setSplenomegaly(medicineLiverSymptomsDTO.getSplenomegaly());
        medicineLiverSymptomsDO.setSplenomegalyBeginDate(medicineLiverSymptomsDTO.getSplenomegalyBeginDate());
        medicineLiverSymptomsDO.setSplenomegalyDisappearDate(medicineLiverSymptomsDTO.getSplenomegalyDisappearDate());
        medicineLiverSymptomsDO.setSplenomegalyDischarge(medicineLiverSymptomsDTO.getSplenomegalyDischarge());
        medicineLiverSymptomsDO.setFever(medicineLiverSymptomsDTO.getFever());
        medicineLiverSymptomsDO.setFeverBeginDate(medicineLiverSymptomsDTO.getFeverBeginDate());
        medicineLiverSymptomsDO.setFeverDisappearDate(medicineLiverSymptomsDTO.getFeverDisappearDate());
        medicineLiverSymptomsDO.setFeverDischarge(medicineLiverSymptomsDTO.getFeverDischarge());
        medicineLiverSymptomsDO.setRash(medicineLiverSymptomsDTO.getRash());
        medicineLiverSymptomsDO.setRashBeginDate(medicineLiverSymptomsDTO.getRashBeginDate());
        medicineLiverSymptomsDO.setRashDisappearDate(medicineLiverSymptomsDTO.getRashDisappearDate());
        medicineLiverSymptomsDO.setRashDischarge(medicineLiverSymptomsDTO.getRashDischarge());
        medicineLiverSymptomsDO.setSkinItch(medicineLiverSymptomsDTO.getSkinItch());
        medicineLiverSymptomsDO.setSkinItchBeginDate(medicineLiverSymptomsDTO.getSkinItchBeginDate());
        medicineLiverSymptomsDO.setSkinItchDisappearDate(medicineLiverSymptomsDTO.getSkinItchDisappearDate());
        medicineLiverSymptomsDO.setSkinItchDischarge(medicineLiverSymptomsDTO.getSkinItchDischarge());
        medicineLiverSymptomsDO.setPatientId(medicineLiverSymptomsDTO.getPatientId());

        List<MedicineLiverSymptomsOtherDO> medicineLiverSymptomsOtherDOS = new ArrayList<>();
        List<MedicineLiverSymptomsOtherDTO> medicineLiverSymptomsOtherDTOS = medicineLiverSymptomsDTO.getMedicineLiverSymptomsOtherDTOs();
        if (!medicineLiverSymptomsOtherDTOS.isEmpty() && medicineLiverSymptomsOtherDTOS != null) {
            for (MedicineLiverSymptomsOtherDTO medicineLiverSymptomsOtherDTO : medicineLiverSymptomsOtherDTOS) {
                MedicineLiverSymptomsOtherDO medicineLiverSymptomsOtherDO = new MedicineLiverSymptomsOtherDO();
                medicineLiverSymptomsOtherDO.setBeginDate(medicineLiverSymptomsOtherDTO.getBeginDate());
                medicineLiverSymptomsOtherDO.setDescription(medicineLiverSymptomsOtherDTO.getDescription());
                medicineLiverSymptomsOtherDO.setDisappearDate(medicineLiverSymptomsOtherDTO.getDisappearDate());
                medicineLiverSymptomsOtherDO.setDischargeSymptoms(medicineLiverSymptomsOtherDTO.getDischargeSymptoms());
                medicineLiverSymptomsOtherDO.setName(medicineLiverSymptomsOtherDTO.getName());
                medicineLiverSymptomsOtherDO.setMedicineLiverSymptomsDO(medicineLiverSymptomsDO);
                medicineLiverSymptomsOtherDOS.add(medicineLiverSymptomsOtherDO);
            }
        }
        medicineLiverSymptomsDO.setMedicineLiverSymptomsOtherDOs(medicineLiverSymptomsOtherDOS);
        return medicineLiverSymptomsDO;
    }

    @Override
    public MedicineLiverSymptomsDTO getMlSymptomsByPatient(int mlPatient) {
        return mlSymptomsRepo.getMlSysptomsByPatientId(mlPatient)!=null?convertToDTO(mlSymptomsRepo.getMlSysptomsByPatientId(mlPatient)):null;
    }

    @Override
    public void saveMlSymptoms(MedicineLiverSymptomsDTO medicineLiverSymptomsDTO) {
        mlSymptomsRepo.save(convertToEntity(medicineLiverSymptomsDTO));
    }
}
