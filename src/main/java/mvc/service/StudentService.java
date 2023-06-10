package mvc.service;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import com.sun.glass.ui.View;
import mvc.dao.StudentDao;
import mvc.dto.Student;
@Service
public class StudentService {
@Autowired
StudentDao dao;
private Object list;
public ModelAndView save(Student student, String date) {
	student.setDob(Date.valueOf(date));
	student.setAge(Period.between(LocalDate.parse(date), LocalDate.now()).getYears());
	dao.save(student);
	ModelAndView view=new ModelAndView();
	view.setViewName("Home.jsp");
	view.addObject("success","Data Added Successfully");
	return view;
	
}
public ModelAndView fetchAll() {
	ModelAndView view=new ModelAndView();
	List<Student> list=dao.fetchAll();
	if(list.isEmpty())
	{
		view.addObject("fail","No Data Found");
		view.setViewName("Home.jsp");
	}
	else{
		view.setViewName("Result.jsp");
		view.addObject("list",list);
	}
	return view;
}

public ModelAndView fetchbyname(String name) {
	ModelAndView view=new ModelAndView();
	List<Student> list=dao.fetchByName(name);
	if(list.isEmpty())
	{
		view.addObject("fail","No Data Found");
		view.setViewName("Home.jsp");
	}
	else{
		view.setViewName("Result.jsp");
		view.addObject("list",list);
	}
	return view;
}
public ModelAndView delete(int id) {
	ModelAndView view=new ModelAndView();
	dao.delete(id);
	List<Student> list=dao.fetchAll();
	if(list.isEmpty())
	{
		view.addObject("fail","Deleted success no data found");
		view.setViewName("Home.jsp");
	}
	else{
		view.addObject("list",list);
		view.addObject("success","Deleted Success");
		view.setViewName("Result.jsp");
		
	}
	return view;
}
public ModelAndView edit(int id) {
	ModelAndView view=new ModelAndView("Edit.jsp");
	Student student=dao.fetchById(id);
	view.addObject("student",student);
	return view;
}



}
