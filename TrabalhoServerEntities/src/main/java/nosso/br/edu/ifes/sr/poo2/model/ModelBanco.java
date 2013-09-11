package nosso.br.edu.ifes.sr.poo2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import nosso.br.edu.ifes.sr.poo2.model.ModelBanco;

@MappedSuperclass
public abstract class ModelBanco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ModelBanco) {
        	ModelBanco o = (ModelBanco) obj;
            if (this.id != null && this.id == o.id) {
                return true;
            }
        }
        return false;
    }
}
