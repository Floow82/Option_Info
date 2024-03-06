package fr.ensma.a3.ia.exo2_1;

public interface IBal<Mess extends IBalMessages> {

    void senMessage(final Mess m);
    Mess receptionMessage();

}
