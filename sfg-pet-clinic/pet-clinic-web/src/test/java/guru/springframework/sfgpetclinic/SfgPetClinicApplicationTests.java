package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SfgPetClinicApplicationTests {

	@Autowired
	ApplicationContext context;
	VetService veterinarianService;
	OwnerService ownerService;

	@BeforeEach
	public void setUp() {
		ownerService = context.getBean(OwnerServiceMap.class);
		veterinarianService = context.getBean(VetService.class);
	}
	@Test
	void testOwnerService() {
		assertEquals(2, ownerService.findAll().size());
	}

	@Test
	void testVeterinarianService() {
		assertEquals(2, veterinarianService.findAll().size());
	}

}
