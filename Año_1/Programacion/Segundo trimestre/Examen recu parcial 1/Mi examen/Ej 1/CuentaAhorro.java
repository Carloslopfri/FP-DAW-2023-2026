/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej1;

public class CuentaAhorro extends CuentaBancaria {
    private double interesAnual;

    public CuentaAhorro(Persona titular, double saldo, int CCC, double interesAnual) {

        super(titular.getNombre() + " " + titular.getApellidos(), saldo, CCC);

        this.interesAnual = interesAnual;

    }

    public double getInteresAnual() {

        return interesAnual;

    }

    public void setInteresAnual(double interesAnual) {

        this.interesAnual = interesAnual;

    }

    public void calcularInteres() {

        double interes = getSaldo() * interesAnual / 100;

        setSaldo(getSaldo() + interes);

    }

}
