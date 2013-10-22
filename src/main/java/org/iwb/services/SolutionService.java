package org.iwb.services;

import org.iwb.business.Component;
import org.iwb.business.SecondLife;

import java.util.List;
import java.util.Map;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface SolutionService {


    Map<Component, SecondLife> resolve(List<Component> components);

}
