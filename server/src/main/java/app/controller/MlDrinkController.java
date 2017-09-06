//package app.controller;
//
//import app.dto.MedicineLiverDrinkDTO;
//import app.service.MlDrinkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by Administrator on 2017/9/5 0005.
// */
//@RestController
//@RequestMapping(path = "/api/mlDrink")
//public class MlDrinkController {
//
//    @Autowired
//    private MlDrinkService mlDrinkService;
//
//    @GetMapping(path = "/{mlPatientId}")
//    public MedicineLiverDrinkDTO getMlDrinkByPatientId(@PathVariable int mlPatientId){
//        return mlDrinkService.getMlDrink(mlPatientId);
//    }
//
//    @PostMapping(path="")
//    public void saveMlDiseaseHistory(@RequestBody MedicineLiverDrinkDTO mlDrinkDTO){
//        mlDrinkService.saveMlDrink(mlDrinkDTO);
//    }
//}
