package tn.esprit.spring.entites;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {

    @Autowired
    IEntrepriseService entrepriseService;
    @Autowired
    EntrepriseRepository entrepriseRepository;


    @Test
    public void testaddEntreprise() {
        Entreprise entreprise = new Entreprise("name","raisonSocial");
        int id = entrepriseService.ajouterEntreprise(entreprise);
        Assert.assertEquals(1, id);
    }

    @Test
    public void testaddDepartment() {
        Departement dep = new Departement("name");
        int id = entrepriseService.ajouterDepartement(dep);
        Assert.assertEquals(1, id);
    }

    @Test
    public void testdeleteEmployeById() {
        entrepriseService.deleteEntrepriseById(1);
        assertThat(entrepriseRepository.existsById(1)).isFalse();
    }


}
