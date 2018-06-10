package be.ucll.exam.domain;


public class Specialty implements Comparable<Specialty> {

	private long id;
	private String name;
	private int numberOfVotes;
	
	public Specialty() {
	}
	
	public Specialty(String name) throws DomainException {
		this(0,name);
	}
	
	public Specialty(long id, String name) throws DomainException {
	    this.setId(id);
		this.setName(name);
	}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public void setName(String name) throws DomainException {
		if(name == null){
			throw new DomainException("Naam mag niet leeg zijn.");
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public int getNumberOfStars() {
		return getNumberOfVotes()/10;
	}
	
	
	@Override
	public boolean equals(Object object){
		boolean result = false;
		if(object instanceof Specialty){
			result = super.equals(object);
		}
		return result;
		
	}
	
	public void vote(){
		numberOfVotes++;
	}

	public int compareTo(Specialty speciality) {
		return getName().compareTo(speciality.getName());
	}
}
