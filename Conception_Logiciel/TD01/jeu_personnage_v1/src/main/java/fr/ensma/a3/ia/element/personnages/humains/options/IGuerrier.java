package fr.ensma.a3.ia.element.personnages.humains.options;

import fr.ensma.a3.ia.element.comportement.IAttaquable;
import fr.ensma.a3.ia.element.comportement.IAttaqueTerre;
import fr.ensma.a3.ia.element.comportement.IDeplacable;
import fr.ensma.a3.ia.element.comportement.attaques.ICompoAttaque;
import fr.ensma.a3.ia.element.comportement.deplacement.IDeplacement;
import fr.ensma.a3.ia.utils.ValParamException;

public interface IGuerrier extends IAttaqueTerre, IAttaquable, IDeplacable {
     void arret();
     void setCompAtt(final ICompoAttaque att) throws ValParamException;
     void setCompDep(final IDeplacement dep) throws ValParamException;
}
