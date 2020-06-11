package entidad;

public class Materias {

	//Atributos
	int ID;
	String Descripcion;
	
	//Constructores
	public Materias(int id , String desc)
	{
		ID = id;
		Descripcion = desc;
	}
	
	public Materias()
	{
		
	}

	//Gets y Sets
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	//toString();
	@Override
	public String toString() {
		return "Materias [ID=" + ID + ", Descripcion=" + Descripcion + "]";
	}	
	
}
