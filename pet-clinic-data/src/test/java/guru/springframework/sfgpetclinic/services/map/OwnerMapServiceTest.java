package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
	
	final Long ownerId1 = 1L;
	final Long ownerId2 = 2L;
	final String lastName = "Smith";
	
	@BeforeEach
	void setUp() {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		ownerMapService.save(Owner.builder().id(ownerId1).lastName(lastName).build());
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
		Owner owner = ownerMapService.save(Owner.builder().id(ownerId1).build());
		assertEquals(ownerId1, owner.getId());
	}
	
	@Test
	void saveNoId() {
		Owner owner = ownerMapService.save(Owner.builder().build());
		assertNotNull(owner);
		assertNotNull(owner.getId());
	}
	
	@Test
	void delete() {
		ownerMapService.delete(ownerMapService.findById(ownerId1));
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void deleteById() {
		ownerMapService.deleteById(ownerId1);
		assertEquals(0, ownerMapService.findAll().size());
	}
	
	@Test
	void findByLastName() {
		Owner owner = ownerMapService.findByLastName(lastName);
		assertNotNull(owner);
		assertEquals(lastName, owner.getLastName());
	}
	
	@Test
	void findByLastNameNegative() {
		Owner owner = ownerMapService.findByLastName("foo");
		assertNull(owner);
	}
}