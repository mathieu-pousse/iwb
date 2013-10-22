package org.iwb.bootstrap;

import org.iwb.business.*;
import org.iwb.services.LocationService;
import org.iwb.services.MaterialService;
import org.iwb.services.ProductService;
import org.iwb.services.SecondLifeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class AutomatedScenarioRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutomatedScenarioRunner.class);

    @Autowired
    private LocationService locationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private SecondLifeService secondLifeService;

    /**
     * Run the scenario.
     */
    public void run() {
        LOGGER.debug("initializing the application with dummy values");

        injectLocations();
        injectMaterials();
        injectProducts();
        injectSecondLives();

        LOGGER.debug("dummy values were successfully loaded");
    }

    /**
     * Add some second life definitions.
     */
    private void injectSecondLives() {
        List<Material> materials = this.materialService.findAll();
        for (final Location location : this.locationService.findAll()) {
            for (final Material material : materials) {
                injectSecondLife(location, material, location.getTrashes().get((int) (Math.random() * location.getTrashes().size())));
            }
        }
    }

    /**
     * Add a second life definition.
     *
     * @param location the location
     * @param material the material
     * @param trash    the selected trash
     * @return the saved second life
     */
    private SecondLife injectSecondLife(final Location location, final Material material, final Trash trash) {
        SecondLife secondLife = new SecondLife();
        secondLife.setLocationId(location.getId());
        secondLife.setMaterialId(material.getId());
        secondLife.setTrash(trash.getColor());

        return this.secondLifeService.save(secondLife);
    }

    /**
     * Add some products.
     */
    private void injectProducts() {
        List<Material> materials = this.materialService.findAll();
        for (int i = 0; i < 4; i++) {
            injectProduct("food " + i, "food packaging " + i, "food-" + i + ".png",
                    component("emballage", "boite carton", materials.get(0)),
                    component("film plastique", "autour de la barquette", materials.get(1)),
                    component("barquette", "contenant", materials.get(2)),
                    component("biscuit", "nouriture", materials.get(3))
            );
        }
    }

    /**
     * Create a component.
     *
     * @param name        the name
     * @param description the description
     * @param material    the material
     * @return see description
     */
    private Component component(final String name, final String description, final Material material) {
        Component component = new Component();
        component.setName(name);
        component.setDescription(description);
        if (material != null) {
            component.setMaterialId(material.getId());
        }
        return component;
    }

    /**
     * Add a second life definition.
     *
     * @param name        the name
     * @param description the description
     * @param image       the image
     * @param components  the components
     * @return the saved product
     */
    private Product injectProduct(final String name, final String description, final String image, final Component... components) {
        Product product = new Product();
        product.setEan13(3123456789012L);
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setComponents(Arrays.asList(components));
        product.setTags(Arrays.asList("tag-1", "tag-2"));

        return this.productService.save(product);
    }

    /**
     * Add some locations.
     */
    private void injectLocations() {
        Location rennes = injectLocation("Rennes", "Rennes Metropole", 35000, 35100);
        Trash yellow = new Trash();
        yellow.setColor("yellow");
        yellow.setDescription("save a bit the planet");
        rennes.getTrashes().add(yellow);

        this.locationService.update(rennes);

        injectLocation("Paris", "Paris et la courrone", 75000, 77000, 78000, 92000);
        injectLocation("Reims", "Reims Metropole", 51000);
        injectLocation("Marseille", "Marseille agglomeration", 13000);
        injectLocation("Nice", "Nice plage", 6000);
        injectLocation("Lorient", "Lorient plage", 56100);
    }

    /**
     * Add the location.
     *
     * @param name        the name
     * @param description the description
     * @param zips        the zip code
     * @return the saved location
     */
    private Location injectLocation(final String name, final String description, final Integer... zips) {
        Location location = new Location();
        location.setName(name);
        location.setDescription(description);
        location.setZips(Arrays.asList(zips));

        Trash everything = new Trash();
        everything.setColor("black");
        everything.setDescription("everything can goes here but...");
        everything.setImage("black.png");
        location.setTrashes(new ArrayList<Trash>());
        location.getTrashes().add(everything);

        return this.locationService.save(location);
    }


    /**
     * Add some materials.
     */
    public void injectMaterials() {
        injectMaterial("default");
        injectMaterial("Emballage carton");
        injectMaterial("Barquette plastique");
        injectMaterial("Film plastique");
        injectMaterial("Nourriture 4");
        injectMaterial("Nourriture 5");
        injectMaterial("Nourriture 6");
        injectMaterial("Nourriture 7");
        injectMaterial("Nourriture 8");
        injectMaterial("Nourriture 9");
        injectMaterial("Nourriture 10");
    }

    /**
     * Add the material.
     *
     * @param name the name
     * @return the saved material
     */
    private Material injectMaterial(final String name) {
        Material material = new Material();
        material.setName(name);
        material.setDescription("description : " + name);

        return this.materialService.save(material);
    }

}
