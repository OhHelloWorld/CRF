package app.Utils;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by 10210 on 2017/8/21.
 */
@Service
public class GetAllDateTool {

    /**
     * 返回一个String列表，包含从头到尾的每天的日期加上用药量中间用'$'隔开。 parameters startDate(其实日期)、weeks(治疗周数)
     */
    public ArrayList<String> getTotalDate(String startDate, int weeks, float dosage) {
        ArrayList<String> totalDate = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(startDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        totalDate.add(sdf.format(cal.getTime()) + "$" + dosage);
        for (int i = 1; i <= weeks * 7; i++) {
            cal.add(Calendar.DATE, 1);
            totalDate.add(sdf.format(cal.getTime()) + "$" + dosage);
        }
        System.out.println(totalDate.toString());
        return totalDate;
    }




}
