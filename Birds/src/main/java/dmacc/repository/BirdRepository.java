package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Bird;


/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 2, 2024
 */

@Repository
public interface BirdRepository extends JpaRepository<Bird,Integer>{

}
