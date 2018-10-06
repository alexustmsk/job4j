package ru.job4j.profession;

public class Doctor extends Profession {
    public Doctor(String name) {
        super(name);
    }
    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }
}
