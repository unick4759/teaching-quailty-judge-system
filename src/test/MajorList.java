package test;

import java.util.List;

import com.entity.MajorInfo;
import com.service.MajorInfoService;
import com.service.Impl.MajorInfoServiceImpl;

public class MajorList {
	public static void main(String[] args) {
		MajorInfoService ms=new MajorInfoServiceImpl();
		List<MajorInfo>list=ms.selectAll();
		for(MajorInfo m:list) {
			System.out.println(m);
		}
	}
}
