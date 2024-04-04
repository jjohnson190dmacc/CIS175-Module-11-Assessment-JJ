package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 2, 2024
 */

@Entity
@Data
public class Bird {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int birdID;
	
	@NotEmpty(message="Please enter the Bird's Common Name.")
	@Size(min=4, max=45, message="Must be between 4-45 characters.")
	private String commonName;
	@NotEmpty(message="Please enter the Bird's Scientific Name.")
	@Size(min=4, max=45, message="Must be between 4-45 characters.")
	private String scientificName;
	
}
