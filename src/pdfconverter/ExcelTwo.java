package pdfconverter;

public class ExcelTwo 
{
	private String id;
	private String name;
	private String lab;
	private String project;
	private String total;
	
	public ExcelTwo(String id, String name, String string, String string2, String string3) {
		super();
		this.id = id;
		this.name = name;
		this.lab = string;
		this.project = string2;
		this.total = string3;
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

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
