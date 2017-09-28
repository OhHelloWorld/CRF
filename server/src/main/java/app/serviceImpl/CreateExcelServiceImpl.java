package app.serviceImpl;

import app.Utils.CreateAllExcel;
import app.Utils.MlCreateAllExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Utils.CreateFourDiaExcel;
import app.repo.FourDiagnosticInformationRepo;
import app.service.CreateExcelService;

@Service
public class CreateExcelServiceImpl implements CreateExcelService {

    @Autowired
    private CreateFourDiaExcel createFourDiaExcel;

    @Autowired
    private CreateAllExcel creaetAllExcel;

    @Autowired
    private MlCreateAllExcel mlCreateAllExcel;

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

    @Override
    public void createMlAllExcel() {
        try {
            mlCreateAllExcel.createAllExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
