//package app.serviceImpl;
//
//import app.dto.MedicineLiverDrinkDTO;
//import app.dto.MedicineLiverDrinkDetailDTO;
//import app.entities.MedicineLiverDrinkDO;
//import app.entities.MedicineLiverDrinkDetailDO;
//import app.repo.MlDrinkRepo;
//import app.service.MlDrinkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Administrator on 2017/9/5 0005.
// */
//@Service
//public class MlDrinkServiceImpl implements MlDrinkService{
//
//    @Autowired
//    private MlDrinkRepo mlDrinkRepo;
//
//    private MedicineLiverDrinkDTO convertToDTO(MedicineLiverDrinkDO medicineLiverDrinkDO){
//        MedicineLiverDrinkDTO medicineLiverDrinkDTO = new MedicineLiverDrinkDTO();
//        medicineLiverDrinkDTO.setPatientId(medicineLiverDrinkDO.getPatientId());
//        medicineLiverDrinkDTO.setComplete(medicineLiverDrinkDO.isComplete());
//        medicineLiverDrinkDTO.setDrinkHistory(medicineLiverDrinkDO.getDrinkHistory());
//        medicineLiverDrinkDTO.setId(medicineLiverDrinkDO.getId());
//        List<MedicineLiverDrinkDetailDTO> medicineLiverDrinkDetailDTOS = new ArrayList<>();
//        List<MedicineLiverDrinkDetailDO> medicineLiverDrinkDetailDOS = medicineLiverDrinkDO.getMedicineLiverDrinkDetailDOS();
//        if(!medicineLiverDrinkDetailDOS.isEmpty() && medicineLiverDrinkDetailDOS != null){
//            for(MedicineLiverDrinkDetailDO medicineLiverDrinkDetailDO : medicineLiverDrinkDetailDOS){
//                MedicineLiverDrinkDetailDTO medicineLiverDrinkDetailDTO = new MedicineLiverDrinkDetailDTO();
//                medicineLiverDrinkDetailDTO.setId(medicineLiverDrinkDetailDO.getId());
//                medicineLiverDrinkDetailDTO.setDrinkLife(medicineLiverDrinkDetailDO.getDrinkLife());
//                medicineLiverDrinkDetailDTO.setDrinkQuantity(medicineLiverDrinkDetailDO.getDrinkQuantity());
//                medicineLiverDrinkDetailDTO.setDrinkType(medicineLiverDrinkDetailDO.getDrinkType());
//                medicineLiverDrinkDetailDTO.setProof(medicineLiverDrinkDetailDO.getProof());
//                medicineLiverDrinkDetailDTO.setMedicineLiverDrinkId(medicineLiverDrinkDetailDO.getMedicineLiverDrinkDO().getId());
//                medicineLiverDrinkDetailDTOS.add(medicineLiverDrinkDetailDTO);
//            }
//        }
//        medicineLiverDrinkDTO.setMedicineLiverDrinkDetailDTOS(medicineLiverDrinkDetailDTOS);
//        return medicineLiverDrinkDTO;
//    }
//
//    private MedicineLiverDrinkDO convertToEntity(MedicineLiverDrinkDTO medicineLiverDrinkDTO){
//        MedicineLiverDrinkDO medicineLiverDrinkDO = new MedicineLiverDrinkDO();
//        medicineLiverDrinkDO.setComplete(medicineLiverDrinkDTO.isComplete());
//        medicineLiverDrinkDO.setDrinkHistory(medicineLiverDrinkDTO.getDrinkHistory());
//        medicineLiverDrinkDO.setPatientId(medicineLiverDrinkDTO.getPatientId());
//        List<MedicineLiverDrinkDetailDO> medicineLiverDrinkDetailDOS = new ArrayList<>();
//        List<MedicineLiverDrinkDetailDTO> medicineLiverDrinkDetailDTOS = medicineLiverDrinkDTO.getMedicineLiverDrinkDetailDTOS();
//        if(!medicineLiverDrinkDetailDTOS.isEmpty() && medicineLiverDrinkDetailDTOS != null){
//            for(MedicineLiverDrinkDetailDTO medicineLiverDrinkDetailDTO : medicineLiverDrinkDetailDTOS){
//                MedicineLiverDrinkDetailDO medicineLiverDrinkDetailDO = new MedicineLiverDrinkDetailDO();
//                medicineLiverDrinkDetailDO.setProof(medicineLiverDrinkDetailDTO.getProof());
//                medicineLiverDrinkDetailDO.setDrinkLife(medicineLiverDrinkDetailDTO.getDrinkLife());
//                medicineLiverDrinkDetailDO.setDrinkQuantity(medicineLiverDrinkDetailDTO.getDrinkQuantity());
//                medicineLiverDrinkDetailDO.setDrinkType(medicineLiverDrinkDetailDTO.getDrinkType());
//                medicineLiverDrinkDetailDO.setMedicineLiverDrinkDO(medicineLiverDrinkDO);
//                medicineLiverDrinkDetailDOS.add(medicineLiverDrinkDetailDO);
//            }
//        }
//        medicineLiverDrinkDO.setMedicineLiverDrinkDetailDOS(medicineLiverDrinkDetailDOS);
//        return medicineLiverDrinkDO;
//    }
//
//    @Override
//    public MedicineLiverDrinkDTO getMlDrink(int mlPatientId) {
//        return mlDrinkRepo.getMlDrinkByPatientId(mlPatientId) != null?convertToDTO(mlDrinkRepo.getMlDrinkByPatientId(mlPatientId)):null;
//    }
//
//    @Override
//    public void saveMlDrink(MedicineLiverDrinkDTO mlDrink) {
//        mlDrinkRepo.save(convertToEntity(mlDrink));
//    }
//}
