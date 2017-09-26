package app.serviceImpl;

import app.Utils.CreateAllExcelInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import app.Utils.CreateAllExcel;
import app.Utils.CreateFourDiaExcel;
import app.repo.FourDiagnosticInformationRepo;
import app.service.CreateExcelService;

@Service
public class CreateExcelServiceImpl implements CreateExcelService {

    @Autowired
    private CreateFourDiaExcel createFourDiaExcel;

    @Autowired
    @Qualifier("createAllExcel")
    private CreateAllExcelInterface creaetAllExcel;

    @Autowired
    private FourDiagnosticInformationRepo fourDiaRepo;

    @Override
    public void createFourDiaExcel(int fourDiaId) {
        try {
            createFourDiaExcel.createFourDiaExcel(fourDiaRepo.findOne(fourDiaId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createAllExcel() {
        try {
            creaetAllExcel.createAllExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
