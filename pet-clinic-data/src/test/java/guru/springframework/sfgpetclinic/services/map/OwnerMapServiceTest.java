package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
	Long ownerId1 = 1L;
	Long ownerId2 = 2L;
	
	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		Owner owner = new Owner();
		owner.setId(ownerId1);
		ownerMapService.save(owner);
	}
	
	@Test
	void findAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}
	
	@Test
	void findById() {
		Owner owner = ownerMapService.findById(ownerId1);
		assertEquals(ownerId1, owner.getId());
	}
	
	@Test
	void saveExistingId() {
		Long id = 2L;
		Owner owner = new Owner();
		owner.setId(id);
		assertEquals(id, owner.getId());
	}
	
	@Test
	void saveNoId() {
		Owner owner = ownerMapService(new Owner());
		assertNotNull(owner);
		assertNotNull(owner.getId());
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