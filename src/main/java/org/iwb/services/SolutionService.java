package org.iwb.services;

import org.iwb.business.Component;
import org.iwb.business.MaterialSecondLife;

import java.util.List;
import java.util.Map;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface SolutionService {


    Map<Component, MaterialSecondLife> resolve(List<Component> components);

}
