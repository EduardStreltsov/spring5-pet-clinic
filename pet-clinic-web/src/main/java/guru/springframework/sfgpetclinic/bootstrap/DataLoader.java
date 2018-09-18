package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}
	
	private void loadData() {
		Speciality speciality = new Speciality();
		speciality.setId(1L);
		speciality.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(speciality);
		
		speciality = new Speciality();
		speciality.setId(2L);
		speciality.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(speciality);
		
		speciality = new Speciality();
		speciality.setId(3L);
		speciality.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(speciality);
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("FN1");
		owner1.setLastName("LN1");
		owner1.setAddress("street 1");
		owner1.setCity("city1");
		owner1.setTelephone("000-000-000");
		
		Pet pet1 = new Pet();
		pet1.setName("pet1");
		pet1.setPetType(savedDogPetType);
		pet1.setOwner(owner1);
		pet1.setBirthDate(LocalDate.now());
		owner1.getPets().add(pet1);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("FN2");
		owner2.setLastName("LN2");
		owner2.setAddress("street 2");
		owner2.setCity("city2");
		owner2.setTelephone("000-000-111");
		
		Pet pet2 = new Pet();
		pet2.setName("pet2");
		pet2.setPetType(savedCatPetType);
		pet2.setOwner(owner2);
		pet2.setBirthDate(LocalDate.now());
		owner2.getPets().add(pet2);
		
		ownerService.save(owner2);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Vet1");
		vet1.setLastName("Last Name 1");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Vet2");
		vet2.setLastName("Last Name 2");
		vet2.getSpecialities().add(savedSurgery);
		vetService.save(vet2);
		
		Vet vet3 = new Vet();
		vet3.setFirstName("Vet3");
		vet3.setLastName("Last Name 3");
		vet3.getSpecialities().add(savedDentistry);
		vetService.save(vet3);
		
		Visit catVisit = new Visit();
		catVisit.setPet(pet2);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");
		
		visitService.save(catVisit);
	}
}
