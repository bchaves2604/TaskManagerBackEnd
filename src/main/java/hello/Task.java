package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Task
{
	private int id;
	private String name;
	private Date dueDate;
	private boolean isCompleted;

	public static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	public static ArrayList<Task> taskList = new ArrayList <Task>();
	//private  Long counter = Ta	skController.getCounter();

	

	public Task()
	{


	}
	public Task(String name, String date)
	{
		//this.id= counter != null ? counter.intValue() : null;
		this.name=name;
		this.isCompleted=false;
		try
		{
			this.dueDate=format.parse(date);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}
	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id=id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public Date getDueDate()
	{
		return this.dueDate;
	}

	public void setDueDate(Date date)
	{
		this.dueDate=date;
	}

	public boolean getCompleted()
	{
		return this.isCompleted;
	}

	public void setCompleted()
	{
		this.isCompleted= (this.isCompleted) ? false : true;
	}

	public static void addTask(Task task)
	{
		taskList.add(task);
	}


	public static ArrayList<Task> getPendingTasks(){
		ArrayList<Task> pendingTasks= new ArrayList<Task>();
		for(int i=0; i<taskList.size();i++)
		{
			if(!taskList.get(i).getCompleted())
			{
				System.out.println(taskList.get(i).getId());
				pendingTasks.add(taskList.get(i));
			}
		}
		return pendingTasks;
	}

	public static Task searchTask(String taskId)
	{

		for(int i=0; i<taskList.size();i++)
		{
			if(Integer.toString(taskList.get(i).getId()).equals(taskId) || taskList.get(i).getName().equals(taskId))
			{
				return taskList.get(i);
			}	
		}
		return null;
	}
	public static boolean deleteTask(int id)
	{
		if(taskList.size()>0)
		{
			for(int i=0; i<taskList.size();i++)
			{
				if(taskList.get(i).getId()==id)
				{
					taskList.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public static boolean updateTask(int id, String newName, Date newDueDate)
	{
		for(int i=0; i<taskList.size();i++)
		{
			if(taskList.get(i).getId()==id)
			{
				System.out.println("in");
				Task task= taskList.get(i);
				task.setName(newName);
				task.setDueDate(newDueDate);
				return true;
			}
		}
		System.out.println("out");
		return false;
	}

	public static boolean completeTask(Integer id)
	{
		for(int i=0; i<taskList.size();i++)
		{
			if(taskList.get(i).getId()==id)
			{
				Task task= taskList.get(i);
				task.setCompleted();
				return true;
			}
		}
	return false;
	}

}