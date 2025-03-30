package com.example.imccalculator;

/**
 * Classe utilitária para cálculos relacionados ao IMC
 */
public class ImcUtil {

    /**
     * Calcula o IMC usando a fórmula padrão
     * @param peso em quilogramas
     * @param altura em metros
     * @return valor do IMC
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Retorna a categoria do IMC baseado no valor calculado
     * @param imc valor do IMC
     * @return String representando a categoria do IMC
     */
    public static String categorizarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do Peso";
        } else if (imc < 25) {
            return "Peso Normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade Grau 1";
        } else if (imc < 40) {
            return "Obesidade Grau 2";
        } else {
            return "Obesidade Grau 3";
        }
    }

    /**
     * Retorna uma estimativa de peso ideal baseado na altura e IMC desejado (22)
     * @param altura em metros
     * @return peso ideal estimado em kg
     */
    public static double calcularPesoIdeal(double altura) {
        // Usando IMC de 22 como referência para "peso ideal"
        return 22 * (altura * altura);
    }

    /**
     * Calcula a diferença para o peso ideal
     * @param pesoAtual em kg
     * @param altura em metros
     * @return diferença para o peso ideal (negativo se precisa perder, positivo se precisa ganhar)
     */
    public static double diferencaPesoIdeal(double pesoAtual, double altura) {
        double pesoIdeal = calcularPesoIdeal(altura);
        return pesoIdeal - pesoAtual;
    }
}