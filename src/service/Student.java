package service;

public class Student 
{
	private  String id;
	private  String name;
	private  int  lab[]= new int[5];
	private  int  project[]= new int[5];
	private  int  total[]= new int[5];
	private  int  grandTotal;
	
	

	public Student(String id, String name, int[] lab, int[] project, int[] total, int grandTotal) {
		super();
		this.id = id;
		this.name = name;
		this.lab = lab;
		this.project = project;
		this.total = total;
		this.grandTotal = grandTotal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getLab() {
		return lab;
	}

	public void setLab(int[] lab) {
		this.lab = lab;
	}

	public int[] getProject() {
		return project;
	}

	public void setProject(int[] project) {
		this.project = project;
	}

	public int[] getTotal() {
		return total;
	}

	public void setTotal(int[] total) {
		this.total = total;
	}
	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

}
