package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
	
	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		Owner owner = new Owner();
		owner.setId(1L);
		ownerMapService.save(owner);
	}
	
	@Test
	void findAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}
	
	@Test
	void findById() {
	}
	
	@Test
	void save() {
	}
	
	@Test
	void deleteById() {
	}
	
	@Test
	void delete() {
	}
	
	@Test
	void findByLastName() {
	}
}